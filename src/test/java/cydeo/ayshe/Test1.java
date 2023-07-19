package cydeo.ayshe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test1 {
    WebDriver driver;
    @BeforeMethod

    public void setUpMethod(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @Test
     public void fillTheForm(){
        driver.get("https://demoqa.com/text-box");
        driver.findElement(By.id("userName")).sendKeys("Ayshe Pek");
        driver.findElement(By.xpath("//input[@placeholder='Full Name']"));
        driver.findElement(By.xpath("//textarea[@placeholder='Current Address']")).sendKeys("İnegöl / Bursa");

        driver.findElement(By.id("permanentAddress")).sendKeys("Sinanpaşa / Afyon");

        driver.findElement(By.cssSelector(".btn.btn-primary")).click();


        WebElement result=driver.findElement(By.id("output")) ;
        String resultText=result.getText();
        System.out.println(resultText);


        System.out.println("-".repeat(100));

        //findElements
        List<WebElement> resutls=driver.findElements(By.xpath("//p[@class='mb-1']"));
        for (WebElement each : resutls) {
            System.out.println(each.getText());
        }

    }


    @AfterMethod
    public void afterEach(){
        driver.close();
    }


}
