package cydeo.ayshe;

import cydeo.kubra.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Day10_TC7_Scroll_js {
    //TC #7: Scroll using JavascriptExecutor
//1- Open a chrome browser
//2- Go to: https://practice.cydeo.com/large
//3- Scroll down to “Cydeo” link
//4- Scroll up to “Home” link
//5- Use below provided JS method only
//JavaScript method to use : arguments[0].scrollIntoView(true)
//Note: You need to locate the links as web elements and pass them as
//arguments into executeScript() method
    @Test

    public void scroll_With_js() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.navigate().to("https://practice.cydeo.com/large");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement CYDEOlink =driver.findElement(By.xpath("(//a)[2]"));
        Thread.sleep(2);
        js.executeScript("arguments[0].scrollIntoView(true);", CYDEOlink);


        WebElement homeLink = driver.findElement(By.xpath("(//a)[1]"));
        Thread.sleep(2);
        js.executeScript("arguments[0].scrollIntoView(true);", homeLink);
    }
}
