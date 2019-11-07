package tests.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class FindElementsTest {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //once we opened the page, we have to capture a title
        String expectedTitle = driver.getTitle();
        //step1. Open inspector in chrome and find locator for the element
        //step2. Create object of WebElement
        //step3. Use WebElement
        WebElement button = driver.findElement(By.id("form_submit"));
        //to click on element
        button.click();

        //Test1: Verify that URL has not changed
        //read title again after clicking
        String actualTitle = driver.getTitle();
        //in this way , we are making sure that after clicking we stay on the same page
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Test passed");
        }
        else{
            System.out.println("Test failed");
            System.out.println("Expected title "+expectedTitle);
            System.out.println("Actual title " +actualTitle);
        }


        BrowserUtils.wait(5);

        driver.close();
    }
}
