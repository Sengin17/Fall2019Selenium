package com.automation.tests.day13;

import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;
public class DriverTest {
    @Test
    public void googleTest(){
        //Driver.getDriver() ---> returns driver
        Driver.getDriver().get("http://google.com");
        Assert.assertEquals(Driver.getDriver().getTitle(), "Google");
        Driver.closeDriver();
    }
    //Sometimes i was getting an error in the code.
    // So I checked  the Maven file. When I ran the test, I got this error.
    // How can I fix it?
}