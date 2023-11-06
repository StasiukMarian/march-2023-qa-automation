package guiTests.lesson7;

import base.config.BaseTest;
import base.pages.Item;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static base.Pages.*;

public class DetailItemTest extends BaseTest {

    @Test(description = "Verify the detail item contains in the List of all items in the Main Page")
    public void detailTest() {
        loginPage().typeUsername("standard_user");
        loginPage().typePassword("secret_sauce");
        loginPage().clickLoginButton();

        mainPage().waitMainPage();

        List<Item> itemListFromMainPage = mainPage().getItemListFromMainPage();

        System.out.println(itemListFromMainPage + " LIST FROM MAIN PAGE");

        mainPage().getElementsFromMain().get(2).click();

        Item detailItem = detailItemPage().getDetailItem();

        System.out.println(detailItem + " DETAIL ITEM");

        Assert.assertTrue(itemListFromMainPage.contains(detailItem));
    }
}
