package org.example.stepdef;

import static org.example.stepdef.hooks.driver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.page.homepage;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class D05_hoverCategoriesStepDef {
    homepage home = new homepage();
    static String title;
    @When("user hover the main categorises")
    public void step1() throws InterruptedException {
        Actions actions=new Actions(driver);
        List <WebElement> mainLinks = home.categories();
        int count = mainLinks.size();
        System.out.println("count is "+count);
        int min = 0;
        int max = count-1;
        int selectedCategory = (int)Math.floor(Math.random()*(max-min+1)+min);
        actions.moveToElement(mainLinks.get(selectedCategory)).perform();
        String selectedCategoryText = mainLinks.get(selectedCategory).getText();
        System.out.println("to know which category is selected:   " +selectedCategoryText);
        Thread.sleep(2000);
        selectedCategory = selectedCategory+1;
        List<WebElement> subCategoryLinks = home.locator(selectedCategory);


        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        String selectedSubCategoryText;
        if(!subCategoryLinks.isEmpty()) {
            int subCategoryCount = subCategoryLinks.size();
            int mi = 0;
            int ma = subCategoryCount -1;
            System.out.println("profile links " + subCategoryCount);
            System.out.println(subCategoryLinks.get(0).getText());
            System.out.println(subCategoryLinks.get(1).getText());
            System.out.println(subCategoryLinks.get(2).getText());
            int selectedSubCategory =(int)Math.floor(Math.random()*(ma-mi+1)+mi);
            selectedSubCategoryText = subCategoryLinks.get(selectedSubCategory).getText();
            actions.moveToElement(subCategoryLinks.get(selectedSubCategory)).perform();
            title = selectedSubCategoryText;
        }else{
            title = selectedCategoryText;
        }
        actions.click().build().perform();
        // reset it to the initial value
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @Then("the subcategory title is equal to the random selected subcategory")
    public void theSubcategoryTitleIsEqualToTheRandomSelectedSubcategory() {
        SoftAssert soft = new SoftAssert();
        boolean page = home.title().isDisplayed();
        soft.assertTrue(page);
        String actualTitle = home.title().getText().toLowerCase().trim();
        soft.assertEquals(actualTitle,title.toLowerCase().trim());
        soft.assertAll();
    }
}
