package in.gfg.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

    WebDriver wd ;
    By emailInput = By.xpath("//input[@name='email']");
    By passwordInput = By.xpath("//input[@name='password']");

    By loginButton = By.xpath("//button[@type='submit']");

    public LoginPage(WebDriver wd) {
        this.wd = wd;
    }

    public LoginPage get() {
        this.wd.get("https://demo.evershop.io/account/login");
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
