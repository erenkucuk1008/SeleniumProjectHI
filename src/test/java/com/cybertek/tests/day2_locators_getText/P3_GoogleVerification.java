package com.cybertek.tests.day2_locators_getText;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P3_GoogleVerification {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://google.com");
        driver.findElement(By.linkText("Gmail")).click();

        String expectedTitle = "Gmail";
        String actualTitle = driver.getTitle();
        System.out.println("actualTitle = " + actualTitle);

        if (actualTitle.contains(expectedTitle)){
            System.out.println("Title verification Passed!");
        }else{
            System.err.println("Title verification Failed..");
        }

        driver.navigate().back();

        String expectedTitle2 = "Google";
        String actualTitle2 = driver.getTitle();
        System.out.println("actualTitle2 = " + actualTitle2);

        if (actualTitle2.equals(expectedTitle2)){
            System.out.println("Google Title verification Passed!");
        }else {
            System.err.println("Google Title verification Failed..");
        }

        driver.close();
    }
}
