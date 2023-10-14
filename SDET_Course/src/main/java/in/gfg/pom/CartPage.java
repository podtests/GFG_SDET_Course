package in.gfg.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver wd ;

    By checkOutButton = By.xpath("//button[@id='checkout']");

    public CartPage(WebDriver wd) {
        this.wd = wd;
    }

    public CartPage get() {
        this.wd.get("https://www.saucedemo.com/cart.html");
        return this;
    }

    public void clickCheckOut() {
        this.wd.findElement(checkOutButton).click();
    }


}
