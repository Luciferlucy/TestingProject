package org.example.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.example.stepdef.hooks.driver;
import org.example.page.registerpage;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.util.SortedMap;

public class registration {
    registerpage register = new registerpage();
    @Given ("user go to register page")
    public void step1(){
        //driver.findElement(By.className("ico-register")).click();
        //WebElement reg = driver.findElement(By.className("ico-register"));
        //reg.click();
        register.register().click();
    }

    @When("user select gender type")
    public void userSelectGenderType() {

        register.gender().click();
    }

    @And("user enter first {string} and last name {string}")
    public void userEnterFirstAndLastName(String arg0,String arg1) {
        register.firstname().sendKeys(arg0);
        register.lastname().sendKeys(arg1);
    }

    @And("user enter Date of birth")
    public void userEnterDateOfBirth() {
        Select day = new Select(register.daylist());
        day.selectByValue("15");
        Select month = new Select(register.monthlist());
        month.selectByValue("1");
        Select year = new Select(register.yearlist());
        year.selectByValue("2001");

    }

    @And("user enter valid email {string}")
    public void userEnterValidEmail(String arg0) {

        register.email().sendKeys(arg0);
    }

    @And("user enter password {string} & confirm password {string}")
    public void userEnterPasswordConfirmPassword(String arg0,String arg1) {
        register.password().sendKeys(arg0);
        register.confpassword().sendKeys(arg1);

    }

    @And("user click on register button")
    public void userClickOnRegisterButton() {
        register.buttonreg().click();
    }

    @Then("account created successfully")
    public void accountCreatedSuccessfully() {
        SoftAssert soft = new SoftAssert();
        String actualUrl = driver.getCurrentUrl();
        soft.assertEquals(actualUrl,"https://demo.nopcommerce.com/registerresult/1?returnUrl=/");
        String actualMsg = register.successMsg().getText();
        soft.assertEquals(actualMsg,"Your registration completed");
        String actualCol = register.successMsg().getCssValue("color");
        actualCol = Color.fromString(actualCol).asHex();
        soft.assertEquals(actualCol,"#4cb17c");
        boolean statusbut = register.Continue().isDisplayed();
        soft.assertTrue(statusbut);
        soft.assertAll();
    }
}
