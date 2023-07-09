package cydeo.ayshe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day2_TC3 {
    public static void main(String[] args) {
/*
TC #3: Back and forth navigation
1- Open a chrome browser
2- Go to: https://google.com
3- Click to Gmail from top right.
4- Verify title contains:
Expected: Gmail

5- Go back to Google by using the .back();
6- Verify title equals:
Expected: Google
 */

        WebDriverManager.chromedriver().setup();
        //1- Open a chrome browser
        WebDriver driver = new ChromeDriver();

        //2- Go to: https://google.com
        driver.get("https://google.com");

        //3- Click to Gmail from top right.

        WebElement gmailElement= driver.findElement(By.linkText("Gmail"));
        gmailElement.click();

        //4- Verify title contains:
        //Expected: Gmail

        String expectedTitleGmailElement= "Gmail";
        String actualTitleGmailElement=driver.getTitle();

        if(actualTitleGmailElement.startsWith(expectedTitleGmailElement)){
            System.out.println("Title verification PASS!");
        }else{
            System.out.println("Title verification FAILED!!!");
        }

       // 5- Go back to Google by using the .back();
        driver.navigate().back();

        //6- Verify title equals:
        //Expected: Google

        String expectedTitleGoogle= "Google";
        String actualTitleGoogle=driver.getTitle();
        if (expectedTitleGoogle.equals(actualTitleGoogle)){
            System.out.println("Title verification PASS!");
        }else{
            System.out.println("Title verification FAILED!!!");
        }

        driver.close();
        }


    }

