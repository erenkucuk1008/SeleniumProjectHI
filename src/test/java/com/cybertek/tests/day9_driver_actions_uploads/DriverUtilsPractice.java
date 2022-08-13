package com.cybertek.tests.day9_driver_actions_uploads;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DriverUtilsPractice {

    @Test
    public void simple_google_search_test(){

        //Go to google.com
/*
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
 */
        // Driver.getDriver() = driver
        Driver.getDriver().get("https://www.google.com");

        //                     Driver.getDriver() = driver demek
        WebElement searchBox = Driver.getDriver().findElement(By.name("q"));

        String searchValue = "Galatasaray";

        searchBox.sendKeys(searchValue + Keys.ENTER);

        String actualTitle = Driver.getDriver().getTitle();
        String expectedInTitle = searchValue;

        Assert.assertTrue(actualTitle.contains(expectedInTitle));

        //Calling the custom method we created to close the browser from Driver Utils
        Driver.closeDriver();
    }
}
