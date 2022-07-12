package com.cybertek.tests.day2_locators_getText;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_2_Facebook {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.facebook.com");

        Thread.sleep(2000);
        driver.findElement(By.id("email")).sendKeys("anything@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.id("pass")).sendKeys("asdasdff"+ Keys.ENTER);
        Thread.sleep(2000);

        String expectedTitle = "Log into Facebook";
        Thread.sleep(5000);
        String actualTitle = driver.getTitle();
        System.out.println("actualTitle = " + actualTitle);

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title Verification Passed!");
        }else {
            System.err.println("Title Verification Failed..");
        }

        driver.close();

    }
}
