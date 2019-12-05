package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class ActionsClassHoverPractice {

    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/frames");
        driver.get("http://practice.cybertekschool.com/hovers");
    }

    @Test(description = "Verify first image")
    public void test1(){
        //create object of actions class to perform actions (drag and drop, context click, move to specific point, etc...)
        Actions action = new Actions(driver);
        WebElement image1 = driver.findElement(By.cssSelector(".figure:nth-of-type(1)"));
        //just to hover on element not click
        // build() is required when we have more than 1 action in a chain
        //without perform() will not move cursor
        action.moveToElement(image1).perform();
        BrowserUtils.wait(3);

        WebElement textOfImageElement = driver.findElement(By.cssSelector(".figure:nth-of-type(1) h5"));

        String expectedText = "name: user1";
        String actualText = textOfImageElement.getText();
        System.out.println(actualText);

        Assert.assertEquals(actualText,expectedText);


    }

    @Test(description = "Verify first image")
    public void test2(){
        Actions action = new Actions(driver);
        for (int i = 1; i <=3; i++){
            action.moveToElement(driver.findElement(By.cssSelector(".figure:nth-of-type("+i+")"))).perform();
            BrowserUtils.wait(3);
            String name = driver.findElement(By.cssSelector(".figure:nth-of-type("+i+") h5")).getText();
            System.out.println(name);
            Assert.assertEquals(name,"name: user"+i);
        }

    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
