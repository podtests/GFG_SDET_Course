package in.gfg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

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

    public static WebDriver getRemoteDriver(String browserName)  {
        ChromeOptions option = null;

        switch( browserName) {
            case "chrome": {
                option = new ChromeOptions();
                break;
            }
            default: {
                wd = new ChromeDriver();
                break;
            }
        }

        try {
            wd = new RemoteWebDriver(new URL("http://localhost:4444"),option);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return wd;
    }

}
