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

        //in selenium, everything starts from WebDriver interface'
        //ChromeDriver extends RemoteWebDriver --> implements WebDriver
        driver.get("http://google.com"); // to open a website
        Thread.sleep(3000); // for demo, wait 3 seconds
        // method return page title
        // you can also see it as tab name, in the browser
        String title = driver.getTitle();//returns <title> Some Title </title> text
        String expectedTitle = "Google"; // we provide it

        System.out.println("Title is... " + title);

        if (expectedTitle.equals(title)){
            System.out.println("Test Passed!");
        }else {
            System.out.println("Test Failed");
        }

        // must be at the end
        driver.close(); // to close browser
        // browser cannot close itself

        //SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
        // bu problem varsa
        /* pom.xml e bu kodu eklemelisin
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>1.7.30</version>
        </dependency>
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-simple</artifactId>
            <version>1.7.30</version>
        </dependency>
         */
    }
}
