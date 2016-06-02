package Tester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by hsenid on 6/2/16.
 */
public class IndexTest {
    WebDriver driver;

    @BeforeMethod

    public void beforeMethod() {

        // Create a new instance of the chrome driver

        driver = new ChromeDriver();

        //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Launch the Translator app

        driver.get("http://localhost:8080/CompleteYandexApp/");
    }

    @Test(dataProvider = "provideCredentials")

    public  void runLogin(String username,String password) throws InterruptedException {
        /** ---------------------clear existing credentials----------------------------------------------------------------*/


        WebElement usernameClear = driver.findElement(By.name("form-username"));
        usernameClear.clear();

        WebElement passwordClear = driver.findElement(By.name("form-password"));
        passwordClear.clear();

        Thread.sleep(2000);
        /** ------------------------initialize user credentials-------------------------------------------------------------*/

        WebElement usernameSet = driver.findElement(By.name("form-username"));
        usernameSet.sendKeys(username);
        WebElement passwordSet = driver.findElement(By.name("form-password"));
        passwordSet.sendKeys(password);
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.id("signup_loginpage_btn"));
        element.click();
        Thread.sleep(1000);


    }
    @DataProvider(name = "provideCredentials")
    public Object[][] provideData() {

        return new Object[][] {
                { "kk", "kk" },
                { "kk", "123" },
                { "asffdf", "kk" },
                { "", "" },
                { "hguih", "atfdg" },
                { "nhien", "nhien" }

        };
    }


    @AfterMethod

    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);

        // Close the driver

        driver.quit();


    }

}
