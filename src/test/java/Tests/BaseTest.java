package Tests;

import Utils.ProfilePojo;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static Utils.CommonConditions.usersId;
import static Utils.ProfilePojo.getProfile;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BaseTest {

    @Step()
    protected static void assertThatNowTempValuesAreSame(int gismeteo, int yandexPogoda) {
        assertThat(gismeteo).isEqualTo(yandexPogoda);
    }

    @Step()
    protected static void assertThatNowTempValuesForDifferenCitiesAreSame(int gismeteoNowTempValue, int yandexNowTempValue) {
        assertThat(gismeteoNowTempValue).isEqualTo(yandexNowTempValue);
    }

    @Step
    protected static void assertResponceProfileEqualUser(ProfilePojo tempProfile) {
        assertTrue(tempProfile.equals(getProfile()));
    }

    @Step
    protected static void assertIdMatchesUsers(String id) {
        AssertionsForClassTypes.assertThat(id).isEqualTo(usersId);
    }

    @BeforeAll
    public static void browserSetUp() {
        prepareBrowser();
    }

    @AfterAll
    public static void tearDown() {
        browserTearDown();
    }

    public static void prepareBrowser() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(false).savePageSource(false));
        Configuration.browserSize = "1920x1080";
        open();
    }

    public static void browserTearDown() {
        SelenideLogger.removeListener("AllureSelenide");
    }
}
