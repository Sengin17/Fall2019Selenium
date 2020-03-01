package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BasicNavigation {
    public static void main(String[] args) throws Exception {

        // to start selenium script we need:
        // setup web driver (browser driver) and create web driver object

        WebDriverManager.chromedriver().setup();
        // RemoteWebDriver dan diger tum driver lari olusturabilirsin fakat;
        //ChromeDriver driver = new SafariDriver(); olusturamazin
        //RemoteWebDriver driver = new SafariDriver();
        WebDriver driver = new ChromeDriver();
        //in selenium, everything starts from WebDriver interface

        driver.get("http://google.com"); // to open a website
        Thread.sleep(3000);
        driver.close();
    }
}
