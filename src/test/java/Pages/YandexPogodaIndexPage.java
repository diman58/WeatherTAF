package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class YandexPogodaIndexPage extends BasePage{

    public static SelenideElement yandexSearch = $x("//input");
    public static SelenideElement yandexFirstSuggesstion = $x("//li[@class='mini-suggest__item mini-suggest__item_type_nav']");
}
