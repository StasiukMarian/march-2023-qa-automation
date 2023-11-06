package guiTests.lesson1;

import base.config.BaseTest;
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
