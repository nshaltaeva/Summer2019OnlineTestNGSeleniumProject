package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
    //we gonna create a method that will return webdriver object
    //This method will take one parameter - String browser based on the value of the browser paramerter
    //Method will return corresponded webdriver object
    //if browser = chrome, then return chromedriver object
    public static WebDriver getDriver(String browser){
        if(browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if (browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }
        return null;
    }

}
