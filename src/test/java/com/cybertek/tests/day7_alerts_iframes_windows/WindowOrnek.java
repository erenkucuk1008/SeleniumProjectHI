package com.cybertek.tests.day7_alerts_iframes_windows;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowOrnek {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/windows");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void new_Window(){

        WebElement clickHere = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHere.click();

        String mainWindow = driver.getWindowHandle();

        Set<String> windowHandles = driver.getWindowHandles();

        for (String eachWindow : windowHandles) {
            driver.switchTo().window(eachWindow);
            System.out.println("CURRENT TITLE IS: "+ driver.getTitle());
        }

        String actualFinalTitle = driver.getTitle();
        String expectedFinalTitle = "New Window";

        Assert.assertEquals(actualFinalTitle, expectedFinalTitle);

        driver.switchTo().window(mainWindow);
    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }
}
