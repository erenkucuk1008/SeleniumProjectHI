package com.cybertek.tests.day6_dropdown_review_javafaker;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Dropdown_Tasks {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");

        //2. Go to http://practice.cybertekschool.com/dropdown
        driver.get("http://practice.cybertekschool.com/dropdown");

        //maximize
        driver.manage().window().maximize();

        //implicit
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void test2_verify_state_dropdown() throws InterruptedException {
        //3. Select Illinois
        //Thread.sleep(1000);
        WebElement stateSelection = driver.findElement(By.xpath("//select[@id='state']"));
        Select selectState = new Select(stateSelection);
        selectState.selectByVisibleText("Illinois");

        //4. Select Virginia
        //Thread.sleep(1000);
        selectState.selectByValue("VA");

        //5. Select California
        //Thread.sleep(1000);
        selectState.selectByVisibleText("California");

        //Verify final selected option is California
        String expectedState = "California";
        String actualState = selectState.getFirstSelectedOption().getText();

        Assert.assertEquals(actualState,expectedState);
    }

    @Test
    public void test3_date_dropdown_verification() throws InterruptedException {

        Select yearDropdown = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select dayDropdown = new Select(driver.findElement(By.xpath("//select[@id='day']")));

        //Select "December 1, 1922" and verify it is selected.
        //Select year using : visible text
        //Thread.sleep(1000);
        yearDropdown.selectByVisibleText("1925");
        // Select month using : value attribute
        //Thread.sleep(1000);
        monthDropdown.selectByValue("11");
        // Select day using : index number
        //Thread.sleep(1000);
        dayDropdown.selectByIndex(0);

        String expectedYear = "1925";
        String expectedMonth = "December";
        String expectedDay = "1";

        String actualYear = yearDropdown.getFirstSelectedOption().getText();
        String actualMonth = monthDropdown.getFirstSelectedOption().getText();
        String actualDay = dayDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualYear,expectedYear);
        Assert.assertEquals(actualMonth,expectedMonth);
        Assert.assertEquals(actualDay,expectedDay);
    }

    @Test
    public void test4_multiple_select_dropdown() throws InterruptedException {

        //Locating dropdown to work on it
        Select multipleSelect = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));

        //3. Select all the options from multiple select dropdown.
        List<WebElement> allOptions = multipleSelect.getOptions();

        //4. Print out all selected values.
        //iter + press enter
        for (WebElement each : allOptions) {
            //Thread.sleep(500);
            each.click();

            System.out.println("Selected: "+each.getText());

            //Verifying each option is selected
            Assert.assertTrue(each.isSelected(),"The option "+each.getText()+" is not selected");
        }

        //5. Deselect all values.
        multipleSelect.deselectAll();

        for (WebElement each : allOptions) {
            Assert.assertFalse(each.isSelected());
            //Assert.assertTrue(!each.isSelected());
        }
    }

    @Test
    public void test5_non_select_dropdown() throws InterruptedException {

        //We need to locate the non-select dropdown as regular web element
        WebElement dropdownLink = driver.findElement(By.xpath("//a[@id='dropdownMenuLink']"));

        //3. Click non select dropdown
        dropdownLink.click();
        //Thread.sleep(2000);

        //4. Select Facebook from dropdown
        WebElement selectFacebook = driver.findElement(By.xpath("//a[.='Facebook']"));
        selectFacebook.click();
        //Thread.sleep(2000);

        //5. Verify title is "Facebook - Log In or Sign Up"
        String expectedTitle = "Facebook - log in or sign up";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);

    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {

        //additional 5 seconds before closing the browser
        Thread.sleep(5000);
        driver.close();
    }
}
