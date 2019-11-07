package tests.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class EnterTextPractice {

    public static void main(String[] args) {
        //grey text "browser" is not a value
        //it's a placeholder/ or name of the method parameter
        //you dn't enter that
        //it comes up automatically
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement inputbox = driver.findElement(By.name("email"));
        //we enter the text
        inputbox.sendKeys("random@email.com");
        WebElement button = driver.findElement(By.id("form_submit"));
        //to click on the element
        button.click();

        /* ###Test 2, Verify that email changed
        1. Go to "http://practice.cybertekschool.com/forgot_password"
        2. Enter any valid email
        3. Click on retrieve password button
        4. Verify that URL is equals to "http://practice.cybertekschool.com/email_sent"
        */

        String expectedURL = "http://practice.cybertekschool.com/email_sent";
        String actualURL = driver.getCurrentUrl();
        System.out.println(actualURL);
        if(expectedURL.equals(actualURL)){
            System.out.println("Test passed");
        }
        else{
            System.out.println("Test failed");
        }


        BrowserUtils.wait(2);
        driver.close();





    }
}
