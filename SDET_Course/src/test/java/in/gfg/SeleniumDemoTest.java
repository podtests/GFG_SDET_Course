package in.gfg;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SeleniumDemoTest{

    @Test
    public void WebDriverDemo() {

        //craete driver object
        ChromeOptions option = new ChromeOptions();

        option.addArguments("--headless");
        WebDriver wd = new ChromeDriver(option);

        wd.get("https://podtest.in");
        System.out.println("Title is: "+wd.getTitle());

        //To work on the element
        wd.findElement(By.xpath("//nav[@class='bm-item-list']/a")).click();

        //List of elements
        List<WebElement> l1 =  wd.findElements(By.xpath("//nav[@class='bm-item-list']/a"));
        Iterator<WebElement> it1 = l1.iterator();
        while(it1.hasNext()) {
            it1.next().click();
        }


        //mimick keyboard events or mouse events
        Actions a1 = new Actions(wd);
        WebElement ele1 = wd.findElement(By.xpath(""));
        a1.moveToElement(ele1).keyDown(Keys.SHIFT).sendKeys("akhil").build().perform();

        //wait strategies:
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  //implicit

        //explicit wait
        WebDriverWait wait;
        wait = new WebDriverWait(wd, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        //fluent wait:
        Wait fluentWait;
        fluentWait = new FluentWait(wd)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(locator));


        //webdriver methods:
        String currentWindow = wd.getWindowHandle();
        Set<String> handles =  wd.getWindowHandles();

        Iterator<String> it2 = handles.iterator();

        while(it2.hasNext()) {
            System.out.println(it2.next());
        }

        //Switching to alert
        wd.switchTo().alert().accept();

        //switching  to original window
        wd.switchTo().window(currentWindow);


        //frames
        wd.switchTo().frame(1);









    }
}
