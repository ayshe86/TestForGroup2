package cydeo.kubra.Task_Find_Elements;


import cydeo.kubra.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class TC_1 {
    WebDriver driver;
@BeforeMethod
    public void setup() throws InterruptedException {

    driver= WebDriverFactory.getDriver("chrome");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.get(" https://www.openxcell.com");
    Thread.sleep(2000);


}

@Test
public void LinkCounter(){
    int expectedNumber=383;
    List<WebElement> listOfLinks=driver.findElements(By.xpath("//a[contains(@href, '')]"));
    int actualNumber= listOfLinks.size();
    Assert.assertEquals(actualNumber,expectedNumber);

}


    @AfterMethod
    public void teardownMethod(){
        driver.close();
    }
}
/*
TC #1: Checking the number of links on the page
1. Open Chrome browser
2. Go to https://www.openxcell.com
3. Count the number of the links on the page and verify
Expected: 332
 */
