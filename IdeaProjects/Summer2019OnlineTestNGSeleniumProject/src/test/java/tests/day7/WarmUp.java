package tests.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

import java.util.List;

public class WarmUp {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://cybertekschool.com/");
        //how to find aa link?
        //every link as a tag name <a>
        List<WebElement> links = driver.findElements(By.xpath("//a"));
        //to find how many links we need to find size of WebElements
        System.out.println("Number of links: "+links.size());
        //what if I want to print text of all links one by one
        //loop through the collection of links
        for (WebElement webElement: links ) {
            //if links are empty, to rid of them we can use condition
            if(! webElement.getText().isEmpty()) {
                System.out.println(webElement.getText());
            }
        }
        driver.quit();



    }
}
