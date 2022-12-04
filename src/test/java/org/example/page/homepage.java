package org.example.page;

import org.apache.commons.exec.ExecuteWatchdog;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.example.stepdef.hooks.driver;

public class homepage {
    public WebElement currencyList(){
        return driver.findElement(By.id("customerCurrency"));
    }
    public List<WebElement> prices(){
        return driver.findElements(By.cssSelector("span[class=\"price actual-price\"]"));
    }
    public WebElement searchField(){
        return driver.findElement(By.className("ui-autocomplete-input"));
    }
    public WebElement searchButton(){
        return driver.findElement(By.cssSelector("button[class=\"button-1 search-box-button\"]"));
    }
    public List<WebElement> AddCard(){
        return  driver.findElements(By.cssSelector("button[class=\"button-2 product-box-add-to-cart-button\"]"));
    }
    public List<WebElement> productname(){
        return driver.findElements(By.cssSelector("h2[class=\"product-title\"]"));
    }
    public WebElement product(){
        return driver.findElement(By.cssSelector("div[class=\"picture\"]"));
    }
    public WebElement sku(){
        return driver.findElement(By.cssSelector("span[id=\"sku-36\"]"));
    }
    public List<WebElement> categories(){
        return driver.findElements(By.xpath("//ul[@class=\"top-menu notmobile\"]/li"));
    }
    public List<WebElement> locator (int selectedCategory){
        //return driver.findElements(By.xpath(locator));
        return driver.findElements(By.xpath("(//ul[@class='top-menu notmobile']//ul)["+selectedCategory+"]/li"));
    }
    public WebElement title(){
        return driver.findElement(By.cssSelector("div[class=\"page-title\"]"));
    }

    public List<WebElement> controlbutton(){
        return driver.findElements(By.cssSelector("div[class=\"nivo-controlNav\"]"));
    }
    public WebElement img(){
        return driver.findElement(By.cssSelector("div[id=\"nivo-slider\"]"));
    }
    public WebElement social(String social){
         return driver.findElement(By.linkText(social));
    }
    public WebElement downpage(){
        return driver.findElement(By.cssSelector("div[class=\"newsletter\"]"));
    }
    public WebElement wishList(){
        return driver.findElement(By.cssSelector("div[class=\"product-grid home-page-product-grid\"]"));
    }
    public List<WebElement> wishlistbutton(){
        return driver.findElements(By.cssSelector("button[class=\"button-2 add-to-wishlist-button\"]"));
    }
    public WebElement BackGroundRec(){
        return driver.findElement(By.cssSelector("div[class=\"bar-notification success\"]"));
    }
    public WebElement text(){
        return driver.findElement(By.cssSelector("p[class=\"content\"]"));
    }
    public WebElement wishListTap(){
        return driver.findElement(By.cssSelector("span[class=\"wishlist-label\"]"));
    }
    public WebElement closeTap(){
        return driver.findElement(By.cssSelector("span[class=\"close\"]"));
    }
    public WebElement Qty(){
        return driver.findElement(By.cssSelector("input[class=\"qty-input\"]"));
    }

}
