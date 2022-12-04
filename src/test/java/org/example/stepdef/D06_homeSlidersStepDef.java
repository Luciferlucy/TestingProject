package org.example.stepdef;
import static org.example.stepdef.hooks.driver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.page.homepage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class D06_homeSlidersStepDef {
    homepage home = new homepage();
    @When("user press on the slider {string}")
    public void step1(String x){
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10) );
        wait.until(ExpectedConditions.attributeContains(home.controlbutton(x),"class","nivo-control active"));
        //wait.until(ExpectedConditions.attributeToBe(home.controlbutton(),"rel",x));
        //home.controlbutton().get(x).click();

    }

    @And("user press on the image")
    public void userPressOnTheIphoneImage()  {
        //driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        home.img().click();
    }

    @Then("user must go to another webpage {string}")
    public void userMustGoToAnotherWebpage(String expected)  {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expected);

    }




}
