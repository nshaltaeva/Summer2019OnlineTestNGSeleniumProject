package tests.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestForTagNameLocator {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");
        //if you want to do in one line, without creating webelemnt reference variable
        //enter full name
        driver.findElement(By.name("full_name")).sendKeys("Test User");
        //enter email
        driver.findElement(By.name("email")).sendKeys("test_email@email.com");
        //click sign up
        driver.findElement(By.name("wooden_spoon")).click();
        //pause for 3 seconds
        BrowserUtils.wait(3);

        WebElement sub_header = driver.findElement(By.tagName("h3"));
        System.out.println(sub_header.getText());
        driver.quit();


    }
}
