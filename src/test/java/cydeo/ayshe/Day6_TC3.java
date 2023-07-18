package cydeo.ayshe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Day6_TC3 {
    //TC #3: Information alert practice
    //1. Open browser
    //2. Go to website: http://practice.cydeo.com/javascript_alerts
    //3. Click to “Click for JS Prompt” button
    //4. Send “hello” text to alert
    //5. Click to OK button from the alert
    //6. Verify “You entered: hello” text is displayed.

    public static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        //1. Open browser
//2. Go to website: http://practice.cydeo.com/javascript_alerts
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/javascript_alerts");
    }

    @Test
    public static void verifyHelloText() {

        //3. Click to “Click for JS Prompt” button
        WebElement JSPromptButton = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        JSPromptButton.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("hello");
        alert.accept();




        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));
        String expectedResultText = "You entered: hello";
        String actualResultText = resultText.getText();
        Assert.assertEquals(actualResultText, expectedResultText);
    }
}
