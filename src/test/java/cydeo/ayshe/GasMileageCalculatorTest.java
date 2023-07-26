package cydeo.ayshe;


import cydeo.ayshe.utulities.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GasMileageCalculatorTest {

    //1. Add a new class GasMileageCalculatorTest
    //2. Go to https://www.calculator.net
    //3. Search for “gas mileage” using search box
    //4. Click on the “Gas Mileage Calculator” link
    @Test
    public void GasMileageCalculatorTest() {

      Driver.getDriver().get("https://www.calculator.net");
        //3. Search for “gas mileage” using search box
        WebElement searchTerm = Driver.getDriver().findElement(By.id("calcSearchTerm"));

        searchTerm.sendKeys("gas mileage" ,Keys.ENTER);

        //4. Click on the “Gas Mileage Calculator” link

        WebElement gasMileageCalcLink = Driver.getDriver().findElement(By.linkText("Gas Mileage Calculator"));
        gasMileageCalcLink.click();


        //5. On Next page verify:
        //a. Title equals: “Gas Mileage Calculator”
        //b. “Gas Mileage Calculator” label is displayed
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Gas Mileage Calculator";
        Assert.assertEquals(actualTitle, expectedTitle);

        //b. “Gas Mileage Calculator” label is displayed
        Driver.getDriver().findElement(By.tagName("h1")).isDisplayed();



        //6. Locate, clear and type “7925” into “Current odometer” field
        WebElement currenOdometerReading = Driver.getDriver().findElement(By.id("mucodreading"));
        currenOdometerReading.clear();
        currenOdometerReading.sendKeys("7925");

        //7. Locate, clear and type “7550” into “Previous odometer” field

        WebElement previousOdometerReading = Driver.getDriver().findElement(By.id("mupodreading"));
       previousOdometerReading.clear();
      previousOdometerReading.sendKeys("7550");

        //8. Locate, clear and type “16” into “Gas added” field
        WebElement gasAdded = Driver.getDriver().findElement(By.id("mugasputin"));
        gasAdded.clear();
        gasAdded.sendKeys("16");

        //9. Locate, clear and type “3.55” into “Gas price” field
        WebElement gasPrice = Driver.getDriver().findElement(By.id("mugasprice"));
        gasPrice.clear();
       gasPrice.sendKeys("3.55");

        //10. Click on Calculate button
        //11. Verify mpg value is as expected:
        //Expected value: “23.44 mpg”

    Driver.getDriver().findElement(By.xpath("//table[@id=\"metric\"]/tbody/tr[5]/td/input")).click();

    String actualResult= Driver.getDriver().findElement(By.xpath("//p[@class='verybigtext']//b")).getText();

     Assert.assertTrue(actualResult.contains("23.44"));


    }
}
