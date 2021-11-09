package Tests;

import Pages.BasePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static Pages.GismeteoCertainCityPage.gismeteoCertainCityNowTempValue;
import static Pages.GismeteoIndexPage.gismeteoFirstSuggesstion;
import static Pages.GismeteoIndexPage.gismeteoSearch;
import static Pages.YandexPogodaCertainCityPage.yandexCertainCityNowTempValue;
import static Pages.YandexPogodaIndexPage.yandexFirstSuggesstion;
import static Pages.YandexPogodaIndexPage.yandexSearch;
import static Utils.CommonConditions.*;
import static Utils.StringManager.getIntValueOfNowTemp;

@DisplayName("UITests")
public class WeatherInCitiesTests extends BaseTest{

    @ParameterizedTest(name = "Check {0} on Gismeteo is equal to {1} on YandexPogoda")
    @MethodSource("parametersForComparing")
    public void compareTempInDifferentCititesOnDifferentSources(String firstCity, String secondCity) {
        BasePage bp = new BasePage()
                .openGismeteo()
                .setValue(gismeteoSearch, firstCity)
                .goToGismeteoCertainCityPage(gismeteoFirstSuggesstion);

        getIntValueOfNowTemp(gismeteoCertainCityNowTempValue);

        bp.openYandexPogoda()
                .setValue(yandexSearch, secondCity)
                .goToYandexCertainCityPage(yandexFirstSuggesstion);

        getIntValueOfNowTemp(yandexCertainCityNowTempValue);

        assertThatNowTempValuesForDifferenCitiesAreSame(gismeteoNowTempValue, yandexNowTempValue);

    }

    public static Stream<Arguments> parametersForComparing() {
        return Stream.of(
                Arguments.of(moscow, penza),
                Arguments.of(penza, moscow)
        );
    }

}
