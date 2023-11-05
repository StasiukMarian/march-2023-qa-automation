package lesson7;

import base.config.BaseTest;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static base.Pages.loginPage;
import static base.Pages.mainPage;

public class ArgumentsTest extends BaseTest {

    @Test
    public void test(){
        loginPage().typeUsername("standard_user");
        loginPage().typePassword("secret_sauce");
        loginPage().clickLoginButton();

        mainPage().waitMainPage();

        List<String> expectedList = new ArrayList<>();

        List<SelenideElement> elementsFromMain = mainPage().getElementsFromMain();
        for (int i = 1; i <= elementsFromMain.size(); i++) {
            String headerByID = mainPage().getHeaderByID(i);
            expectedList.add(headerByID);
        }

        Assert.assertEquals(mainPage().getHeaderByID(5), "Sauce Labs Onesie");

        mainPage().clickElementByHeaderName("Sauce Labs Onesi");
//        mainPage().getItemByID(3).click();

        System.out.println(expectedList);
    }



}
