package Tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static Utils.CommonConditions.*;
import static Utils.StringManager.getTextValueAndConvertToInt;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@DisplayName("UITests")
public class ScriptTest extends BaseTest {

    @Test()
    @DisplayName("Check Moscow on Gismeteo and YandexPogoda are equal")
    public void scriptTest() {

        open(gismeteo);
        $("input.search_input").setValue(moscow);
        $("div.found__list a[href='/weather-moscow-4368/']").shouldBe(Condition.enabled,
                Duration.ofSeconds(6)).click();
        moscowsGismeteoNowTempValue = getTextValueAndConvertToInt(
                "span[class='unit unit_temperature_c'] span[class='js_value tab-weather__value_l']");

        open(yandexPogoda);
        $("input[class='mini-suggest-form__input mini-suggest__input']").setValue(moscow);
        $("a[href='https://yandex.ru/pogoda/213/']").shouldBe(Condition.enabled,
                Duration.ofSeconds(5)).click();
        moscowsYandexNowTempValue = getTextValueAndConvertToInt(
                "div[class='temp fact__temp fact__temp_size_s'] span[class='temp__value temp__value_with-unit']");

        assertThatNowTempValuesAreSame(moscowsGismeteoNowTempValue,moscowsYandexNowTempValue);
    }
}
