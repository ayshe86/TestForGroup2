package cydeo.kubra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task1 {
    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        driver=WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        SmartBearUtils.loginToSmartBear(driver);

    }

    @Test
    public void getNumberOfLinksAndPrintText() {
        //Find and store in a List all links using finElement(S) method
        List<WebElement> links = driver.findElements(By.tagName("a"));

        //Print out count of all the links on landing page
        System.out.println("Total number of links = " + links.size());

        //Print out each link text on this page
        System.out.println("\n--- Text of each link ---");
        for (WebElement eachLink : links) {
            System.out.println(eachLink.getText());
        }
    }
    }
