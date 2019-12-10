package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.beust.jcommander.Parameter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.BrowserUtils;
import utils.ConfigurationReader;
import utils.Driver;

import java.io.IOException;

//this class will be a test foundation for all test classes
//we will put here only before and after parts
//In this way before and after methods will be the same
//Every test class will extend testbase class
public abstract class TestBase {

    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest;

    @BeforeTest
    @Parameters({"test","env_url"})
    public void beforeTest(@Optional String test, @Optional String env_url){
        String reportName = "report";
        if(test != null){
            reportName = test;
        }
    String filePath = System.getProperty("user.dir") + "/test-output/"+reportName+".html";
    extentReports = new ExtentReports();
    extentHtmlReporter = new ExtentHtmlReporter(filePath);
    extentReports.attachReporter(extentHtmlReporter);
    extentHtmlReporter.config().setReportName("Vytrack Test Results");

    //system information
        String env = ConfigurationReader.getProperty("url");
        if(env_url != null){
            env = env_url;
        }
    extentReports.setSystemInfo("Environment",env);
    extentReports.setSystemInfo("Browser",ConfigurationReader.getProperty("browser"));
    extentReports.setSystemInfo("OS", System.getProperty("os.name"));
    }

    @AfterTest
    public void afterTest(){
        extentReports.flush();
    }

    @BeforeMethod
    @Parameters("env_url")
    public void setup(@Optional String env_url){
        String url = ConfigurationReader.getProperty("url");
        //if name parameter was set, then use it
        //if it's null that means it was not set
        if(env_url != null){
            url=env_url;
        }
        Driver.get().get(url);

    }

    @AfterMethod
    public void teardown(ITestResult result)  {

        if(result.getStatus() == ITestResult.FAILURE){
            extentTest.fail(result.getName());
            extentTest.fail(result.getThrowable());
            try {
                extentTest.addScreenCaptureFromPath(BrowserUtils.getScreenshot(result.getName()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(result.getStatus() == ITestResult.SKIP){
            extentTest.skip("Test case was skipped: "+result.getName());
        }

        Driver.close();
    }
}