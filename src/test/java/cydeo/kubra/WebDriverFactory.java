package cydeo.kubra;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverFactory {

    public static WebDriver getDriver(String browserType) {

        if (browserType.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");


            return new ChromeDriver(options);

        } else if (browserType.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else {
            System.out.println("Given browser type does not exist/or is not currently supported");
            System.out.println("Driver = null");
            return null;
        }
    }}