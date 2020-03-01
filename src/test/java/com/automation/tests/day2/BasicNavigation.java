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
        driver.manage().window().maximize();// to maximize browser
      //  driver.manage().window().fullscreen();
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

        // go to another website within the same window
        driver.navigate().to("http://amazon.com");

        if (driver.getTitle().toLowerCase().contains("amazon")){
            System.out.println("Test Passed!");
        }else {
            System.out.println("Test Failed");
        }

        // comeback to google
        driver.navigate().back();

        // checking if page title is equal to Google
        // .getTitle() - returns page title
        verifyEquals(driver.getTitle(), "Google");
        // move forward in the browser history
        driver.navigate().forward();
        System.out.println("Title : " + driver.getTitle());
        // driver.getTitle() - returns page title of the the page that is currently opened

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

    /**
     * Check if to strings are same. If print TEST PASSED! message.
     * Otherwise, print TEST FAILED message
     * @param arg1
     * @param arg2
     */

    public static void verifyEquals(String arg1, String arg2){

        if (arg1.equals(arg2)){
            System.out.println("Test Passed!");
        }else {
            System.out.println("Test Failed");
        }
    }
}
