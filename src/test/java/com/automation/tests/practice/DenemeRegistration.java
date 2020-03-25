package com.automation.tests.practice;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DenemeRegistration {

   private WebDriver driver;
   private String URL = "http://practice.cybertekschool.com/registration_form";
   private By firstnameBy = By.cssSelector("[name='firstname']");
   private By lastnameBy = By.xpath("//input[@name='lastname']");
   private By usernameBy = By.xpath("//input[@name='username']");
   private By emailBy = By.name("email");
   private By passwordBy = By.xpath("//input[@class='form-control'] [@name='password']");
  // private By passwordBy2 = By.xpath("//input[@type='password']");
   private By telBy = By.xpath("//input[@type='tel']");
   private By maleBy = By.xpath("//input[@value='male']");
   private By femaleBy = By.cssSelector("[value='female']");
   private By otherBy = By.cssSelector("[value='other']");
   private By birthdayBy = By.name("birthday");
   private By departmanBy = By.cssSelector("[name='department']");
   private By jobTitleBy = By.cssSelector("[name='job_title']");
   private By cplusPlusBy = By.cssSelector("[value='cplusplus']:nth-child(1)");
   private By javaBy = By.id("inlineCheckbox2");
   private By javaScriptBy = By.cssSelector("[value='javascript']");
   private By signUpBtn = By.id("wooden_spoon");

@Test
public void testForm(){

   driver.findElement(firstnameBy).sendKeys("Mehtap");
   driver.findElement(lastnameBy).sendKeys("Erguven");
   driver.findElement(usernameBy).sendKeys("merguven");
   driver.findElement(emailBy).sendKeys("mehtap@gmail.com");
   driver.findElement(telBy).sendKeys("212-323-4545");
   driver.findElement(femaleBy).click();
   driver.findElement(birthdayBy).sendKeys("01/01/2000");

   // secenekli oldugu icin bir secme islemi yapmamiz gerekiyor bu yuzden Select sinifini kullanmaliyiz
   Select department = new Select(driver.findElement(departmanBy));
   department.selectByVisibleText("Department of Engineering");

   Select jobTitle = new Select(driver.findElement(jobTitleBy));
   jobTitle.selectByVisibleText("SDET");

   driver.findElement(javaBy).click();
   driver.findElement(signUpBtn).click();

   String expected = "You've successfully completed registration!";
   String actual = driver.findElement(By.tagName("p")).getText();

   Assert.assertEquals(expected,actual, "expected is not equal to actual");



}

   @BeforeMethod
    public void setup(){
       WebDriverManager.chromedriver().version("79").setup();
       driver.get(URL);//input[@value='male']
       BrowserUtils.wait(3);
   }

   @AfterMethod
    public void close(){
       BrowserUtils.wait(3);
       driver.quit();
   }
}
