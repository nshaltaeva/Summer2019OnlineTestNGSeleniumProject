package tests.VYTrack;


import org.testng.annotations.Test;
import pages.CreateCarPage;
import pages.LoginPage;
import pages.VehiclesPage;
import tests.TestBase;

public class CreateACarTests extends TestBase {
    @Test(description = "Create some random car")
    public void test1(){
        extentTest = extentReports.createTest("Create a new car");
        LoginPage loginPage = new LoginPage();
        VehiclesPage vehiclesPage = new VehiclesPage();
        CreateCarPage createCarPage = new CreateCarPage();
        loginPage.login("storemanager85", "UserUser123");
        loginPage.navigateTo("Fleet", "Vehicles");
        loginPage.waitUntilLoaderMaskDisappear();
        vehiclesPage.clickToCreateACar();
        loginPage.waitUntilLoaderMaskDisappear();
        createCarPage.licensePlateElement.sendKeys("Random");
        createCarPage.selectTags("Compact");
        createCarPage.selectFuelType("Diesel");
        createCarPage.saveAndCloseButtonElement.click();

        extentTest.pass("New car was created");
    }
}
