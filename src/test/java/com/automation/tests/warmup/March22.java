package com.automation.tests.warmup;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class March22 {
    /*
    Warm-up task for 15 minutes:
    Go to http://practice.cybertekschool.com/tables
    Click on "Last name" column name
    Verify that table is sorted by last name in alphabetic order.

     */
   private WebDriver driver;

    @BeforeMethod
    public void setup(){
        // ilk driver setup yapilir
        driver = DriverFactory.createDriver("chrome");
        // sonra sayfaya gidilit
        driver.get("http://practice.cybertekschool.com/tables");
        driver.manage().window().maximize();
    }
    @Test
    public void verifyLastnameSort(){
        // iki yollada bulabilirsin --> //table[1]//*[text()='Last Name'] or //*[text()='Last Name']
        // click on column name
        driver.findElement(By.xpath("//table[1]//*[text()='Last Name']")).click();
         BrowserUtils.wait(2);
        // collect all values from the first column
        List<WebElement> column = driver.findElements(By.xpath("//table[1]//tbody//td[1]"));
        for (int i = 0; i < column.size()-1; i++) {
            /// take a string
            String value = column.get(i).getText();
            // take a following string
            String nextValue = column.get(i+1).getText();

            System.out.println(value.compareTo(nextValue));

            Assert.assertTrue(value.compareTo(nextValue) <= 0);
        }

    }
    @AfterMethod
    public void close(){
        BrowserUtils.wait(3);
        driver.quit();
    }
}
