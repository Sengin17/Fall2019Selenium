package com.officeHours.hw;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase6 {
    private WebDriver driver;
    private String URLTempEmail = "https://www.tempmailaddress.com";
    private String URLCyberTek = "https://practice-cybertekschool.herokuapp.com";
    private By registration_formBy = By.linkText("Registration Form");
    private By fullNameBy = By.xpath("//input[@type='text']");
    private By emailBy = By.xpath("//input[@type='email']");
    private By signUpBy = By.xpath("//button[@type='submit']");
    private By signUpMessageBy = By.xpath("//h3[@name='signup_message']");
    private By senderEmailBy = By.xpath("//*[@id=\"schranka\"]/tr[1]/td[1]/span");
    //    private By senderEmailBy = By.xpath("(//tbody/tr/td/span[@class='glyphicon glyphicon-envelope'])[1]");
    @Test
    public void TestCase6() {
        String email = driver.findElement(By.id("email")).getText();
        BrowserUtils.wait(3);
        driver.navigate().to(URLCyberTek);
        BrowserUtils.wait(3);
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        BrowserUtils.wait(1);
        driver.findElement(fullNameBy).sendKeys("John Smith");
        BrowserUtils.wait(1);
        driver.findElement(emailBy).sendKeys(email);
        BrowserUtils.wait(1);
        driver.findElement(signUpBy).click();
        BrowserUtils.wait(3);
        String expected = "Thank you for signing up. Click the button below to return to the home page.";
        String actual = driver.findElement(signUpMessageBy).getText();
        BrowserUtils.wait(1);
        Assert.assertEquals(actual, expected);
        driver.navigate().to(URLTempEmail);
        BrowserUtils.wait(1);
        String expectedEmail = "do-not-reply@practice.cybertekschool.com";
        String actualEmail = driver.findElement(senderEmailBy).getText();
        Assert.assertEquals(actualEmail, expectedEmail);
    }
    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URLTempEmail);
        driver.manage().window().maximize();
        BrowserUtils.wait(2);
    }
    @AfterMethod
    public void teardown() {
        // if webDriver object is alive
        if (driver != null) {
            // close the browser, close session
            driver.quit();
            // destroy webDriver object for sure
            driver = null;
        }
    }}