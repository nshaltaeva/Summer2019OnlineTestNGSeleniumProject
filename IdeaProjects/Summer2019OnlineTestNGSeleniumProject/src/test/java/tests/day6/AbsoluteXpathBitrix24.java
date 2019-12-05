package tests.day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class AbsoluteXpathBitrix24 {

    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://login1.nextbasecrm.com/?login=yes");
        //click on login without entering username and password
        //to invoke warning message
        BrowserUtils.wait(3);
        driver.findElement(By.className("login-btn")).click();
        BrowserUtils.wait(2);
        //finding element with locator xPath by Absolute way
        WebElement warningMessage = driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/div/div/div[2]"));
        //finding element with locator xPath by Relative way
        WebElement warningMessage2 = driver.findElement(By.xpath("//div[@class='errortext']"));

        System.out.println(warningMessage.getText());//to read the text of warning message
        System.out.println(warningMessage2.getText());//to read the text of warning message
        driver.quit();



    }


}
