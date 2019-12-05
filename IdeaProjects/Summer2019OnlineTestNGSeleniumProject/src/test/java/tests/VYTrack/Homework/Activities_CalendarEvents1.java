package tests.VYTrack.Homework;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import tests.TestBase;
import utils.BrowserUtils;
import utils.Driver;

public class Activities_CalendarEvents1 extends TestBase {

    @Test(description = "Verify that page title is a 'Dashboard'")
    public void test1(){
        //create page object
        LoginPage loginPage = new LoginPage();
        //call login method
        //provide username and password
        loginPage.login("storemanager85", "UserUser123");

        WebDriverWait wait = new WebDriverWait(Driver.get(), 10);
        //this is an explicit wait
        //it waits until title is 'Dashboard'
        wait.until(ExpectedConditions.titleIs("Dashboard"));

        Assert.assertEquals(Driver.get().getTitle(),"Dashboard");
    }

    @Test(description = "Click on Activities_CalendarEvents")
    public void test2() {

        BrowserUtils.wait(2);
        BasePage actitivies = new BasePage();
        actitivies.navigateTo("Activities","Calendar Events");

    }



}
