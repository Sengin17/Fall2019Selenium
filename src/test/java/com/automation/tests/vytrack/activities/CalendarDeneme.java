package com.automation.tests.vytrack.activities;


import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalendarDeneme {

    private WebDriver driver;
    private Actions actions;

    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.cssSelector("#prependedInput2");
    private By submitBtn = By.id("_submit");

    private String storeManagerUserName="storemanager85";
    private String storeManagerPassword="UserUser123";

    private By activitiesBy = By.xpath("(//span[@class='title title-level-1'])[5]");
   // private By calendarBy = By.xpath("//span[@class='title title-level-2' and contains(text(),'Calender Events')]");
   private By calendarBy = By.linkText("Calendar Events");
   private By createCalendarBtnBy = By.cssSelector("a[title='Create Calendar event']");




    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();

        driver.get("https://qa2.vytrack.com/user/login");
        //driver.manage().window().maximize();
        //BrowserUtils.wait(3);
        // driver da action objesini olusturup onu uzerinde durabilmak icin kullaniyoruz
        actions = new Actions(driver);

        driver.findElement(usernameBy).sendKeys(storeManagerUserName);
        driver.findElement(passwordBy).sendKeys(storeManagerPassword);
        driver.findElement(submitBtn).click();
        BrowserUtils.wait(3);
        // activities uzerine gelmis olduk
        actions.moveToElement(driver.findElement(activitiesBy)).perform();
        BrowserUtils.wait(3);
        driver.findElement(calendarBy).click();




    }
    // activities de ki butonun gorunur olup olmadigina bakmak icin
    @Test
    public void buttonVisibilityTest(){
     WebElement eventBtn =  driver.findElement(createCalendarBtnBy);
     //gorunur olup olmadiginini gormek icin  Assert.assertTrue ile bakariz
        Assert.assertTrue(eventBtn.isDisplayed());

    }
    @AfterMethod
    public void close(){
        BrowserUtils.wait(3);
      driver.quit();
    }

}
