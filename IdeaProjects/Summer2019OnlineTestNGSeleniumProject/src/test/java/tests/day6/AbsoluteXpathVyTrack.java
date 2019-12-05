package tests.day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class AbsoluteXpathVyTrack {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://qa2.vytrack.com/user/login");
        WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/form/fieldset/div[1]/div"));

    }
}
