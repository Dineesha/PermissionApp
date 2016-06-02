package Tester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by hsenid on 6/2/16.
 */
public class SuccessTest {
    WebDriver driver;

    @BeforeMethod

    public void beforeMethod() {

        // Create a new instance of the chrome driver

        driver = new ChromeDriver();

        //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Launch the Translator app

        driver.get("http://localhost:8080/CompleteYandexApp/success.jsp");
    }

  @Test(dataProvider ="provideTranslate")

    public void runTranslator(String langFrom,String langTo ,String text) throws InterruptedException {
        /** ------------------------select language parameters-------------------------------------------------------------*/

        WebElement fromLang = driver.findElement(By.name("fromLang"));
        WebElement option = fromLang.findElement(By.xpath("//option[text()='" + langFrom + "']"));
        option.click();

        Thread.sleep(1000);

        WebElement select = driver.findElement(By.name("toLang"));
        List<WebElement> options = select.findElements(By.tagName("option"));
        for (WebElement option2 : options) {
            if (option2.getText().equals(langTo)) {
                option2.click();
                break;
            }

            /** ------------------------set text to translate-------------------------------------------------------------*/


            WebElement fromText = driver.findElement(By.name("txttranslatefrom"));
            fromText.clear();
            fromText.sendKeys(text);

            Thread.sleep(2000);
            WebElement submitButton = driver.findElement(By.id("translate_btn"));
            submitButton.click();

            Thread.sleep(2000);


        }

    }
    @Test
    public void logout() throws InterruptedException {
        /** --------------------------logout navigation-----------------------------------------------------------*/
            WebElement logout = driver.findElement(By.id("logout"));
            logout.click();

            /** --------------------------logout -----------------------------------------------------------*/
        Thread.sleep(2000);

        driver.findElement(By.linkText("Go-Back To Home Page")).click();

    }

    @DataProvider(name = "provideTranslate")
    public Object[] provideData() {

        return new Object[][]{
                { "English", "French" ,"tree"},
                { "French", "English","arbre" },
                { "English", "kk","tree" },
                { "English", "French","qefhyuwriyt" },
                { "hguih", "atfdg" },
                { "nhien", "nhien","" }

        };
    }
    @AfterMethod

    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);

        // Close the driver

        driver.quit();


    }

}
