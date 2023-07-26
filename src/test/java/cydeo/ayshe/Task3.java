package cydeo.ayshe;


import cydeo.ayshe.utulities.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task3 {
    ////Open https://demoqa.com/frames page
    //        //Verify if first frames header is "This is a sample page"
    //        //Verify if second frames header is "This is a sample page"
    @Test
    public void first_Frame() {

        Driver.getDriver().get("https://demoqa.com/frames");

        //We need to switch driver's focus to iframe
        //option #1- switching to iframe using id attribute value

        Driver.getDriver().switchTo().frame("frame1");
        //option #2- passing index number of iframe
        //driver.switchTo().frame(0);


        //option #3- locate as web element and pass in frame() method
        //Locate the h1 tag
        String actual1 = Driver.getDriver().findElement(By.tagName("h1")).getText();
        String expected1 = "This is a sample page";

        Assert.assertEquals(actual1, expected1);
        //Verify "An iFrame containing the TinyMCE WYSIWYG Editor"
        //To be able to verify the header, we must switch back to "main HTML"
        Driver.getDriver().switchTo().parentFrame();


        //We need to switch driver's focus to iframe
        //option #1- switching to iframe using id attribute value

        Driver.getDriver().switchTo().frame("frame2");
        //option #2- passing index number of iframe
        //driver.switchTo().frame(0);


        //option #3- locate as web element and pass in frame() method
        //Locate the h1 tag
        String actual2 = Driver.getDriver().findElement(By.tagName("h1")).getText();
        String expected2 = "This is a sample page";

        Assert.assertEquals(actual2, expected2);
        //Verify "An iFrame containing the TinyMCE WYSIWYG Editor"
        //To be able to verify the header, we must switch back to "main HTML"
        Driver.getDriver().switchTo().parentFrame();

    }

    @Test
    public void dropdown() {

        //Open https://demoqa.com/select-menu page
        //    //Type "option 1" into first dropdown
        //    //Hit the enter
        //    //Verify whether the selected option is "Group 1, option 1"
        //
        //    //Type "Ot" into second dropdown
        //    //Hit the enter
        //    //Verify if the selected option is "Other"


        Driver.getDriver().get("https://demoqa.com/select-menu");

        Driver.getDriver().findElement(By.id("react-select-2-input")).sendKeys("option 1" + Keys.ENTER);
        String expectedSelectedOption="Group 1, option 1";
        String actualSelectedOption=Driver.getDriver().findElement(By.cssSelector(".css-1uccc91-singleValue")).getText();
        Assert.assertEquals(actualSelectedOption,expectedSelectedOption);


        //Type "Ot" into second dropdown
        //Hit the enter
        Driver.getDriver().findElement(By.id("react-select-3-input")).sendKeys("Ot" + Keys.ENTER);

        //Verify if the selected option is "Other"
        String expectedSelectedOption2="Other";
        String actualSelectedOption2=Driver.getDriver().findElement(By.xpath("(//div[@class=' css-1uccc91-singleValue'])[2]")).getText();
        Assert.assertEquals(actualSelectedOption2,expectedSelectedOption2);


    }
}
