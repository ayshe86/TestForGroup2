package cydeo.ayshe.utulities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SmartBearUtils { //3. Enter username: “Tester”
    //4. Enter password: “test”
    //5. Click to Login button
    public static void smartBear_Login(WebDriver driver, String username, String password) {
        //3. Enter valid username
        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']"));
        inputUsername.sendKeys(username);



        //4. Enter valid password
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']"));
        inputPassword.sendKeys(password);

        //5. Click to Log In button
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();
    }

}
