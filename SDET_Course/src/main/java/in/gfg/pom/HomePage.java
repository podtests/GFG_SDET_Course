package in.gfg.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    WebDriver wd;

    By cartIcon = By.xpath("//a[@class='mini-cart-icon']");

    public HomePage(WebDriver wd) {
        this.wd = wd;

    }

    public HomePage clickCartIcon() {
        wd.findElement(this.cartIcon).click();
        return this;
    }
}
