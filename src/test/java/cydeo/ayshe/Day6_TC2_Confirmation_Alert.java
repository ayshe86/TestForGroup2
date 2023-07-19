package cydeo.ayshe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Day6_TC2_Confirmation_Alert {
    // TC #2: Confirmation alert practice


    WebDriver driver;

    @BeforeClass
    public void setUp() {
        //1. Open browser
//2. Go to website: http://practice.cydeo.com/javascript_alerts
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/javascript_alerts");
    }

    @Test
    public void alert_test2() {
        // 3. Click to “Click for JS Confirm” button
        WebElement confirmButton = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        confirmButton.click();

        //4. Click to OK button from the alert

        Alert alert = driver.switchTo().alert();
        alert.accept();

        //5. Verify “You clicked: Ok” text is displayed.
        WebElement clickedResultText = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(clickedResultText.isDisplayed());



        String actualText = clickedResultText.getText();
        String expectedText = "You clicked: Ok";

        Assert.assertEquals(actualText,expectedText);


    }


}
