package org.example.stepdef;
import static org.example.stepdef.hooks.driver;

import io.opentelemetry.sdk.trace.internal.data.ExceptionEventData;
import org.example.page.homepage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class D07_followUsStepDef {
    homepage home = new homepage();

    @When("user scroll down  the page")
    public void step1() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = home.downpage();
        js.executeScript("arguments[0].scrollIntoView();", element);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    @And("user open link {string}")
    public void userOpenFacebookLink(String social) {
        home.social(social).click();
    }

    @Then("new tap is opened expected {string}")
    public void newTapIsOpened(String expected) {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> tabs = driver.getWindowHandles();
        ArrayList<String> arraytabs = new ArrayList<String>(tabs);
        driver.switchTo().window(arraytabs.get(1));
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expected);
        driver.close();
        driver.switchTo().window(arraytabs.get(0));
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }
}
