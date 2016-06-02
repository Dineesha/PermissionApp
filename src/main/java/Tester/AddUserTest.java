package Tester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by hsenid on 6/2/16.
 */
public class AddUserTest {
    WebDriver driver;

    @Test

    public void beforeMethod() {

        // Create a new instance of the chrome driver

        driver = new ChromeDriver();

        //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Launch the Translator app

        driver.get("http://localhost:8080/CompleteYandexApp/signup.jsp");
    }

    @Test
    public void signupTest() throws InterruptedException {
        WebElement fnameSet = driver.findElement(By.name("f-name"));
        fnameSet.sendKeys("piumali");
        WebElement lnameSet = driver.findElement(By.name("l_name"));
        lnameSet.sendKeys("erandi");
        WebElement email = driver.findElement(By.id("e_mail"));
        email.sendKeys("erandi@gmail.com");
        WebElement dateset = driver.findElement(By.id("date2"));
        dateset.sendKeys("05/09/2010");
        WebElement phoneset = driver.findElement(By.id("mobile"));
        phoneset.sendKeys("2324432");
        WebElement countryset = driver.findElement(By.name("dd1"));
        countryset.sendKeys("Sri Lanka");
        WebElement groupset = driver.findElement(By.name("group"));
        groupset.sendKeys("Translator");
        WebElement uname = driver.findElement(By.name("uname"));
        uname.sendKeys("piumali");
        WebElement pword = driver.findElement(By.name("password"));
        pword.sendKeys("jkfgsfg");
        WebElement conpw = driver.findElement(By.name("form-password"));
        conpw.sendKeys("jkfgsfg");
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.id("signup.register_btn"));
        element.click();
        Thread.sleep(1000);
    }

    @AfterMethod

    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);

        // Close the driver

        driver.quit();

    }
}
