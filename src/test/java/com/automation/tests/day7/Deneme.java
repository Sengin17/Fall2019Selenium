package com.automation.tests.day7;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Deneme {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com");
        BrowserUtils.wait(3);
        driver.findElement(By.linkText("Multiple Buttons")).click();
        BrowserUtils.wait(3);
        // tek tirnak ile kullanilir
        driver.findElement(By.cssSelector("[onclick='button1()']")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.cssSelector("[name='button2']")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.name("button2")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.cssSelector("[id^='button_']")).click();
        BrowserUtils.wait(3);
       // xpath ile bulmak icin cift slash dan sonra tag kullanilir. buttonlar tag dir.
        // koseli parantezden sonra yani atribute lerin onune @ kullanilir
        driver.findElement(By.xpath("//button[@onclick='button5()']")).click();
        BrowserUtils.wait(3);
        // text ile buldurmak icin contains kullanilir
       driver.findElement(By.xpath("//button[contains(text(),\"Don't click!\")]")).click();
        BrowserUtils.wait(3);
        // id yerine # konur css icin claslarin yerine de nokta konur
        driver.findElement(By.cssSelector("#disappearing_button")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.cssSelector("[id='disappearing_button']")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.xpath("//button[@onclick='button4()']")).click();


        BrowserUtils.wait(3);
        driver.quit();

    }

}
