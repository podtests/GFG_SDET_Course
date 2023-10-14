package in.gfg;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

public class ActionDemo {

    @Test(enabled = false)
    public void buildTest() {
        ChromeOptions option = new ChromeOptions();

        //option.addArguments("--headless");
        WebDriver wd = new ChromeDriver(option);


        wd.get("https://www.saucedemo.com/");


        Actions a1 = new Actions(wd);
        a1.moveToElement(wd.findElement(By.cssSelector("#user-name"))).click().keyDown(Keys.SHIFT).sendKeys("akhil").keyUp(Keys.SHIFT).perform();

    }

    @Test
    public void iteratorTest() {
        ChromeOptions option = new ChromeOptions();

        //option.addArguments("--headless");
        WebDriver wd = new ChromeDriver(option);
        wd.get("https://selectorshub.com/xpath-practice-page/");

        Select dd = new Select(wd.findElement(By.id("cars")));

       // dd.selectByValue("saab");


        List<WebElement> list1 = dd.getOptions();

        Iterator<WebElement> it1 = list1.iterator();
        WebElement e1 = null;

        while(it1.hasNext()){

            e1 = it1.next();
            if (e1.getText().equals("Saab")) {
                e1.click();
            }

        }

        dd.selectByIndex(2);


    }
}
