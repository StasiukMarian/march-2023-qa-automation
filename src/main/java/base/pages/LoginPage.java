package base.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final SelenideElement usernameInput = $(By.xpath("//input[@placeholder='Username']"));
    private final SelenideElement passwordInput = $(By.xpath("//input[@placeholder='Password']"));
    private final SelenideElement loginButton = $(By.xpath("//input[@value='Login']"));

    public void typeUsername(String username) {
        usernameInput.shouldBe(Condition.and("visible and empty", Condition.visible, Condition.empty)).append(username);
    }

    public void typePassword(String password) {
        passwordInput.shouldBe(Condition.and("visible and empty", Condition.visible, Condition.empty)).append(password);
    }

    public void clickLoginButton() {
        loginButton.shouldBe(Condition.and("clickable", Condition.visible, Condition.enabled)).click();
    }
//    boolean methods
    public boolean isLoginButtonPresented(){
        return loginButton.is(Condition.visible);
    }
}
