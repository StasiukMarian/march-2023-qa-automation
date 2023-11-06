package guiTests.lesson5;

import base.config.BaseTest;
import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static base.Pages.*;
import static com.codeborne.selenide.Selenide.$;

public class PatternsTest extends BaseTest {
//    MainPage mainPage = new MainPage();
//    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
//    BurgerMenuPage burgerMenuPage = new BurgerMenuPage();
    String username = "standard_user";
    String password = "secret_sauce";
    List<String> expectedBurgerMenuList = new ArrayList<>();

    @Test
    public void PageObjectTest() {
        loginPage().typeUsername(username);
        loginPage().typePassword(password);
        loginPage().clickLoginButton();

        mainPage().waitMainPage();

//        ElementsCollection itemListFromMainPage = mainPage().getItemList();
//
//        Assert.assertTrue(itemListFromMainPage.texts().contains("Sauce Labs Onesie"));
//
//        for (int i = 0; i < itemListFromMainPage.size(); i++) {
//            mainPage().clickAddToCartButton();
//        }

//        mainPage.clickShoppingCartButton();
//
//        shoppingCartPage.waitShoppingCartPage();
//        ElementsCollection itemsFromShoppingCart = shoppingCartPage.getItemsFromShoppingCart();
//
//        Assert.assertEquals(itemsFromShoppingCart.size(), 6);


        mainPage().clickBurgerMenuButton();

        expectedBurgerMenuList.add("All Items");
        expectedBurgerMenuList.add("About");
        expectedBurgerMenuList.add("Logout");
        expectedBurgerMenuList.add("Reset App State");

        Selenide.sleep(1500);

        List<String> burgerMenuItems = burgerMenuPage().getBurgerMenuItems();
        Assert.assertEquals(burgerMenuItems, expectedBurgerMenuList);

//        int indexLogout = burgerMenuItems.texts().indexOf("Logout");
//
//        burgerMenuItems.get(indexLogout).click();
//
//        Assert.assertTrue(loginPage().isLoginButtonPresented());
        burgerMenuPage().closeBurgerMenu();
//
//        mainPage().clickTwitterButton();
//
//        Selenide.switchTo().window(1);
//
//        Selenide.sleep(3000);
//
//        Assert.assertTrue($(By.xpath("//span[text()='@saucelabs']")).is(Condition.visible));
//
//        Selenide.closeWindow();
//        Selenide.switchTo().window(0);
//
//        mainPage().clickBurgerMenuButton();
//
//        int indexLogout = burgerMenuItems.texts().indexOf("Logout");
//
//        burgerMenuItems.get(indexLogout).click();
//
//        Assert.assertTrue(loginPage().isLoginButtonPresented());
    }
}
