package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class GismeteoIndexPage extends BasePage{

    public static SelenideElement gismeteoSearch = $x("//input");
    public static SelenideElement gismeteoFirstSuggesstion = $x("//a[@data-index='0']");

}
