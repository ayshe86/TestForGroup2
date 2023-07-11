package cydeo.ayshe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Day2_TC4 {
    public static void main(String[] args) {
/*
TC #4: Practice Cydeo – Class locator practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/inputs
3- Click to “Home” link
4- Verify title is as expected:
Expected: Practice

PS: Locate “Home” link using “className” locator
 */
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://practice.cydeo.com/inputs");

       WebElement homeLink= driver.findElement(By.className("nav-link"));
       homeLink.sendKeys("Home"+ Keys.ENTER);

      String actualTitle= driver.getTitle();
      String expectedTitle= "Practice";

      if(actualTitle.equals(expectedTitle)){
          System.out.println("Title verification PASS!");
      }else{
          System.out.println("Hello again me sorry :)");
          System.out.println("Title verification FAILED!!!");
      }
      }



    }

