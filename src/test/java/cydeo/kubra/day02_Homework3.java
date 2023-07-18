package cydeo.kubra;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class day02_Homework3 {
    public static void main(String[] args) {
       //TC #3: Back and forth navigation
        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://google.com
        driver.navigate().to("https://google.com");

        //3- Click to Gmail from top right.
        WebElement googleButton= driver.findElement(By.name("q"));
        googleButton.sendKeys("gmail"+ Keys.ENTER);
        //4- Verify title contains:
        //Expected: Gmail
        String expected= "gmail - Google'da Ara";
        String actual= driver.getTitle();

        if (actual.equals(expected)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }

        //5- Go back to Google by using the .back();
        driver.navigate().back();

        //6- Verify title equals:
        //Expected: Google
        String expectedTitle=  "Google";
        String actualTitle= driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println( "Passed");
        }else{
            System.out.println("Failed");
        }
    }
}
