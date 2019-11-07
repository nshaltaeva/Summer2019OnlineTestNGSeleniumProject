package tests.VYTrack;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.Arrays;


public class loginPage {

    WebDriver driver; //instance variable

    //Method that open Login page of VyTrack App
    public void OpenLoginPage(){
        driver = BrowserFactory.getDriver("chrome");
       // driver = new ChromeDriver();
        driver.get("https://qa2.vytrack.com/user/login");

    }

    public void LoginWithValidCredentials(){
       // WebDriver driver = BrowserFactory.getDriver("chrome");
        //go to qa2.vytrack.com to put valid credentials
       // driver.get("https://qa2.vytrack.com/user/login");
        OpenLoginPage();
        //put valid username: storemanager219, storemanager220, storemanager221
        String [] usernames = {"storemanager219", "storemanager220", "storemanager221"};
        String  passwords = "UserUser123";

            String res = "";
           for (int i=0; i<usernames.length;i++) {
              BrowserUtils.wait(2);


                //find username's input box
                WebElement input = driver.findElement(By.xpath("//*[@id=\"prependedInput\"]"));
                //put valid username
                input.sendKeys(usernames[i]);
                //find password's input box
                WebElement input2 = driver.findElement(By.xpath("//*[@id=\"prependedInput2\"]"));
                //put valid password
                input2.sendKeys(passwords);

                //BrowserUtils.wait(2);

                //find LOGIN button
                WebElement button = driver.findElement(By.xpath("//*[@id=\"_submit\"]"));
                BrowserUtils.wait(2);
                //click on that button
                button.click();
                BrowserUtils.wait(5);

                //To click logout option from DropDown button
                driver.findElement(By.xpath("//*[@id=\"user-menu\"]")).click();
                BrowserUtils.wait(2);
                WebElement LogoutButton = driver.findElement(By.xpath("//*[@id=\"user-menu\"]/ul/li[5]"));
                LogoutButton.click();

               String expectedUrl = "https://qa2.vytrack.com/user/login";
               String actualURL = driver.getCurrentUrl();
               System.out.println(actualURL);

               if(actualURL.equals(expectedUrl)){
                   System.out.println("Test Passed, You are in the Home Page");
               }else {
                   System.out.println("Test Failed");
               }

               BrowserUtils.wait(2);

        }
    //    WebElement input = driver.findElement(By.id("prependedInput"));
     //   input.sendKeys("storemanager220");
        //put valid password: UserUser123
     //   WebElement input2 = driver.findElement(By.id("prependedInput2"));
     //   input2.sendKeys("UserUser123");
        //find LOGIN button
     //   WebElement button = driver.findElement(By.id("_submit"));
     //   BrowserUtils.wait(2);
        //click on that button
     //   button.click();

/*
        String expectedUrl = "https://qa2.vytrack.com/";
        String actualURL = driver.getCurrentUrl();

        if(actualURL.equals(expectedUrl)){
            System.out.println("Test Passed, You are in the Home Page");
        }else {
            System.out.println("Test Failed");
        }

        BrowserUtils.wait(2);
*/
        driver.close();

    }

    public void LoginWithInvalidCredentials(){

        ArrayList<String> InvalidUsernames = new ArrayList<>(Arrays.asList("storemanager", "user", "salesmanager"));
        String password = "UserUser123";
        for(int i =0; i<InvalidUsernames.size();i++) {

            BrowserUtils.wait(4);
            //this method open login page of VyTrack from chrome browser
            OpenLoginPage();
            //put invalid usernames
            BrowserUtils.wait(2);
            WebElement input = driver.findElement(By.xpath("//*[@id=\"prependedInput\"]"));
            input.sendKeys(InvalidUsernames.get(i));
            //put password: UserUser123
            BrowserUtils.wait(2);
            WebElement input2 = driver.findElement(By.xpath("//*[@id=\"prependedInput2\"]"));
            input2.sendKeys(password);
            //find LOGIN button
            WebElement button = driver.findElement(By.xpath("//*[@id=\"_submit\"]"));
            BrowserUtils.wait(2);
            //click on that button
            button.click();

            //finding elements with message "Invalid username or password"
            String InvalidMessage = "//*[@id=\"login-form\"]/fieldset/div[1]/div";
            WebElement element = driver.findElement(By.xpath(InvalidMessage));
            BrowserUtils.wait(2);
            //verifying that message "Invalid username or password"
            System.out.println(element.getText());

            driver.close();
        }

       }

    public static void main(String[] args) {

        loginPage obj = new loginPage();
          //  obj.LoginWithValidCredentials();
             obj.LoginWithInvalidCredentials();

    }

}
