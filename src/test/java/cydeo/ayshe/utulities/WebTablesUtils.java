package cydeo.ayshe.utulities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class WebTablesUtils {

    //• Method name: getTableGetEmail()
    //• Return type: void
    //• Arg1: WebDriver driver
    //• Arg2: String tableNum
    //• Arg3: String firstName

    public static void getTableGetEmail(WebDriver driver, String tableNum, String firstName) {

        String locator1 = "//table[@id='" + tableNum + "']//td[.='" + firstName + "']//following-sibling::td[1]";
        
        WebElement emailText=driver.findElement(By.xpath(locator1));
        String actualEmailText= emailText.getText();
        System.out.println("actualEmailText = " + actualEmailText);
    }


}
