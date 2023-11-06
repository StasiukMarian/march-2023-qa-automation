package guiTests.lesson6;

import base.config.BaseTest;
import org.testng.annotations.Test;

import static base.Pages.loginPage;

public class CustomFrameworkTest extends BaseTest {

    @Test
    public void test(){
        loginPage().typeUsername("standard_user");
        loginPage().typePassword("secret_sauce");
        loginPage().clickLoginButton();
    }
}
