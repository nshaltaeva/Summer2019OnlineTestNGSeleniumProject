package tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasicNavigation {
    public static void main(String[] args) {
     //   WebDriverManager.edgedriver().setup();
     //   WebDriverManager.firefoxdriver().setup();
          WebDriverManager.chromedriver().setup();
           ChromeDriver driver = new ChromeDriver();
     //   FirefoxDriver driver = new FirefoxDriver();
     //   EdgeDriver driver = new EdgeDriver();
        //to maximize browser
        driver.manage().window().maximize();

        driver.get("http://google.com");

        //we want to navigate to the different page
        //within same browser
        //we not gonna open new browser or new tab
        driver.navigate().to("http://amazon.com");
      //  driver.navigate().to("http://cybertekschool.com");

        //if I want to comeback to the previous page
        driver.navigate().back();

        // if I want to know URL of current website
        String url = driver.getCurrentUrl();
        System.out.println(url);
        //selenium cannot close browser automatically





        //to close page
        driver.close();
    }
}
