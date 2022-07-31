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

public class WindowHandlePractice {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/windows");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void window_handling_test() throws InterruptedException {

        String actualTitle = driver.getTitle();
        String expectedTitle = "Windows";

        Assert.assertEquals(actualTitle,expectedTitle);

        WebElement clickHereLink = driver.findElement(By.linkText("Click Here"));
        clickHereLink.click();

        String mainHandle = driver.getWindowHandle();
        System.out.println("Window Handle: "+mainHandle);

        Set<String> windowHandles = driver.getWindowHandles();

        //switch to the new window
        for (String each : windowHandles) {
            driver.switchTo().window(each);
            System.out.println("CURRENT TITLE WHILE SWITCHING: "+driver.getTitle());

        }

        String actualFinalTitle = driver.getTitle();
        String expectedFinalTitle = "New Window";

        Assert.assertEquals(actualFinalTitle, expectedFinalTitle);

        Thread.sleep(3000);
        //If i wanted to switch main window
        driver.switchTo().window(mainHandle);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(3000);
        driver.quit();

    }
}
