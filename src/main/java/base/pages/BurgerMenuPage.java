package base.pages;

import base.core.PageTools;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class BurgerMenuPage extends PageTools {
    private final By burgerMenuItems = By.xpath("//nav[@class='bm-item-list']/a");
    private final SelenideElement closeIcon = $(By.xpath("//button[@id='react-burger-cross-btn']"));
    public List<String> getBurgerMenuItems(){
        return getElementsText(burgerMenuItems);
    }
    public void closeBurgerMenu(){
        closeIcon.shouldBe(Condition.and("clickable", Condition.visible, Condition.enabled)).click();
    }
}
