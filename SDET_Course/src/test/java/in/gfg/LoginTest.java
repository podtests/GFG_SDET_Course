package in.gfg;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class LoginTest {




    WebDriver wd ;
    @BeforeSuite
    public void method1() {
        System.out.println("Before Suite");
    }

    @BeforeClass
    public void method2() {
        System.out.println("Before Class");
    }

    @BeforeTest
    public void method3() {
        System.out.println("Before Test");
    }

    @BeforeMethod
    public void method4() {
        System.out.println("Before Method");
    }

    @BeforeGroups
    public void method5() {
        System.out.println("Before Group");
    }

    @AfterSuite
    public void method11() {
        System.out.println("After Suite");
    }

    @AfterClass
    public void method12() {
        System.out.println("After Class");
    }

    @AfterTest
    public void method13() {
        System.out.println("After Test");
    }

    @AfterMethod
    public void method14() {
        System.out.println("After Method");
    }

    @AfterGroups
    public void method15() {
        System.out.println("After Group");
    }

    @Test(groups = {"Sanity", "Regression"})
    public void loginSuccess(String browserName) {
        System.out.println("Test1");
        ManageDrivers.getDriver("sdhagsdh");


    }

    @Test(groups = { "Regression"})
    public void Test2() {
        System.out.println("Test2");

    }


}
