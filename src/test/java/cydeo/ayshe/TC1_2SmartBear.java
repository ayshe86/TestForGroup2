package cydeo.ayshe;

import com.github.javafaker.Faker;
import cydeo.ayshe.utulities.SmartBearUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC1_2SmartBear {
    //TC #1: Smartbear software link verification
    //1. Open browser
    //2. Go to website:
    //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
    //3. Enter username: “Tester”
    //4. Enter password: “test”
    //5. Click to Login button
    //6. Print out count of all the links on landing page
    //7. Print out each link text on this page
    //Mini-Task: CREATE A CLASS à SmartBearUtils
    //• Create a method called loginToSmartBear
    //• This method simply logs in to SmartBear when you call it.
    //• Accepts WebDriver type as parameter
    static WebDriver driver;

    @BeforeMethod
    public void setupMethod() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.navigate().to("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
    }


    @Test
    public static void smartBear_test() {
        //3. Enter username: “Tester”
        //4. Enter password: “test”
        //5. Click to Login button
        SmartBearUtils.smartBear_Login(driver, "Tester", "test");

//6. Print out count of all the links on landing page
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        System.out.println("allLinks.size() = " + allLinks.size());

        //7. Print out each link text on this page
        for (WebElement each : allLinks) {

            System.out.println("Text of link: " + each.getText());


        }
    }

    @Test
    public static void smartBear_test2() throws InterruptedException {
        //TC#2: Smartbear software order placing
//1. Open browser
//2. Go to website:
//http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
//3. Enter username: “Tester”
//4. Enter password: “test”
//5. Click on Login button
        SmartBearUtils.smartBear_Login(driver, "Tester", "test");
//6. Click on Order
        WebElement orderButton = driver.findElement(By.xpath("//a[.='Order']"));
        orderButton.click();
//7. Select familyAlbum from product, set quantity to 2
        WebElement product = driver.findElement(By.xpath("//option[.='FamilyAlbum']"));
        product.click();


        WebElement quantity = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtQuantity']"));

        quantity.sendKeys("2");

//8. Click to “Calculate” button

        WebElement calculateButton = driver.findElement(By.xpath("//input[@value='Calculate']"));
        calculateButton.click();
//9. Fill address Info with JavaFaker
        //• Generate: name, street, city, state, zip code
        Faker faker = new Faker();
        String name = faker.name().fullName();
        String street = faker.address().streetName();
        String city = faker.address().city();
        String zip = faker.bothify("####");
        String cardNum = faker.finance().creditCard().replaceAll("-", "");
        String expDate = faker.bothify("##/##");
        WebElement nameText = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtName']"));
        nameText.sendKeys(name);
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox2']")).sendKeys(street);
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox3']")).sendKeys(city);
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox5']")).sendKeys(zip);


//10.Click on “visa” radio button
        driver.findElement(By.xpath("//input[@value='Visa']")).click();
//11.Generate card number using JavaFaker
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox6']")).sendKeys(cardNum);
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox1']")).sendKeys(expDate);
        //12.Click on “Process”
        driver.findElement(By.xpath("//a[.='Process']")).click();
//13.Verify success message “New order has been successfully added.”
//div[normalize-space(text()) ='New order has been successfully added.']"
        WebElement actualText = driver.findElement(By.xpath("//strong"));
        String actual = actualText.getText();

        String expected = "New order has been successfully added.";

        Assert.assertEquals(actual, expected);

        driver.close();

    }
}
