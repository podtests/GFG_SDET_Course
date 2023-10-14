package in.gfg.testcases;

import in.gfg.ManageDrivers;
import in.gfg.pom.CartPage;
import in.gfg.pom.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver wd;
    LoginPage login;
    CartPage cart;


    @Parameters({"browserName"})
    @BeforeClass
    public void preSteps(String browser) {
      wd =  ManageDrivers.getRemoteDriver(browser);
        login = new LoginPage(wd);
       cart = new CartPage(wd);
    }

    @Test(priority=1)
    public void LoginSuccess() {
        login.get().fillLoginDetails("standard_user","secret_sauce").clickLoginButton();

    }

    @Test(priority=2)
    public void chekoutTest() {
        cart.get().clickCheckOut();
    }


}
