package in.gfg.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

    WebDriver wd ;
    By emailInput = By.xpath("//input[@id='user-name']");
    By passwordInput = By.xpath("//input[@id='password']");

    By loginButton = By.xpath("//input[@id='login-button']");

    public LoginPage(WebDriver wd) {
        this.wd = wd;
    }

    public LoginPage get() {
        this.wd.get("https://www.saucedemo.com/");
        return this;
    }

    public void fillUserName( String userName) {
        wd.findElement(this.emailInput).sendKeys(userName);
    }

    public LoginPage fillLoginDetails( String UN, String pw) {
        wd.findElement(this.emailInput).sendKeys(UN);
        wd.findElement(passwordInput).sendKeys(pw);
        return this;
    }

    public void clickLoginButton() {
        wd.findElement(loginButton).click();
    }
}
