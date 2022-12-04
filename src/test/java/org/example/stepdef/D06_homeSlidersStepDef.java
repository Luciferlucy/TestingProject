package org.example.stepdef;
import static org.example.stepdef.hooks.driver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.page.homepage;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class D06_homeSlidersStepDef {
    homepage home = new homepage();
    @When("user press on the slider {int}")
    public void step1(int x){
        home.controlbutton().get(x).click();

    }

    @And("user press on the image")
    public void userPressOnTheIphoneImage()  {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        home.img().click();
    }

    @Then("user must go to another webpage {string}")
    public void userMustGoToAnotherWebpage(String expected)  {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expected);

    }




}
