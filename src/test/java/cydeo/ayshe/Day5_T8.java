package cydeo.ayshe;


import cydeo.ayshe.utulities.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class Day5_T8 {
    //TC #8: Selecting value from multiple select dropdown
    //1. Open Chrome browser
    //2. Go to https://practice.cydeo.com/dropdown
    //3. Select all the options from multiple select dropdown.
    //4. Print out all selected values.
    //5. Deselect all values.
    @Test
    public void multiple_dropdown() {

        Driver.getDriver().get("https://practice.cydeo.com/dropdown");
        Select multipleDropdown = new Select(Driver.getDriver().findElement(By.name("Languages")));


        for (int i = 0; i <= 5; i++) {
            multipleDropdown.selectByIndex(i);
        }

        List<WebElement> selected = multipleDropdown.getAllSelectedOptions();

        for (WebElement eachElement : selected) {
            System.out.println(eachElement.getText());
        }

        multipleDropdown.deselectAll();
    }
}
