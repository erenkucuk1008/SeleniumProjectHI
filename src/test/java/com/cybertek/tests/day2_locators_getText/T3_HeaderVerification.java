package com.cybertek.tests.day2_locators_getText;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_HeaderVerification {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.facebook.com");

        String actualHeader = driver.findElement(By.className("_8eso")).getText();
        String expectedHeader = "Connect with friends and the world around you on Facebook.";

        if (actualHeader.equals(expectedHeader)){
            System.out.println("Header verification Passed!");
        }else {
            System.out.println("Header verification failed..");
        }

        driver.close();
    }
}
