package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploading {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get(" http://practice.cybertekschool.com/upload");
        BrowserUtils.wait(4);

        WebElement upload = driver.findElement(By.id("file-upload"));

        //https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html
        //I am gonna upload pom.xml file
        String filePath = System.getProperty("user.dir")+"/pom.xml";
        // kendi bilgisayarindan upload etmek icin path i vermelisin
        

        upload.sendKeys(filePath);

        driver.findElement(By.id("file-submit")).click();

        BrowserUtils.wait(5);
        driver.quit();
    }
}
