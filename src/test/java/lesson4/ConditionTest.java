package lesson4;

import base.config.BaseTest;
import com.codeborne.selenide.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ConditionTest extends BaseTest {


    @Test
    public void checkboxesTest(){
        SelenideElement checkbox1 = $(By.xpath("//input[@type='checkbox'][1]"));
        SelenideElement checkbox2 = $(By.xpath("//input[@type='checkbox'][2]"));

//        checkbox1.shouldBe(Condition.visible).click();

//        Assert.assertTrue(checkbox1.is(Condition.checked));
//        Assert.assertTrue(checkbox2.is(Condition.not(Condition.checked)));

        ElementsCollection checkBoxesList = $$(By.xpath("//input[@type='checkbox']")).shouldBe(CollectionCondition.size(100));

        for (int i = 0; i < checkBoxesList.size(); i++) {
            checkBoxesList.get(i).click();
            Assert.assertTrue(checkBoxesList.get(i).is(Condition.checked));
        }


    }

    @Test
    public void test(){
//        System.out.println($(By.xpath("//div[@class='login_container']")).is(Condition.exist));

//        $(By.xpath("//input[@placeholder='Username']")).shouldBe(Condition.visible).append("standard_user");

        Assert.assertFalse($(By.xpath("//input[@placeholder='Username']")).is(Condition.hidden));
//        $(By.xpath("//input[@placeholder='Username']")).shouldBe(Condition.hidden, Duration.ofMillis(120000));

//        System.out.println($(By.xpath("input[@placeholder='Username']")).is(Condition.readonly));
        Condition shouldBeClickable = Condition.and("should be clickable", Condition.visible, Condition.enabled);

//        $(By.xpath("//input[@placeholder='Username']")).shouldBe(Condition.not(Condition.readonly)).append("standard_user");
        $(By.xpath("//input[@placeholder='Username']")).shouldBe(Condition.name("user-name")).append("standard_user");
//        $(By.xpath("//input[@placeholder='Username']")).shouldBe(Condition.value("test")).append("test2");
//        $(By.xpath("//input[@placeholder='Password']")).shouldBe(Condition.empty).append("secret_sauce");
//        $(By.xpath("//input[@placeholder='Password']")).shouldBe(Condition.id("password")).append("secret_sauce");
        $(By.xpath("//input[@placeholder='Password']")).shouldHave(Condition.attribute("class", "input_error form_input")).append("secret_sauce");
//        $(By.xpath("//input[@placeholder='Password']")).shouldBe(Condition.not(Condition.empty)).append("secret_sauce");

//        $(By.xpath("//input[@type='submit']")).shouldBe(shouldBeClickable).click();
        $(By.xpath("//input[@type='submit']")).shouldBe(Condition.type("submit")).click();

        $(By.xpath("//div[@class='app_logo']")).shouldBe(Condition.visible, Duration.ofMillis(20000));
        $(By.xpath("//div[@class='app_logo']")).shouldHave(Condition.exactText("swag labs"));
        $(By.xpath("//div[@class='app_logo']")).shouldHave(Condition.exactTextCaseSensitive("Swag Labs"));
        $(By.xpath("//div[@class='app_logo']")).shouldHave(Condition.text("swag"));
        $(By.xpath("//div[@class='app_logo']")).shouldHave(Condition.textCaseSensitive("Labs"));

//        $$(By.xpath("//div[@class='inventory_item']")).shouldBe(CollectionCondition.empty);

        $$(By.xpath("//div[@class='inventory_item']")).shouldHave(CollectionCondition.size(6));
        $$(By.xpath("//div[@class='inventory_item']")).shouldHave(CollectionCondition.sizeGreaterThan(5));
        $$(By.xpath("//div[@class='inventory_item']")).shouldHave(CollectionCondition.sizeGreaterThanOrEqual(6));
        $$(By.xpath("//div[@class='inventory_item']")).shouldHave(CollectionCondition.sizeLessThan(7));
        $$(By.xpath("//div[@class='inventory_item']")).shouldHave(CollectionCondition.sizeLessThanOrEqual(6));
        $$(By.xpath("//div[@class='inventory_item']")).shouldHave(CollectionCondition.sizeNotEqual(0));
        $$(By.xpath("//div[@class='inventory_item_name ']")).shouldHave(CollectionCondition.texts("Backpack", "Light", "Bolt", "Fleece", "Onesie", "Red"));
        $$(By.xpath("//div[@class='inventory_item_name ']")).shouldHave(CollectionCondition.exactTexts("Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)"));

        List<String> expectedItemNames = new ArrayList<>();
        expectedItemNames.add("Sauce Labs Backpack");
        expectedItemNames.add("Sauce Labs Bike Light");
        expectedItemNames.add("Sauce Labs Bolt T-Shirt");
        expectedItemNames.add("Sauce Labs Fleece Jacket");
        expectedItemNames.add("Sauce Labs Onesie");
        expectedItemNames.add("Test.allTheThings() T-Shirt (Red)");

        List<String> actualItemNames = $$(By.xpath("//div[@class='inventory_item_name ']")).texts();

        Assert.assertEquals($(By.xpath("//div[@class='app_logo']")).text(), "Swag Labs");
        Assert.assertEquals(actualItemNames, expectedItemNames);



    }

}
