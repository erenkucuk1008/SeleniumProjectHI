package com.cybertek.tests.day7_alerts_iframes_windows;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IframePractice {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        //Open browser
        driver = WebDriverFactory.getDriver("chrome");

        //Go to website: http://practice.cybertekschool.com/iframe
        driver.get("http://practice.cybertekschool.com/iframe");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void iframe_test(){

        //Lets change driver's focus to the <iframe>
        //1.Locate as WebElement
        //WebElement iframe = driver.findElement(By.id("mce_0_ifr"));

        //switching driver's focus to iframe using 'switcTo' method
        //driver.switchTo().frame(iframe);

        //2.Pass Index number
        //driver.switchTo().frame(0);

        //3.Pass id or name attribute value(IF THERE ARE ANY)
        //if there is ID or NAME attribute value, they can be directly as a String
        driver.switchTo().frame("mce_0_ifr");
        WebElement text = driver.findElement(By.xpath("//p"));

        //4. Assert: “Your content goes here.” Text is displayed.
        Assert.assertTrue(text.isDisplayed());

        //locating the header
        //driver.switchTo().defaultContent();
        driver.switchTo().parentFrame();

        WebElement headerText = driver.findElement(By.tagName("h3"));
        //5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor
        Assert.assertTrue(headerText.isDisplayed());
    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }
}

