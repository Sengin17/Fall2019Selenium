package com.officeHours;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;

public class OfficeHour_03_17_2020 {

    public static void main(String[] args) {


        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://qa3.vytrack.com");

        WebElement username = driver.findElement(By.id("prependedInput"));
        username.sendKeys("salesmanager110");
        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");
        password.submit();
        BrowserUtils.wait(3);

        // //a[@href='/contact'] 5 tane element oldugu gorunue contact a gitmek icin --> (//a[@href='/contact'])[4] contag a gider index ile
//        WebElement contacts_link = driver.findElement(By.xpath("//span[.='Contacts']/following-sibling::a"));
//        contacts_link.click();
        //click on contacts
        //create contact
        //Use map to store information and use it later to enter in UI
        // //tag[@attribute = 'value']
        WebElement contacts_link = driver.findElement(By.xpath("//span[.='Contacts']/following-sibling::a"));
        BrowserUtils.wait(3);
        contacts_link.click();
        BrowserUtils.wait(3);


        WebElement create_contact = driver.findElement(By.linkText("Create Contact"));
        create_contact.click();
        BrowserUtils.wait(3);
        String currentTitle = driver.getTitle();
        if (currentTitle.equalsIgnoreCase("Create Contact - Contacts - Customers")){
            System.out.println("Title is expected");
        }else {
            System.out.println("Title is NOT expected");
        }
        HashMap <String, String> contact1 = new HashMap<>();
        contact1.put("First Name", "John");
        contact1.put("Last Name", "Smith");
        contact1.put("Phone", "571-236-4545");
        contact1.put("Street", "400 Main Street");
        contact1.put("City", "Tysons");
        contact1.put("State", "VA");
        contact1.put("Zip Code", "22102");
        contact1.put("Sales Group", "true");
        contact1.put("Country", "United States");
        System.out.println("Contact 1: " + contact1);



        BrowserUtils.wait(10);
        driver.quit();
    }
}
