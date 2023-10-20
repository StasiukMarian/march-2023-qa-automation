package lesson1;

import base.config.BaseTest;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

public class FirstTest extends BaseTest {

    @Test()
    public void firstTest(){
    }

//    @Test(dependsOnMethods = "firstTest", alwaysRun = true)
//    public void secondTest(){
//        System.out.println("this is second test");
//    }

}
