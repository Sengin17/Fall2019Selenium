package com.automation.tests.day7;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Deneme2 {


    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/login");
        BrowserUtils.wait(3);
       // driver.findElement(By.cssSelector("[type='text']")).sendKeys("tomsmith");
        driver.findElement(By.cssSelector("[name=username]")).sendKeys("tomsmith");

        // ikisi ile de bulabilirsin
       // driver.findElement(By.cssSelector("[name='password']")).sendKeys("SuperSecretPassword");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("SuperSecretPassword");
        driver.findElement(By.cssSelector("#wooden_spoon")).click();

        BrowserUtils.wait(3);
        driver.quit();


    }

}
