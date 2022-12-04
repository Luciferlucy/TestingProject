package org.example.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.example.stepdef.hooks.driver;

public class registerpage {
    public WebElement register(){
        return driver.findElement(By.className("ico-register"));
    }
    public WebElement gender(){
        return  driver.findElement(By.id("gender-male"));
    }
    public WebElement firstname(){
        return  driver.findElement(By.id("FirstName"));
    }
    public WebElement lastname(){
        return  driver.findElement(By.id("LastName"));
    }
    public WebElement daylist(){
        return  driver.findElement(By.name("DateOfBirthDay"));
    }
    public WebElement monthlist(){
        return driver.findElement(By.name("DateOfBirthMonth"));
    }
    public  WebElement yearlist(){
        return driver.findElement(By.name("DateOfBirthYear"));
    }
    public WebElement email(){
        return driver.findElement(By.id("Email"));
    }
    public WebElement password(){
        return driver.findElement(By.id("Password"));
    }
    public  WebElement confpassword(){
        return driver.findElement(By.id("ConfirmPassword"));
    }
    public WebElement buttonreg(){
        return driver.findElement(By.id("register-button"));
    }
    public WebElement successMsg(){
       return driver.findElement(By.className("result"));
    }
    public WebElement Continue(){
        return driver.findElement(By.className("register-continue-button"));
    }
}
