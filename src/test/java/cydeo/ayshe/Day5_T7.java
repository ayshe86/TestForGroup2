package cydeo.ayshe;


import cydeo.ayshe.utulities.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day5_T7 {
    //TC #7: Selecting value from non-select dropdown
    //1. Open Chrome browser
    //2. Go to https://practice.cydeo.com/dropdown
    //3. Click to non-select dropdown
    //4. Select Facebook from dropdown
    //5. Verify title is “Facebook - Log In or Sign Up”
    @Test
    public void select_value() {

        Driver.getDriver().get("https://practice.cydeo.com/dropdown");
        WebElement dropdown = Driver.getDriver().findElement(By.xpath("//a[@id='dropdownMenuLink']"));
        dropdown.click();
        dropdown = Driver.getDriver().findElement(By.linkText("Facebook"));
        dropdown.click();


        String expectedTitle = "Facebook – log in or sign up";

        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);


    }
}
