package base.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {
    private final SelenideElement logo = $(By.xpath("//div[@class='app_logo']"));
    private final ElementsCollection headers = $$(By.xpath("//div[@class='inventory_item_name ']"));
    private final SelenideElement addToCart = $(By.xpath("//button[text()='Add to cart']"));
    private final SelenideElement shoppingCartButton = $(By.xpath("//a[@class='shopping_cart_link']"));
    private final SelenideElement burgerMenu = $(By.xpath("//button[@id='react-burger-menu-btn']"));
    private final SelenideElement facebook = $(By.xpath("//a[text()='Facebook']"));
    private final SelenideElement twitter = $(By.xpath("//a[text()='Twitter']"));
    private final SelenideElement linkedIn = $(By.xpath("//a[text()='LinkedIn']"));

    public void waitMainPage(int time) {
        logo.shouldBe(Condition.visible, Duration.ofMillis(time));
    }

    //    click methods
    public void clickAddToCartButton() {
        addToCart.shouldBe(Condition.and("clickable",Condition.visible, Condition.enabled)).click();
    }
    public void clickShoppingCartButton() {
        shoppingCartButton.shouldBe(Condition.and("clickable",Condition.visible, Condition.enabled)).click();
    }
    public void clickBurgerMenuButton() {
        burgerMenu.shouldBe(Condition.and("clickable",Condition.visible, Condition.enabled)).click();
    }
    public void clickTwitterButton() {
        twitter.shouldBe(Condition.and("clickable",Condition.visible, Condition.enabled)).click();
    }
    public void clickFacebookButton() {
        facebook.shouldBe(Condition.and("clickable",Condition.visible, Condition.enabled)).click();
    }
    public void clickLinkedInButton() {
        linkedIn.shouldBe(Condition.and("clickable",Condition.visible, Condition.enabled)).click();
    }
    //    return methods
//    type methods
    public ElementsCollection getItemList() {
        return headers.shouldBe(CollectionCondition.size(6));
    }

}
