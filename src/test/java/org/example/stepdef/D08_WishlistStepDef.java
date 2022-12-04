package org.example.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.page.homepage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.css.CSS;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


import static org.example.stepdef.hooks.driver;

public class D08_WishlistStepDef {
    homepage home = new homepage();

    @When("user click on wishList button")
    public void step1() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = home.wishList();
        js.executeScript("arguments[0].scrollIntoView();", element);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        home.wishlistbutton().get(2).click();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    }

    @Then("successfully added to WishList")
    public void successfullyAddedToWishList() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        SoftAssert soft = new SoftAssert();
        String actualMsg = home.text().getText();
        soft.assertEquals(actualMsg,"The product has been added to your wishlist");
        String actualCol = home.BackGroundRec().getCssValue("background-color");
        actualCol = Color.fromString(actualCol).asHex();
        soft.assertEquals(actualCol,"#4bb07a");
        soft.assertAll();
    }

    @And("user click on WishListTap")
    public void userClickOnWishList() throws InterruptedException {
        home.closeTap().click();
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = home.wishListTap();
        js.executeScript("arguments[0].scrollIntoView();", element);
        home.wishListTap().click();

    }

    boolean check = false;
    @Then("get QTy value bigger than zero")
    public void getQTyValueBiggerThan() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        String number = home.Qty().getAttribute("value");
        int num = Integer.parseInt(number);
        //System.out.println(num);
        if(num > 0){
           check = true ;
        }
        Assert.assertTrue(check);

    }
}
