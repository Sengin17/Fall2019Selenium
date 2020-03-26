package com.officeHours.hw;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class JavaScriptExecutorPractice {
    // JavaScriptExecutor is an INTERFACE for the Driver
    /*
    * 1. SendKeys
    *   document.getElementById('element id').value='Send these characters'
    *JavaScriptExecutor
    Add-on to Selenium
    We use when the selenium doesn't react well with the web page
    Alternative way to interact with the browser
  JavaScriptExecutor is an INTERFACE for the Driver
  1. SendKeys
      document.getElementById('element id').value='Send these characters'
        document.getElementByName('element id').value='Send these characters'
  2. click a button click()
       document.getElementById('element id').click();
  3. Get the title of the page
      document.title
  4. Get the URL of the page
     document.URL
  5. getText()
     document.getElementById('element id').innerHTML;
  6. Scroll down & scroll to view an element (Scroll into view of an element)
     (Scroll Down) window.scrollBy(0,500)
      (Scroll an element into view) document.getElementById('element id').scrollIntoView();
    *
    *
    * */
    @Test(description = "Send text to search box on etsy")
    public void testcase1(){
        //Driver instance created
        WebDriver driver = DriverFactory.createDriver("chrome");
        //Navigating to etsy homepage
        driver.get("https://www.etsy.com/");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("document.getElementById('global-enhancements-search-query').value='Send these characters'");
    }
    @Test(description = "send text to search box")
    public void test1(){
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("https://www.etsy.com/");
        BrowserUtils.wait(4);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('global-enhancements-search-query').value='my favorite book'");
        BrowserUtils.wait(3);
        driver.quit();
    }
    @Test(description = "get the page title")
    public void test2(){
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("https://www.etsy.com/");
        BrowserUtils.wait(4);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String pageTitle = js.executeScript("return document.title").toString();
        System.out.println("pageTitle = " + pageTitle);
    }
    @Test(description = "get the page title (return a value)")
    public void testcase3(){
        WebDriver driver = DriverFactory.createDriver("chrome");
        //Navigating to etsy homepage
        driver.get("https://www.etsy.com/");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        //return keyword before the script is for Selenium to know that it needs to bring back information
        String pageTitle = js.executeScript("return document.title").toString();
        System.out.println(pageTitle);
    }


}

