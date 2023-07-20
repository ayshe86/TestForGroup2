package cydeo.kubra;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.css.model.SelectorList;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task2 {
    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        SmartBearUtils.loginToSmartBear(driver);
    }
    @Test
    public void softwareOrder(){
        WebElement orderButton= driver.findElement(By.xpath("//a[.='Order']"));
        orderButton.click();
        Select productInfo = new Select(driver.findElement(By.xpath("//select[@name='ctl00$MainContent$fmwOrder$ddlProduct']")));
        productInfo.selectByVisibleText("FamilyAlbum");

       WebElement quantity= driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtQuantity']"));

        quantity.sendKeys("2");
        WebElement calculateButton= driver.findElement(By.xpath("//input[@value='Calculate']"));
        calculateButton.click();

        Faker faker = new Faker();
        WebElement customerName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']"));
        customerName.sendKeys(faker.name().fullName());

        WebElement street = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox2']"));
        street.sendKeys(faker.address().streetAddress());

        WebElement city = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']"));
        city.sendKeys(faker.address().city());

        WebElement state = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']"));
        state.sendKeys(faker.address().state());

        WebElement zipCode = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']"));
        zipCode.sendKeys(faker.numerify("######"));

        WebElement cardType = driver.findElement(By.xpath("//input[@value='Visa']"));
        cardType.click();
        WebElement cardNumber = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']"));
        cardNumber.sendKeys(faker.numerify("################"));
        WebElement expireDate = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']"));;
        expireDate.sendKeys(faker.numerify("##/##"));
        WebElement processButton = driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']"));
        processButton.click();

    }
}
/*
TC#2: Smartbear software order placing
1. Open browser x
2. Go to website: x
http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
3. Enter username: “Tester” x
4. Enter password: “test” x
5. Click on Login button x
6. Click on Order  x
7. Select familyAlbum from product x, set quantity to 2
8. Click to “Calculate” button x
9. Fill address Info with JavaFaker
• Generate: name, street, city, state, zip code x
10.Click on “visa” radio button x
11.Generate card number using JavaFaker
12.Click on “Process”
13.Verify success message “New order has been successfully added.”
 */
