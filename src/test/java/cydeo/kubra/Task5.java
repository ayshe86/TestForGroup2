package cydeo.kubra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task5 {
    //Task #: Gas Mileage Calculator Automation Test
    //1. Add a new class GasMileageCalculatorTest
    //2. Go to https://www.calculator.net
    WebDriver driver;

    @BeforeMethod
    public void setup() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();



    }
    @Test
    public void gasCalculatorTest(){
        driver.get("https://www.calculator.net ");

        //3. Search for “gas mileage” using search box
        WebElement searchedBox=driver.findElement(By.id("calcSearchTerm"));

        //4. Click on the “Gas Mileage Calculator” link
        searchedBox.sendKeys("Gas Mileage Calculator");

        //5. On Next page verify:
        //a. Title equals: “Gas Mileage Calculator”
        //b. “Gas Mileage Calculator” label is displayed
        driver.findElement(By.linkText("Gas Mileage Calculator")).click();

        //6. Locate, clear and type “7925” into “Current odometer” field
       WebElement currentOdometer= driver.findElement(By.xpath("//input[@id='uscodreading']"));
       currentOdometer.clear();
       currentOdometer.sendKeys("7925");

        //7. Locate, clear and type “7550” into “Previous odometer” field

        WebElement previousOdometer= driver.findElement(By.xpath("//input[@id='uspodreading']"));
        previousOdometer.clear();
        previousOdometer.sendKeys("7550");


        //8. Locate, clear and type “16” into “Gas added” field
        WebElement gasAdded= driver.findElement(By.xpath("//input[@id='usgasputin']"));
        gasAdded.clear();
        gasAdded.sendKeys("16");

        //9. Locate, clear and type “3.55” into “Gas price” field
        WebElement gasPrice= driver.findElement(By.xpath("//input[@id='usgasprice']"));
        gasPrice.clear();
        gasPrice.sendKeys("3.55");

        //10. Click on Calculate button
        WebElement calculateButton= driver.findElement(By.xpath("//input[@value='Calculate'][1]"));
        calculateButton.click();

        //11. Verify mpg value is as expected:
        //Expected value: “23.44 mpg”
        WebElement valueExpected= driver.findElement(By.xpath("//p[@class='verybigtext']/font/b"));


    }
    @AfterMethod
    public void teardown(){ driver.quit();}



}
