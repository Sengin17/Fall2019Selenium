package com.officeHours;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.logging.SocketHandler;

public class FramePractice {
    private WebDriver driver;


    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/nested_frames");
    }
    @Test
    public void frameTest() {

        // we landed to red webdocument - default content
        driver.switchTo().frame("frame-top");//parent frame
        //  driver.switchTo().frame("frame-middle");//child frame

        // we are landed to blue web-doc
        ArrayList<WebElement> frameList = (ArrayList<WebElement>) driver.findElements(By.xpath("//frame"));

        /*
        we have stored all frames webelements inside the list
        1. Loop through list
        2. switch to each frame
            a. get test from body
            b. switch to parent
         */
//        for (WebElement each : frameList){
//            driver.navigate().refresh();
//            BrowserUtils.wait(1);
//            driver.switchTo().frame(each);
//            String bodyText = driver.findElement(By.tagName("body")).getText();
//            System.out.println("Body text: " + bodyText);
//            driver.switchTo().parentFrame();
//        }


        for (int i = 0; i<frameList.size(); i++){
            driver.switchTo().frame(i);
            String bodyText = driver.findElement(By.xpath("//body")).getText();
            System.out.println("Body text: " + bodyText);
            driver.switchTo().parentFrame();
        }

        driver.switchTo().defaultContent(); //will always take you to the main html - default (red in the schema)
        driver.switchTo().frame("frame-bottom"); // switched to bottom frame
        String bodyText = driver.findElement(By.xpath("//body")).getText();
        System.out.println("Body text: " + bodyText);
        driver.switchTo().defaultContent(); //switch back to default after you finished your iteraction with frame content

    }
    @AfterMethod
    public void close(){
        BrowserUtils.wait(3);
        driver.quit();
    }
}
