package lesson2;

import base.config.BaseTest;
import com.codeborne.selenide.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WorkWithElementsTest extends BaseTest {

//    @BeforeMethod
//    public void download() {
//        Configuration.fileDownload = FileDownloadMode.FOLDER;
//    }

    public static String getFilePathByName (String fileName){
        return new File("src/main/resources/files/" + fileName).getAbsolutePath();
    }

    @Test
    public void workWithElementsTest() {

        // TEST ON ANOTHER WEB-SITES

//        $(By.xpath("//p[text()='Click here to test your mouse clicks.']")).doubleClick();
//        $(By.xpath("//input[1]")).uploadFile(new File(getFilePathByName("annual-enterprise-survey-2021-financial-year-provisional-csv.csv")));


//        $(By.xpath("(//h3/a)[1]")).scrollTo();
//
//        try {
//            File download = $(By.xpath("(//h3/a)[1]")).download();
//            Thread.sleep(3000);
//
//            String path = download.getPath();
//
//            System.out.println(path);

//            FileUtils.deleteDirectory(new File("build/downloads"));

//        } catch (FileNotFoundException e) {
//           e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        $(By.xpath("//nav[@class='nav-menu']/div[position()=1]")).hover();
//
//        ElementsCollection coursesList = $$(By.xpath("//nav/div[position()=1]//a"));
//
//        coursesList.get(2).click();


//        $(By.id("user-name")).append("test");
//        $(By.name("password")).append("test2");
//        $(By.className("form_input")).append("test");
//        $(By.tagName("input")).append("test2");

        $(By.xpath("//input[@placeholder='Username']")).append("standard_user");
        $(By.xpath("//input[@id='password']")).append("secret_sauce");
//
//        System.out.println($(By.xpath("//div[@class='login_logo']")).text());
//
//        Selenide.actions().sendKeys(Keys.ENTER).perform();

        $(By.xpath("//input[@type='submit']")).click();


        $(By.xpath("//button[@id='react-burger-menu-btn']")).click();

        List<String> burgerMenuItems = $$(By.xpath("//button[@id='react-burger-menu-btn']/parent::div/parent::div/following-sibling::div//a")).texts();

        for (String burgerMenuItem : burgerMenuItems) {
            System.out.println(burgerMenuItem);
        }
//        $(By.xpath("//select[@class='product_sort_container']")).click();
//
//        List<String> filterOptionsTextsList = $$(By.xpath("//select[@class='product_sort_container']/option")).texts();
//
//        for (String option : filterOptionsTextsList) {
//            System.out.println(option);
//        }
//
//        Selenide.actions().sendKeys(Keys.ESCAPE).perform();
//
//        List<String> texts = $$(By.xpath("//div[@class='inventory_item_name ']")).texts();
//        System.out.println(texts);
//
//        ElementsCollection buttonList = $$(By.xpath("//button[text()='Add to cart']"));
//
//        for (SelenideElement button : buttonList) {
//            button.click();
//        }
//
//        ElementsCollection headersList = $$(By.xpath("//div[@class='inventory_item_name ']"));

//        headersList.get(2).click();


//        $(By.xpath("//input[@type='submit']")).submit();   //input with type=submit


    }
}
