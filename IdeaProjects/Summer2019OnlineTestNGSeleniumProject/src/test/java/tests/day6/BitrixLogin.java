package tests.day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class BitrixLogin {

    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        //go to Bitrix
        driver.get("https://login1.nextbasecrm.com/?login=yes");
        //enter username or email
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("marketing59@cybertekschool.com");
        //enter password
        //inside locator * matches ane element
        driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("UserUser");
        //click on login button
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//input[starts-with(@value, 'Log')]")).click();

        driver.quit();

    }
}
