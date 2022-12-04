package org.example.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.example.stepdef.hooks.driver;

public class P02_login {
    public WebElement login() {
        return driver.findElement(By.className("ico-login"));
    }

    public WebElement Email() {
        return driver.findElement(By.className("email"));
    }

    public WebElement password() {
        return driver.findElement(By.className("password"));
    }

    public WebElement loginButton() {
        return driver.findElement(By.className("login-button"));
    }
    public  WebElement Myaccount(){
        return driver.findElement(By.cssSelector("a[class=\"ico-account\"]"));
    }
    public WebElement WrongMsg(){
        return driver.findElement(By.cssSelector("div[class=\"message-error validation-summary-errors\"]"));
    }


}
