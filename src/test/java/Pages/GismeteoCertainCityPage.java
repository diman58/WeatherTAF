package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class GismeteoCertainCityPage extends BasePage{

    public static SelenideElement gismeteoCertainCityNowTempValue = $x(
            "//span[@class='js_value tab-weather__value_l']");
}
