package base.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ShoppingCartPage {
    private final ElementsCollection shoppingCartItems = $$(By.xpath("//div[@class='cart_item']"));
    private final SelenideElement checkoutButton = $(By.xpath("//button[text()='Checkout']"));

    public void waitShoppingCartPage(){
        checkoutButton.shouldBe(Condition.visible);
    }
    public ElementsCollection getItemsFromShoppingCart(){
        return shoppingCartItems;
    }

}
