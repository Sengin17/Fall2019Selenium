package com.automation.tests.vytrack.fleet;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class DenemeFleet {

    private WebDriver driver;
    private String URL = "https://qa2.vytrack.com/user/login";
    private String username = "storemanager85";
    private String password = "UserUser123";
    // bu islemleri her defasinda locater lari bulmamaak icin yapiyoruz.
    // user name i css de  aramak icin [name='_username']
    private By usernameBy = By.name("_username");
    private By passwordBy  = By.cssSelector("#prependedInput2");
    private By loginBy = By.xpath("//button[text()='Log in']");
    private By fleetBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Fleet')]");
    //button[text()='Log in']

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();


    }

    @Test
    public void vytractTest(){
        //login
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(loginBy).click();
        BrowserUtils.wait(3);

//        List<WebElement> classUnits = driver.findElements(By.className("//span[@class='title title-level-1']"));
//        for (WebElement each : classUnits) {
//            String title = each.getText();
//            System.out.println(title);
//        }
//        System.out.println(".>>>> " + classUnits.get(1).getText() );

        Actions actions = new Actions(driver);
        BrowserUtils.wait(3);
        actions.moveToElement(driver.findElement(fleetBy)).perform();

        BrowserUtils.wait(5);

    }
    @AfterMethod
    public void teardown() {

        BrowserUtils.wait(3);
        driver.quit();

    }

}
