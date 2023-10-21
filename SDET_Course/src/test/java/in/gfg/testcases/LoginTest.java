package in.gfg.testcases;

import in.gfg.ManageDrivers;
import in.gfg.pom.CartPage;
import in.gfg.pom.HomePage;
import in.gfg.pom.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver wd;
    LoginPage login;
    CartPage cart;

    HomePage home ;


    @Parameters({"browserName"})
    @BeforeClass
    public void preSteps(String browser) {
      wd =  ManageDrivers.getRemoteDriver(browser);
        login = new LoginPage(wd);
        home = new HomePage(wd);
       cart = new CartPage(wd);
    }

    @Test(priority=1)
    public void LoginSuccess() {

        login.get().fillLoginDetails("akhiljda@gmail.com","Password").clickLoginButton();

    }

    @Test(priority=2)
    public void openCartPage() throws InterruptedException {
        Thread.sleep(3000);
        home.clickCartIcon();
        cart.getCartTableColumnNames().getCartItemsDetails();
        //cart.get().clickCheckOut();
    }


}
