package in.gfg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ManageDrivers {

     static WebDriver wd;

    public static WebDriver getDriver(String browserName) {

        switch( browserName) {
            case "chrome": {
                wd = new ChromeDriver();
                break;
            }
            case "firefox": {
                wd = new FirefoxDriver();
                break;
            }
            default: {
                wd = new ChromeDriver();
                break;
            }
        }

        return wd;

    }

}
