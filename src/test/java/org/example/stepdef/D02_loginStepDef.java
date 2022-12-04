package org.example.stepdef;

import static org.example.stepdef.hooks.driver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.page.P02_login;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

public class D02_loginStepDef {
    P02_login login = new P02_login();
    @Given ("user go to login page")
    public void step1(){
        login.login().click();
    }

    @When("user login with {string} and {string}")
    public void userLoginWithAnd(String arg0, String arg1) {
        login.Email().sendKeys(arg0);
        login.password().sendKeys(arg1);
    }

    @And("user press on login button")
    public void userPressOnLoginButton() {
        login.loginButton().click();
    }

    @Then("user login to the system successfully")
    public void userLoginToTheSystemSuccessfully() {
        SoftAssert soft = new SoftAssert();
        String actualUrl = driver.getCurrentUrl();
        soft.assertEquals(actualUrl,"https://demo.nopcommerce.com/");
        boolean Myaccount = login.Myaccount().isDisplayed();
        soft.assertTrue(Myaccount);
        soft.assertAll();
    }

    @Then("user could not login to the system")
    public void userCouldNotLoginToTheSystem() {
        SoftAssert soft = new SoftAssert();
        String actualMsg = login.WrongMsg().getText();
        soft.assertEquals(actualMsg,"Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found");
        String actualCol = login.WrongMsg().getCssValue("color");
        actualCol = Color.fromString(actualCol).asHex();
        soft.assertEquals(actualCol,"#e4434b");
        soft.assertAll();
    }


}
