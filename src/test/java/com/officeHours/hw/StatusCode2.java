package com.officeHours.hw;


import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class StatusCode2 {
    // StatusCode nin dinamik yazilmis hali

   private WebDriver driver;

    @BeforeMethod
    public void setup(){

        //Step 1
        driver = DriverFactory.createDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");


    }

    @DataProvider(name = "testData")
    public static Object[] testData() {
        return new Object[]{"404", "500", "301", "200"}; // bu kodlardan birini degistitrsen
                                                        // assert de yazdigin hata mesajini gorebilirsin
    }

    /*
         DataProvider returns data in form of single dimensional Object array (Object [])or 2 dimensional object array (Object [] [])
         Object [] --> When you have only 1 parameter
         Object [] [] --> When you have 2+ parameters
         cannot carry primitive data (int, byte) but it can carry
        wrapper class objects(Integer, Byte)

         statusCode("404")--> run,
         statusCode("500")--> run,
      */
    @Test(dataProvider = "testData") // buraya @DataProvider(name = "testData") de yazilmis ismin aynisini vermelisin
    public void statusCodes(String code) {
        //500, 404 should be the parameters

        //Step 2
        WebElement statusCodeLink = driver.findElement(By.linkText("Status Codes"));
        statusCodeLink.click();
        //Step 3
        WebElement statusCode = driver.findElement(By.linkText(code));
        statusCode.click();
        String expectedMessage = "This page returned a " + code + " status code";
        // //p ile bulduruyoruz mesaji
        WebElement displayedMessageElement = driver.findElement(By.xpath("//p"));
        String actualMessage = displayedMessageElement.getText();

//        if (actualMessage.contains(expectedMessage)) {
//            System.out.println("Passed");
//        } else {
//            System.out.println("FAILED");
//        }


        // this is better way for comparison(karsilastirma)
         /*
            The following is a HARD assertion and contains a message that is displayed only if the assertion fails.
            When a HARD assertion fails the rest of the script is skipped
        */

        Assert.assertTrue(actualMessage.contains(expectedMessage), "The status code does not exist");

    }

    @AfterMethod
    public void tearDown(){
        driver.close();

    }
}
