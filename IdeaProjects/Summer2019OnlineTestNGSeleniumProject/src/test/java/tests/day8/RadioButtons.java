package tests.day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;

public class RadioButtons {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        //to go to Radio Buttons page
//        <a href="/radio_buttons">Radio Buttons</a>
//        linkText works only with <a> elements
//        link text only in between >Text<
//        this is step is common for all test cases
        driver.findElement(By.linkText("Radio Buttons")).click();
    }

    @Test(description = "Verify that blue button is selected")
    public void test1() {
        //find blue radio button
        WebElement blueButton = driver.findElement(By.id("blue"));
        //let's verify that radio button is selected
        //assert true that button is selected
        //if button is selected it will return true, otherwise false
        boolean isSelected = blueButton.isSelected();
        Assert.assertTrue(isSelected); // will expected that isSelected is true
    }

    @Test(description = "Verify that red button is not selected")
    public void test2() {
        WebElement redButton = driver.findElement(By.id("red"));
        Assert.assertFalse(redButton.isSelected()); // assertFalse will expect that condition is false
    }

    @Test(description = "Verify that Green button is unclickable")
    public void test3() {
        WebElement greenButton = driver.findElement(By.id("green"));
        Assert.assertFalse(greenButton.isEnabled());
    }

    //let's find all radio buttons and click on them one by one
    @Test(description = "Click on all radio buttons")
    public void test4() {
        //how to find all radio buttons?
        //find all radio buttons
        //any radio button will have type='radio' and input as a element type
        List<WebElement> radioButtons = driver.findElements(By.cssSelector("input[type='radio']"));
//        let's click only if button is not clicked and is available for clicking
        for (WebElement button : radioButtons) {
//            if button is available for clicking and not clicked yet
            if (button.isEnabled() && !button.isSelected()) {
//                then click on it
                button.click();
//                in this case, id attribute represents a name of the color
//                also, there is no text in this element
//                that's why I print attribute value
//                <input type="radio" id="green" name="color" disabled=""> attribute: type, id, name, disabled
                System.out.println("Button clicked: " + button.getAttribute("id"));
            } else {
                System.out.println("Button was not clicked: " + button.getAttribute("id"));
            }
            BrowserUtils.wait(1); // for demo
        }
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}