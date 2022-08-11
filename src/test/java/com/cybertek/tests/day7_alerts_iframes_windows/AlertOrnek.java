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

public class AlertOrnek {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://practice.cybertekschool.com/javascript_alerts");
    }

    //TC1-Day7
    @Test
    public void JS_Alert(){

        WebElement JS_Alert = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        JS_Alert.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        //WebElement successfully_message = driver.findElement(By.xpath("//p[2]"));
        //WebElement successfully_message = driver.findElement(By.xpath("//p[.='You successfully clicked an alert']"));
        WebElement successfully_message = driver.findElement(By.id("result"));

        Assert.assertTrue(successfully_message.isDisplayed());
    }

    //TC2-Day7
    @Test
    public void JS_Confirm(){

        WebElement JS_Confirm = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        JS_Confirm.click();

        Alert alert_confirm = driver.switchTo().alert();
        alert_confirm.accept();

        WebElement result_Confirm = driver.findElement(By.id("result"));

        String actualText = result_Confirm.getText();
        String expectedText = "You clicked: Ok";

        Assert.assertEquals(actualText, expectedText);

    }

    //TC3-Day7
    @Test
    public void JS_Prompt(){

        WebElement JS_Prompt = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        JS_Prompt.click();

        Alert alert_Prompt = driver.switchTo().alert();
        alert_Prompt.sendKeys("hello");

        alert_Prompt.accept();

        WebElement result_Prompt = driver.findElement(By.id("result"));

        String actualText = result_Prompt.getText();
        String expectedText = "You entered: hello";

        Assert.assertEquals(actualText, expectedText);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(2000);
        driver.close();
    }
}
