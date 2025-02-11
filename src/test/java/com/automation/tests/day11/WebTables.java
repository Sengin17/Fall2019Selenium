package com.automation.tests.day11;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
public class WebTables {

    private WebDriver driver;

    // seda's note
    //*[@id="table1"]//tbody//td  ==>> gives all cells
    // but if you specify row   ==>> //*[@id="table1"]//tbody//tr[3]//td  : it goes that exact data
    @BeforeMethod
    public void setup() {

        // Seda's note
        //it is twice faster because browser does need to render website to get html code

        WebDriverManager.chromedriver().version("79").setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        //headless mode makes execution twice faster
        //it does everything except file uploading
        //set it to tru to make it work
        chromeOptions.setHeadless(false);//to run browser without GUI. Makes browser invisible.
        driver = new ChromeDriver(chromeOptions);
        driver.get("http://practice.cybertekschool.com/tables");
        driver.manage().window().maximize();
    }

    @Test
    public void getColumnNames() {
        //th - represents table header cells
        List<String> expected = Arrays.asList("Last Name", "First Name", "Email", "Due", "Web Site", "Action");
        List<WebElement> columnNames = driver.findElements(By.xpath("//table[1]//th"));

        // just to print
        for (WebElement columnName : columnNames) {
            System.out.println(columnName.getText());
            BrowserUtils.wait(3);
        }
        // BrowserUtils.getTextFromWebElements(columnNames) ==>
        // this method takes the text of every single webElement and puts it into collection of strings
        Assert.assertEquals(BrowserUtils.getTextFromWebElements(columnNames), expected);
    }

    @Test
    public void verifyRowCount() {
        //  //tbody//tr - to get all rows from table body, excluding table header
        List<WebElement> rows = driver.findElements(By.xpath("//table[1]//tbody//tr"));
        //if we will get a size of this collection, it automatically equals to number of elements
        // expected - 4 rows in the table
        Assert.assertEquals(rows.size(), 4);
        //expected result => 4 => number of rows
        //actual result => size of the collection(rows.size())
    }

    /**
     * To get specific column, skip row index, and just provide td index
     */
    @Test
    public void getSpecificColumn() {

        // td[5] - column with links
        List<WebElement> links = driver.findElements(By.xpath("//table[1]//tbody//tr//td[5]"));
        System.out.println(BrowserUtils.getTextFromWebElements(links));

        //once you find email cell in the first table that has this email (jdoe@hotmail.com) then go to following sibling has linkText delete :
        ////td[text()='jdoe@hotmail.com']//following-sibling::td/a[text()='delete']

        // email delete button //table[1]//td[text()='jdoe@hotmail.com']//following-sibling::td/a[text()='delete']

        //first way :
        //once you find email cell in the first table that has this email (jdoe@hotmail.com) then go to following sibling has linkText delete :
        //td element with email and td element that contains delete => are siblings
        // //td[text()='jdoe@hotmail.com']//following-sibling::td/a[text()='delete']
        //to make it easier :
        //go back to parent and find link that has text delete
        //td is child of tr
        // //td[text()='fbach@yahoo.com']/..//a[text()='delete']
        //even more simple way :
        //it is more hardcoded! but easiest => you provide index so it s not flexible, if index is change ilocator will never find it
        //go to find email in the first table go to parent go to second link inside this element
        // //table[1]//td[text()='jsmith@gmail.com']/..//a[2]

    }

    /**
     * TASK until 4:45
     * Go to tables example page
     * Delete record with jsmith@gmail.com email
     * verify that number of rows is equals to 3
     * verify that jsmith@gmail.com doesn't exists any more in the table
     */

    @Test
    public void deleteRowTest() {
        String xpath = "//table[1]//td[text()='jsmith@gmail.com']/..//a[text()='delete']";
        driver.findElement(By.xpath(xpath)).click();

        BrowserUtils.wait(3);

        //get count of rows
        int rowCount = driver.findElements(By.xpath("//table[1]//tbody//tr")).size();

        Assert.assertEquals(rowCount, 3);
        // Assert.assertTrue(driver.findElements(By.xpath("//table[1]//td[text()='jsmith@gmail.com']")).isEmpty());
        //more organize
        List<WebElement> emails = driver.findElements(By.xpath("//table[1]//td[text()='jsmith@gmail.com']"));
        Assert.assertTrue(emails.isEmpty());


    }

    /**
     * Let's write a function that will return column index based on column name
     */
    @Test
    public void getColumnIndexByName() {

        String columnName = "Email";

        List<WebElement> columnNames = driver.findElements(By.xpath("//table[1]//th"));

        int index = 0;
        for (int i = 0; i < columnNames.size(); i++) {

            String actualColumnName = columnNames.get(i).getText();
            // ilk %s -> actualColumnName'e
            // ikinci %s -> i ye karsilik gelir
            //  bu "Column name: %s, position %s" bir yazma tejknigi --> printf
            System.out.println(String.format("Column name: %s, position %s", actualColumnName, i));

            if (actualColumnName.equals(columnName)) {
                index = i + 1;
                break;
            }
        }

        Assert.assertEquals(index, 3);
    }

    @Test
    public void getSpecificCell() {

        String expected = "http://www.jdoe.com";

        int row = 3;
        int column = 5;
        String xpath = "//table[1]//tbody//tr["+ row + "]//td[" + column + "]";

        WebElement cell = driver.findElement(By.xpath(xpath));

        Assert.assertEquals(cell.getText(), expected);
    }

    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(3);
        driver.quit();

    }
}
