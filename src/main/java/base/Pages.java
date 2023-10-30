package base;

import base.pages.*;

public class Pages {
    private static LoginPage loginPage;
    private static MainPage mainPage;
    private static ShoppingCartPage shoppingCartPage;
    private static BurgerMenuPage burgerMenuPage;
    private static DetailItemPage detailItemPage;

    public static LoginPage loginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }
    public static MainPage mainPage() {
        if (mainPage == null) {
            mainPage = new MainPage();
        }
        return mainPage;
    }
    public static ShoppingCartPage shoppingCartPage() {
        if (shoppingCartPage == null) {
            shoppingCartPage = new ShoppingCartPage();
        }
        return shoppingCartPage;
    }
    public static BurgerMenuPage burgerMenuPage() {
        if (burgerMenuPage == null) {
            burgerMenuPage = new BurgerMenuPage();
        }
        return burgerMenuPage;
    }
    public static DetailItemPage detailItemPage() {
        if (detailItemPage == null) {
            detailItemPage = new DetailItemPage();
        }
        return detailItemPage;
    }
}
