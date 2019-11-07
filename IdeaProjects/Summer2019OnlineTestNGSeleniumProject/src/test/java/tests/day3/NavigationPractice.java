package tests.day3;

import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class NavigationPractice {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://google.com");

        //how to print page title
        System.out.println(driver.getTitle());

        driver.navigate().to("http://amazon.com");

        //wait for 3 seconds. this is our custom method since method is static, we use
        //class name to call the method as a parameter, we provide number of seconds
        BrowserUtils.wait(3);
        //navigate back to Google (previous URL)
        driver.navigate().back();
        //move forward to the amazon again
        driver.navigate().forward();
        //to refresh/reload a webpage
        driver.navigate().refresh();
        //shutdown browser
        driver.quit();




    }
}
