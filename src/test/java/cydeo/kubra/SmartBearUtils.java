package cydeo.kubra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SmartBearUtils {
    WebDriver driver;

    public static void loginToSmartBear(WebDriver driver){
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        WebElement userName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        userName.sendKeys("Tester");

        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");

        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();



    }
}
