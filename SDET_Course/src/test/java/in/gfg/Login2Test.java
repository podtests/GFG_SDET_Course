package in.gfg;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class Login2Test {

    @Parameters({"browserName"})
    @Test(groups = {"Regression"},  priority=2 )
    public void Test3(String browserName) {
        System.out.println("Test3");
    }

    @Test(enabled = false)
    public void Test2() {
        System.out.println("Test2");

    }

    @Test(priority=1, dependsOnMethods={"Test2"})
    public void Test4() {
        System.out.println("Test4");
    }


}
