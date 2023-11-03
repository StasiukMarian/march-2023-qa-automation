package base.core;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PageTools extends CustomLogger {

    private static String getPreviousMethodNameAsText() {
        String methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
        String replacedName = methodName.replaceAll(String.format("%s|%s|%s",
                        "(?<=[A-Z])(?=[A-Z][a-z])",
                        "(?<=[^A-Z])(?=[A-Z])",
                        "(?<=[A-Za-z])(?=[^A-Za-z])"
                ),
                " ");
        return replacedName.substring(0, 1).toUpperCase() + replacedName.substring(1).toLowerCase();
    }

    public By byLocator(By by, Object... args) {
        return LocatorParses.parseLocator(by, args);
    }

    protected SelenideElement shouldBe(Condition condition, By by, Object... args) {
        return $(byLocator(by, args)).shouldBe(condition);
    }

    protected ElementsCollection shouldBe(CollectionCondition condition, By by, Object... args) {
        return $$(byLocator(by, args)).shouldBe(condition);
    }

    protected SelenideElement shouldBeClickable(Condition condition1, Condition condition2, By by, Object... args) {
        return $(byLocator(by, args)).shouldBe(Condition.and("clickable", condition1, condition2));
    }

    protected void click(By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + " 'element -> " + byLocator(by, args));
        shouldBeClickable(Condition.enabled, Condition.visible, by, args).click();
    }

    protected void type(String text, By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + " 'element -> " + byLocator(by, args));
        shouldBe(Condition.visible, by, args).clear();
        shouldBe(Condition.visible, by, args).append(text);
    }

    protected boolean isElementExists(By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + " 'element exists -> " + byLocator(by, args));
        return $(byLocator(by, args)).is(Condition.visible);
    }

    protected String getElementText(By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + " 'element text " + byLocator(by, args));
        return shouldBe(Condition.visible, by, args).text();
    }

    protected List<String> getElementsText(By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + " 'elements collection texts " + byLocator(by, args));
        return $$(byLocator(by, args)).texts();
    }

    protected ElementsCollection getElements(By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + " 'elements collection " + byLocator(by, args));
        return $$(byLocator(by, args));
    }
    protected SelenideElement getElement(By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + " 'elements collection " + byLocator(by, args));
        return $(byLocator( by, args));
    }
}
