package cydeo.kubra.Task_Find_Elements;

import cydeo.kubra.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC_3 extends TC_1{

    WebDriver driver;
    @BeforeMethod
    public void setup() throws InterruptedException {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(" https://www.openxcell.com");
        Thread.sleep(2000);

    }
    @Test
    public void noTextOfLinks(){
        List<WebElement> listOfLinks = driver.findElements(By.xpath("//a[contains(@href, '')]"));
        int count=0;
        for (WebElement each:listOfLinks){
            if (each.getText().isEmpty()){
                count++;
            }
        }
        System.out.println("Total number of withText links = "+(listOfLinks.size() - count));

    }


    @AfterMethod
    public void teardownMethod(){
        driver.close();
    }}
