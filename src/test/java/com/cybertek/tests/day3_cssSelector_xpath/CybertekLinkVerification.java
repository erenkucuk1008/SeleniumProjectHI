package com.cybertek.tests.day3_cssSelector_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CybertekLinkVerification {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/forgot_password");
        driver.findElement(By.name("email")).sendKeys("anything@gmail.com");
        driver.findElement(By.id("form_submit")).click();
        Thread.sleep(2000);

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "email_sent";

        if (actualURL.contains(expectedURL)){
            System.out.println("URL verification passed");
        }else{
            System.err.println("URL Failed");
        }
        System.out.println("===============================");

        WebElement confirmation_message = driver.findElement(By.name("confirmation_message"));

        // 1.YOL
        String expectedText = "Your e-mail's been sent!";
        String actualText =confirmation_message.getText();

        if (actualText.equals(expectedText)){
            System.out.println("Text verification Passed..");
        }else{
            System.err.println("Text verification failed");
        }

        //2.YOL
        if (confirmation_message.isDisplayed()){
            System.out.println("Text verification isDisplayed Passed..");
        }else{
            System.err.println("Text verification failed");
        }

        driver.close();

    }
}
