package org.example.stepdef;
import static org.example.stepdef.hooks.driver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.page.homepage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D04_searchStepDef {
    homepage home = new homepage();
    static String search;
    @When("user enter product {string}")
    public void step2(String arg0){
        search= arg0;
        home.searchField().sendKeys(search);
    }
    @And("user press on search button")
    public void userPressOnSearchButton() {
        home.searchButton().click();
    }

    @Then("results must be shown")
    public void resultsMustBeShown() {
        SoftAssert soft = new SoftAssert();
        String actualUrl = driver.getCurrentUrl();
        soft.assertEquals(actualUrl,"https://demo.nopcommerce.com/search?q="+search);
        int size = home.AddCard().size();
        System.out.println("Size= "+ size);
        for (int x = 0; x < size; x++) {
            String ProductName = home.productname().get(x).getText();
            System.out.println(x+1);
            System.out.println(ProductName.toLowerCase());
        }
        soft.assertAll();
    }

    @And("user press on the product")
    public void userPressOnTheProduct() {
        home.product().click();
    }

    @Then("sku of the product must be same like on search")
    public void skuOfTheProductMustBeSameLikeOnSearch() {
        String actualMsg = home.sku().getText();
        Assert.assertEquals(actualMsg,search);

    }
}
