package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static Utils.CommonConditions.gismeteo;
import static Utils.CommonConditions.yandexPogoda;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BasePage {

    public BasePage openGismeteo() {
        open(gismeteo);
        return new GismeteoIndexPage();
    }

    public BasePage setValue(SelenideElement element, String value) {
        element.setValue(value).shouldBe(Condition.enabled);
        return this;
    }

    public BasePage goToGismeteoCertainCityPage(SelenideElement element) {
        $(element).shouldBe(Condition.appear, Duration.ofSeconds(6))
                .shouldBe(Condition.enabled, Duration.ofSeconds(6))
                .click();
        return new GismeteoCertainCityPage();
    }

    public BasePage goToYandexCertainCityPage(SelenideElement element) {
        $(element).shouldBe(Condition.appear, Duration.ofSeconds(6))
                .shouldBe(Condition.enabled, Duration.ofSeconds(6))
                .click();
        return new YandexPogodaCertainCityPage();
    }

    public BasePage openYandexPogoda() {
        open(yandexPogoda);
        return new YandexPogodaIndexPage();
    }


}
