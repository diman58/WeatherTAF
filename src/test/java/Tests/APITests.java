package Tests;

import Utils.ProfilePojo;
import io.qameta.allure.Attachment;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static Utils.CommonConditions.*;
import static Utils.ProfilePojo.getProfile;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("APITests")
public class APITests extends BaseTest {

    @Test
    @DisplayName("Check that email value in responce matches Users")
    public void checkIdMatches() {
         given()
                .spec(REQ_SPEC)
                .when().get()
                .then()
                .statusCode(200)
                .body("id", equalTo(usersId));
    }

    @Test
    @DisplayName("Check that profile's values in responce matches Users")
    public void checkProfileMatches() {
        ProfilePojo tempProfile = given().spec(REQ_SPEC)
                .when().get()
                .then()
                .statusCode(200)
                .extract().body().as(ProfilePojo.class);

        assertResponceProfileEqualUser(tempProfile);
    }
}
