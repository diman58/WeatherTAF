package Utils;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.Locale;

import static Utils.CommonConditions.gismeteoNowTempValue;
import static Utils.CommonConditions.yandexNowTempValue;
import static com.codeborne.selenide.Selenide.$;

public class StringManager {

    public static int getTextValueAndConvertToInt(String selector) {
        String temp = $(selector)
                .should(Condition.visible, Duration.ofSeconds(6))
                .getOwnText().trim();

        if (temp.charAt(0) == 8722) {
            temp = "-" + temp.substring(1);
        }

        return Integer.parseInt(temp);

    }

    public static void getIntValueOfNowTemp(SelenideElement nowTemp) {
        String temp = $(nowTemp).should(Condition.visible, Duration.ofSeconds(6))
                .getOwnText()
                .trim();

        if (temp.charAt(0) == 8722) {
            temp = "-" + temp.substring(1);
        }
        if(nowTemp.equals("gismeteoNowTempValue")) {
            gismeteoNowTempValue = Integer.parseInt(temp);
        } else {
            yandexNowTempValue = Integer.parseInt(temp);
        }
    }

}
