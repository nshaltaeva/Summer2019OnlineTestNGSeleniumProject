package tests.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class MyFirstSeleniumScript {
    public static void main(String[] args) {
        //we have to setup webdriver based on the browser that we gonna use
      //  WebDriverManager.chromedriver().setup();
        WebDriverManager.edgedriver().setup();
        //we need to create an object of appropriate class
       // ChromeDriver driver = new ChromeDriver();
        EdgeDriver driver = new EdgeDriver();
        driver.get("http://google.com");

        //to read page title, there is method .getTitle()
        //Test 1. Verify that title of the page is a "Google"
        String actualResult = driver.getTitle();
        String expectedResult = "Google";
        if(actualResult.equals(expectedResult)){
            System.out.println("Test passed");
        }else {
            System.out.println("Test failed");
        }
        //to close browser
        driver.close();
    }
}
