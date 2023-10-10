package in.gfg;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ElementDemoTest {
    WebDriver wd;
    WaitManager wait;

    String siteURL = "https://www.saucedemo.com/";
    String siteURL2 = "https://selectorshub.com/xpath-practice-page/";
    By userName = By.xpath("//input[@id='userId']");

    By userNameSauceDemo = By.cssSelector("#user-name");
    By password = By.id("password");

    @Parameters({"browserName"})
    @BeforeClass(groups={"windows"})
    public void setWebDriver(String browser) {
        //wd = ManageDrivers.getDriver(browser);
        wd = ManageDrivers.getRemoteDriver(browser);
        wait = new WaitManager(wd);
    }

    @Test(priority = 1)
    public void openPage() {
        wd.get(siteURL2);
        //wd.navigate().to(siteURL2);
        //wd.navigate().refresh();
        //wd.navigate().to(siteURL);
        //wd.navigate().back();

    }

    @Test(priority = 2)
    public void workOnTables() {
        wait.explicitWait(userName);

        //fetch column name of the table
       List<WebElement> list2  = wd.findElements(By.xpath("//table[@id='resultTable']/thead//th/a"));

        Iterator<WebElement> it1 = list2.iterator();
        while(it1.hasNext()){
            System.out.println("th value is: "+it1.next().getText());

        }

        // Fetching tables rows data cell by cell
        List<WebElement> list3 = wd.findElements(By.xpath("//table[@id='resultTable']//tbody/tr"));

        Iterator<WebElement> it2 = list3.iterator();
        while(it2.hasNext()){
            List<WebElement> list4 =  it2.next().findElements(By.xpath("td[@class='left']"));  //tr[1]/td
            Iterator<WebElement> it3 = list4.iterator();

            while(it3.hasNext()){
                System.out.println("Cell value is:"+it3.next().getText());
            }

        }

    }

   @Test(priority = 1, dependsOnMethods = {"openPage"}, enabled = false)
    //@Test(priority=2)
    public void loginSuccess() {
        wait.explicitWait(userNameSauceDemo);
        wd.findElement(userNameSauceDemo).sendKeys("standard_user");
        wd.findElement(password).sendKeys("secret_sauce");

        wd.findElement(By.className("submit-button")).click();

       //WebElement ele1 = wd.findElement(userNameSauceDemo);

       //Actions a1 = new Actions(wd);
       // a1.moveToElement(ele1).click().keyDown(Keys.SHIFT).sendKeys("akhil").keyUp(Keys.SHIFT).perform();

    }

    @Test(priority = 2, enabled = false)
    public void getDropdownValues() {
        wait.explicitWait(By.cssSelector(".shopping_cart_link"));

        //System.out.println("Alert Textbox is: "+wd.switchTo().alert().getText());
        //wd.switchTo().alert().accept();

        //dropdwon
        Select dd = new Select(wd.findElement(By.cssSelector(".product_sort_container")));

        List<WebElement> list1 = dd.getOptions();

        Iterator<WebElement> it1 = list1.iterator();
        while(it1.hasNext()){
            System.out.println("option value is: "+it1.next().getText());
        }

        dd.selectByIndex(2);

        //





    }

    @Test(enabled=false)
    public void clickRadioButton() {
        System.out.println("Radio");
    }


    @Test(groups={"windows"})
    public void workOnWindowHandles() {

        wd.get("http://127.0.0.1:5501/MyFirstWebPage.html");

        String parentWindowHandle = wd.getWindowHandle();

        wd.findElement(By.xpath("//a[@id='Website-id']")).click();
        wd.findElement(By.xpath("//a[@id='LinkedIn-id']")).click();
        wd.findElement(By.xpath("//a[@id='Youtube']")).click();

        Set<String> set1 = wd.getWindowHandles();

        Iterator<String> it1 = set1.iterator();
        while(it1.hasNext()) {
            System.out.println(it1.next());
        }

        wd.switchTo().window(parentWindowHandle);



    }

    @AfterSuite
    public void cleanTestSuite() {
        //wd.quit();
    }
}
