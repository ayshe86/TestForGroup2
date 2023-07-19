package cydeo.ayshe;

import cydeo.ayshe.utulities.WebTablesUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public class Day8_TC3 {
    //TC #3: Create a custom method
    //1- Open a chrome browser
    //2- Go to: https://practice.cydeo.com/tables
    //3- Write custom method:
    //
    //• Method name: getTableGetEmail()
    //• Return type: void
    //• Arg1: WebDriver driver
    //• Arg2: String tableNum
    //• Arg3: String firstName
    public WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(" https://practice.cydeo.com/tables");


    }

    @Test
    public void email_verify_test() {
        WebTablesUtils.getTableGetEmail(driver,"table1","Jason");


    }
}