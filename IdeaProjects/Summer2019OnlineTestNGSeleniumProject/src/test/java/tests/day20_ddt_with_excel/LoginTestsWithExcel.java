package tests.day20_ddt_with_excel;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests.TestBase;
import utils.Driver;
import utils.ExcelUtil;

import java.util.Map;

public class LoginTestsWithExcel extends TestBase {

    @Test(dataProvider = "credentials", description = "Login with different credentials")
    public void loginTest(String username, String password, String firstName, String lastName, String result){
        extentTest = extentReports.createTest("Login as " + username);
        if (username.equals("username")){
            throw new SkipException("failed");
        }else{
            LoginPage loginPage = new LoginPage();
            loginPage.login(username,password);
            loginPage.getPageSubTitle();
            Assert.assertEquals(Driver.get().getTitle(),"Dashboard");
            extentTest.pass("Login test passed for user "+username);
        }



    }



    //it is a test data supplier
    //as many sets of data it returns
    //as many times exactly tes will run
    @DataProvider(name = "credentials")
    public static Object[][] credentials(){
        ExcelUtil qa2 = new ExcelUtil("vytrack_testusers.xlsx", "QA2-short");
        return qa2.getDataArray();
    }

//    public static void main(String[] args) {
//        ExcelUtil qa2 = new ExcelUtil("vytrack_testusers.xlsx", "QA2-short");
//        System.out.println("Row count: "+qa2.rowCount());
//        System.out.println(qa2.getColumnsNames());
//        System.out.println(qa2.getDataList());
//
//        for(Map<String, String> map: qa2.getDataList()){
//            System.out.println(map);
//        }
//    }
}
