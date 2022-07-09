package com.cybertek.tests.day2_locators_getText;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T4_AtrributeValueVerification {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.facebook.com");

        String expectedAttribute = "registration_form";
        String actualAttribute = driver.findElement(By.linkText("Create a Page")).getAttribute("href");

        if (actualAttribute.contains(expectedAttribute)){
            System.out.println("Attribute Verification Passed!");
        }else {
            System.out.println("Attribute Verification Failed");
        }

        driver.close();
    }
}
