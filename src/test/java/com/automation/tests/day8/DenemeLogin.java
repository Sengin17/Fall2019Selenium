package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DenemeLogin {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
    }
    @Test
    public void loginTest(){
       driver.findElement(By.linkText("Form Authentication")).click();
       driver.findElement(By.xpath("//label[text()='Username']/following-sibling::input")).sendKeys("tomsmith");
       driver.findElement(By.xpath("//input[@name='password']")).sendKeys("SuperSecretPassword", Keys.ENTER);

        BrowserUtils.wait(3);

    }


    @AfterMethod
    public void close(){
        BrowserUtils.wait(3);
        driver.quit();
    }
}
