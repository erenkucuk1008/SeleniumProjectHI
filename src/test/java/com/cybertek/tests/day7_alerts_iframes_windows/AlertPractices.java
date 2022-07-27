package com.cybertek.tests.day7_alerts_iframes_windows;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertPractices {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){

        //1. Open browser
        driver = WebDriverFactory.getDriver("chrome");

        //2. Go to website: http://practice.cybertekschool.com/javascript_alerts
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test
    public void click_JS_Alert() throws InterruptedException {
        //Locating the button for alert to click
        WebElement JS_Alert_Button = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));

        //3. Click to “Click for JS Alert” button
        JS_Alert_Button.click();

        Thread.sleep(2000);

        //4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();

        //Use alert instance to click and close the alert
        alert.accept();
//
        //5. Verify “You successfuly clicked an alert” text is displayed
        WebElement successMessage = driver.findElement(By.id("result"));
        Assert.assertEquals(successMessage.getText(),"You successfully clicked an alert");
    }

    @AfterMethod
    public void tearMethod() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }
}

