package cydeo.ayshe;


import cydeo.ayshe.utulities.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Task_Find_Elements {
    //TC #1: Checking the number of links on the page
    //1. Open Chrome browser
    //2. Go to https://www.openxcell.com
    //3. Count the number of the links on the page and verify
    //Expected: 332
    @Test
    public void checking_num() {
      Driver.getDriver().get("https://www.openxcell.com");

        List<WebElement> allLinks = Driver.getDriver().findElements(By.tagName("a"));

        int expected = 362;
        Assert.assertEquals(allLinks.size(), expected);


    }

    //TC #2: Printing out the texts of the links on the page
    //1. Open Chrome browser
    //2. Go to https://www.openxcell.com
    //3. Print out all of the texts of the links on the page
    @Test

    public void print_out() {
        Driver.getDriver().get("https://www.openxcell.com");


        List<WebElement> allLinks = Driver.getDriver().findElements(By.tagName("a"));
        for (WebElement eachElement : allLinks) {
            System.out.println(eachElement.getAccessibleName());
        }

    }

    //TC #3: Counting the number of links that does not have text
    //1. Open Chrome browser
    //2. Go to https://www.openxcell.com
    //3. Count the number of links that does not have text and verify
    //Expected: 109
    @Test
    public void noText() {

        Driver.getDriver().get("https://www.openxcell.com");


        List<WebElement> allLinks = Driver.getDriver().findElements(By.tagName("a"));
        int countLinksText = 0;
        for (WebElement eachElement : allLinks) {


            if (eachElement.getAccessibleName().isEmpty()) {
                countLinksText++;
            }
        }
        int expected=226;

      Assert.assertEquals(countLinksText,expected);
    }


}
