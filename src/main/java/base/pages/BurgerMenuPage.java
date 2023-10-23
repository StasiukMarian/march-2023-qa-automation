package base.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class BurgerMenuPage {
    private final ElementsCollection burgerMenuItems = $$(By.xpath("//nav[@class='bm-item-list']/a"));
    private final SelenideElement closeIcon = $(By.xpath("//button[@id='react-burger-cross-btn']"));
    public ElementsCollection getBurgerMenuItems(){
        return burgerMenuItems.shouldBe(CollectionCondition.size(4));
    }
    public void closeBurgerMenu(){
        closeIcon.shouldBe(Condition.and("clickable", Condition.visible, Condition.enabled)).click();
    }
}
