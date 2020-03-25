package com.officeHours;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

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


        WebElement first_name = driver.findElement(By.xpath("(//input[@data-name='field__first-name'])[1]"));
        WebElement last_name = driver.findElement(By.xpath("(//input[@data-name='field__last-name'])[1]"));
        WebElement phone = driver.findElement(By.name("oro_contact_form[phones][0][phone]"));
        WebElement street = driver.findElement(By.name("oro_contact_form[addresses][0][street]"));
        WebElement city = driver.findElement(By.name("oro_contact_form[addresses][0][city]"));
        WebElement state = driver.findElement(By.xpath("//input[@data-name='field__region-text']"));
        WebElement zipCode = driver.findElement(By.name("oro_contact_form[addresses][0][postalCode]"));
        WebElement salesGroup = driver.findElement(By.xpath("(//input[@data-name='field__1'])[2]"));

        first_name.sendKeys(contact1.get("First Name"));
        last_name.sendKeys(contact1.get("Last Name"));
        phone.sendKeys(contact1.get("Phone"));
        street.sendKeys(contact1.get("Street"));
        city.sendKeys(contact1.get("City"));
        state.sendKeys(contact1.get("State"));
        zipCode.sendKeys(contact1.get("Zip Code"));


        WebElement country = driver.findElement(By.name("oro_contact_form[addresses][0][country]"));
        Select country_dropdwn = new Select(country); // this is special
        // css code den bakip bu sekilde de yazabilirsin istedigin ulkeyi
        //country_dropdwn.deselectByValue("US");
        /*
        it has different methods that help us interact with dropdown
         */
        country_dropdwn.deselectByVisibleText(contact1.get("Country"));

        if (contact1.get("Sales Group").equalsIgnoreCase("true"))
        {
            salesGroup.click();
        }
        BrowserUtils.wait(10);
        driver.quit();


    }
}
