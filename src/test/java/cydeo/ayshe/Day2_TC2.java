package cydeo.ayshe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day2_TC2 {
    public static void main(String[] args) {
        /*
        TC #2: Zero Bank header verification
1. Open Chrome browser
2. Go to http://zero.webappsecurity.com/login.html
3. Verify header text
Expected: “Log in to ZeroBank”
         */

        WebDriverManager.chromedriver().setup();
        //1. Open Chrome browser
        WebDriver driver= new ChromeDriver();
        //2. Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");
        //3. Verify header text
        //Expected: “Log in to ZeroBank”
        WebElement headerText= driver.findElement(By.tagName("h3"));
        String expectedHeaderText= "Log in to ZeroBank";
        String actualHeaderText=headerText.getText();

        if (actualHeaderText.equals(expectedHeaderText)){
            System.out.println("Header text verification PASSED!");
        }else{
            System.out.println("Header text verification FAILED!!!");
        }

        driver.close();

    }
}
