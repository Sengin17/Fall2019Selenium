package com.automation.tests.vytrack.activities;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DenemeCalls {

    private WebDriver driver;
    private Actions actions;
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private String storeManagerUserName = "storemanager85";
    private String storeManagerPassword = "UserUser123";
    private By activitiesBy = By.xpath("//span[@class='title title-level-1'  and contains(text(), 'Activities')]");
    private By logCallBtnBy = By.xpath("//a[@title='Log call']");

    /*
Scenario: Verify for store manager
Login as story manager
Go to Activities --> Calls
Verify that Log Call button is displayed
Go to Activities --> Calendar Events
Verify that Create Calendar Event button is displayed
Read only
 */
    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("chrome");
        driver.get("https://qa2.vytrack.com/user/login");
        driver.manage().window().maximize();
        actions = new Actions(driver);
        driver.findElement(usernameBy).sendKeys(storeManagerUserName);
        driver.findElement(passwordBy).sendKeys(storeManagerPassword, Keys.ENTER);
        BrowserUtils.wait(3);
        actions.moveToElement(driver.findElement(activitiesBy)).perform();
        driver.findElement(By.linkText("Calls")).click();
        BrowserUtils.wait(3);
    }

    @Test
    public void verifyLogCallTest() {
        WebElement logCallBtnElement = driver.findElement(logCallBtnBy);
       Assert.assertTrue(logCallBtnElement.isDisplayed());


    }
        @AfterMethod
        public void teardown () {
            BrowserUtils.wait(2);
            driver.quit();
        }

    }
