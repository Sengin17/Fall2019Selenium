package com.automation.tests.day7;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Deneme3 {

    // cift slash ile basliyorsa xpath dir.

    // xpath -> //label[text()='Username']//following-sibling::input
    // xpath in simple hali -> //input[@name='username']
    // contains kullanarak yapilan -> //label[contains(text(),'Username')]//following-sibling::input
    // username labele gide --> //input[@name='username']/preceding-sibling::label
    public static String userNameLocator = "//label[text()='Username']//following-sibling::input";
    public static String passwordLocator = "//label[text()='Password']/following-sibling::input";
    // //label[contains(text(),'Password')]/following-sibling::input

    public static String loginBtnLocator = "//button[contains(text(),'Login')]";
    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/login");
        driver.findElement(By.xpath(userNameLocator)).sendKeys("tomsmith");
        driver.findElement(By.xpath(passwordLocator)).sendKeys("SuperSecretPassword");
        driver.findElement(By.xpath(loginBtnLocator)).click();
        BrowserUtils.wait(3);
        driver.quit();
    }
}
