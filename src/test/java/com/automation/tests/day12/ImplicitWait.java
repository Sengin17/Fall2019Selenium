package com.automation.tests.day12;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class ImplicitWait {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        // ilk driver ayarlari yapilir
        driver = DriverFactory.createDriver("chrome");
        // sonra sayfaya gidilir
        driver.get("http://practice.cybertekschool.com/dynamic_loading/2");
        driver.manage().window().maximize();
        // this is how we apply implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void waitTest(){

        driver.findElement(By.tagName("button")).click();

        WebElement finishElement = driver.findElement(By.id("finish"));

        System.out.println(finishElement.getText());
    }
    @AfterMethod
    public void close(){

        driver.quit();
    }

}
