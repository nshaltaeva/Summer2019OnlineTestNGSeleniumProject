package tests.VYTrack.Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;

public class Activities_CalendarEvents2 {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup(){
        // 1.Go to “https://qa1.vytrack.com/"
        // 2.Login as a store manager
        // 3.Navigate to “Activities -> Calendar Events”
        driver = BrowserFactory.getDriver("chrome");
        wait = new WebDriverWait(driver, 15);
        driver.get("https://qa1.vytrack.com/");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);
        BrowserUtils.wait(4);
        WebElement activitiesElement = driver.findElement(By.linkText("Activities"));
        wait.until(ExpectedConditions.visibilityOf(activitiesElement));
        wait.until(ExpectedConditions.elementToBeClickable(activitiesElement));
        activitiesElement.click();
        WebElement calendarEventsElement = driver.findElement(By.linkText("Calendar Events"));
        wait.until(ExpectedConditions.visibilityOf(calendarEventsElement));
        wait.until(ExpectedConditions.elementToBeClickable(calendarEventsElement));
        calendarEventsElement.click();
        WebElement loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));

    }

    @AfterMethod
    public void teardown(){        driver.quit();    }

    @Test (description = "Verify that “view”, “edit” and “delete” options are available")
    public void test1(){
        //Test Case #1
        //4.Hover on three dots “...” for “Testers meeting” calendar event
        //5.Verify that “view”, “edit” and “delete” options are available
        Actions action = new Actions(driver);

        WebElement ThreeDots = driver.findElement(By.xpath("//table/tbody/tr[3]/td[9]"));

        action.moveToElement(ThreeDots).build().perform();
        BrowserUtils.wait(2);
       List<WebElement> textOnDots = driver.findElements(By.xpath("//table/tbody/tr[3]/td[9]/div/div/ul/li/ul/li"));

        for (WebElement textOnDot: textOnDots) {
              System.out.println(textOnDot.getText());
              Assert.assertTrue(textOnDot.getText().contains("View"));
        }

    }

    @Test (description = "Verify that “Title” column still displayed")
    public void test2(){
        //4.Click on “Grid Options” button
        // 5.Deselect all options except “Title”
        // 6.Verify that “Title” column still displayed
        //checkboxes = td[@class='visibility-cell']
        WebElement GridOptions = driver.findElement(By.xpath("//i[@class='fa-cog hide-text']"));
        BrowserUtils.wait(2);
        GridOptions.click();

        List<WebElement> desireOptions = driver.findElements(By.xpath("//tr[@class='renderable']//label"));
        List<WebElement> options = driver.findElements(By.xpath("td[@class='visibility-cell']//input"));
        int index = 2;
        for (int i=0; i<desireOptions.size();i++) {
        /*    if(checkbox.isEnabled() && !checkbox.isSelected())  {
                checkbox.click();
                System.out.println("Checkbox #"+index+" clicked");
            }else {
                System.out.println("Checkbox #"+index+" was not clicked");
            }
            index++;

         */
        if(desireOptions.get(i).getText().equalsIgnoreCase("Calendar")){
            BrowserUtils.wait(1);
            options.get(i).click();
        }
        }
    }
}
