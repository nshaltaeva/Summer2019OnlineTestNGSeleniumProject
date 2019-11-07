package tests.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestForLinkText {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
//it works only if tag name is <a>
        driver.findElement(By.linkText("Autocomplete")).click();

        BrowserUtils.wait(3);
        driver.quit();






    }
}
