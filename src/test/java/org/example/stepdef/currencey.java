package org.example.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.example.page.homepage;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class currencey {
    homepage home = new homepage();
    @Then("first option is dollar")
    public void step1(){
        Select currList = new Select(home.currencyList());
        String firstOption = currList.getFirstSelectedOption().getText();
        Assert.assertEquals(firstOption,"US Dollar");
    }

    @When("user select Euro option")
    public void userSelectEuroOption() {
        Select currList = new Select(home.currencyList());
        currList.selectByVisibleText("Euro");
    }

    @Then("prices changed successfully")
    public void pricesChangedSuccessfully() {
        int size = home.prices().size();
        for (int x = 0; x < 4; x++) {
            String price = home.prices().get(x).getText();
            System.out.println(x+1);
            System.out.println(price);
            Assert.assertTrue(price.contains("€"));
        }
    }
}
