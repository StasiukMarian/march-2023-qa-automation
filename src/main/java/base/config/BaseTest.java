package base.config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.*;

public class BaseTest {
    @BeforeClass(alwaysRun = true)
    public void configuration() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1280x920";
        Configuration.holdBrowserOpen = false;
        Configuration.timeout = 10000;
        Configuration.pageLoadTimeout = 10000;
        Configuration.pageLoadStrategy = "normal";
        Configuration.screenshots = true;
        Configuration.savePageSource = false;
    }

    @BeforeMethod
    public void setUp() {
        Selenide.open("https://www.saucedemo.com/");
    }

    @AfterMethod(alwaysRun = true)
    public void cleanWebDrive() {
        Selenide.clearBrowserCookies();
        Selenide.refresh();
        Selenide.open("about:blank");
    }

    @AfterClass
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
