package cydeo.kubra.extra_homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SmartBearUtils {
    public static void loginToSmartBear( WebDriver driver){
        //Mini-Task: CREATE A CLASS à SmartBearUtils
        //• Create a method called loginToSmartBear
        //• This method simply logs in to SmartBear when you call it.
        //• Accepts WebDriver type as parameter

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        WebElement userNameInput= driver.findElement(By.id("ctl00_MainContent_username"));
        userNameInput.sendKeys("Tester");

        WebElement passwordInput= driver.findElement(By.id("ctl00_MainContent_password"));
        passwordInput.sendKeys("test");

        WebElement loginButton= driver.findElement(By.id("ctl00_MainContent_login_button"));
        loginButton.click();

    }
}
