package in.gfg.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.*;

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


    public Map<String, List<WebElement>> getTableMap() {

        Map<String, List<WebElement>> tableMap = new HashMap<String,List<WebElement> >();

        List<WebElement> columnList = wd.findElements(By.xpath("//div[@id='shopping-cart-items']//thead//td"));

        List<WebElement> rowList = wd.findElements(By.xpath("//div[@id='shopping-cart-items']//tbody//tr"));
        tableMap.put("Column",columnList);
        tableMap.put("Rows", rowList);

        return tableMap;
    }


    public void getRowData(int indexRow) {
        List<WebElement> rows = this.getTableMap().get("Rows");

        Map<Integer, List<String>> rowMap = new HashMap<Integer, List<String>>();

        //Iterator<WebElement> rowIterator = rows.iterator();
        List<WebElement> rowItems = null;

        //List<String> cellInfo = new ArrayList<String>();

        for (WebElement row: rows) {
            List<String> cellInfo = new ArrayList<String>();
            rowItems = row.findElements(By.tagName("td"));

            cellInfo.add(rowItems.get(0).findElement(By.cssSelector("div.cart-tem-info>a")).getText());
            cellInfo.add(rowItems.get(1).findElement(By.cssSelector(".sale-price")).getText());
            cellInfo.add(rowItems.get(2).getText());
            cellInfo.add(rowItems.get(3).getText());

            rowMap.put(0, cellInfo);

        }


         =  rows.get().findElements(By.tagName("td"));








    }


    public CartPage getCartTableColumnNames() {


        List<WebElement> columnList = wd.findElements(By.xpath("//div[@id='shopping-cart-items']//thead//td"));
        //Iterator<WebElement> columnIterator = columnList.iterator();

        for (WebElement e:columnList) {
            System.out.println(e.getText());
        }

        return this;

    }


    public CartPage getCartItemsDetails() {
        List<WebElement> rowList = wd.findElements(By.xpath("//div[@id='shopping-cart-items']//tbody//tr"));

        Iterator<WebElement> rowIterator = rowList.iterator();
        WebElement rowElement = null;
        List<WebElement>  cellList =null;

        while(rowIterator.hasNext()) {
            rowElement = rowIterator.next();
            cellList = rowElement.findElements(By.tagName("td"));

            System.out.println(cellList.get(0).findElement(By.cssSelector("div.cart-tem-info>a")).getText());
            System.out.println(cellList.get(1).findElement(By.cssSelector(".sale-price")).getText());
            System.out.println(cellList.get(2).getText());
            System.out.println(cellList.get(3).getText());
        }

        return this;

    }

    public void removeItemByName(String name) {

    }

    public void openItemPageBasedOnIndex(int indexPos) {

    }


}
