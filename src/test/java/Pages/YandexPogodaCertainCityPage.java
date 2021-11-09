package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class YandexPogodaCertainCityPage extends BasePage{

    public static SelenideElement yandexCertainCityNowTempValue = $x(
            "//div[@class='temp fact__temp fact__temp_size_s']//span[@class='temp__value temp__value_with-unit']");
}
