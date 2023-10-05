package cydeo.ayshe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Day10_T4_5_Scroll_Practice_ExtraHomeWorks {
    //TC #4: Scroll practice
    //1- Open a chrome browser
    //2- Go to: https://practice.cydeo.com/
    //3- Scroll down to “Powered by CYDEO”
    //4- Scroll using Actions class “moveTo(element)” method
    //
    //TC #5: Scroll practice 2
    //1- Continue from where the Task 4 is left in the same test.
    //2- Scroll back up to “Home” link using PageUP button

    @Test

    public void scroll_down() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
       WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.navigate().to("https://practice.cydeo.com/");



        Actions actions=new Actions(driver);

        WebElement powered_by_CYDEO= driver.findElement(By.xpath("(//div)[10]"));

        Thread.sleep(1);

        actions.moveToElement(powered_by_CYDEO).perform();

        Assert.assertTrue(powered_by_CYDEO.isDisplayed());

        WebElement homeLink= driver.findElement(By.linkText("Home"));

        Thread.sleep(1);

        actions.moveToElement(homeLink).perform();

        Assert.assertTrue(homeLink.isDisplayed());
        
    }
}
