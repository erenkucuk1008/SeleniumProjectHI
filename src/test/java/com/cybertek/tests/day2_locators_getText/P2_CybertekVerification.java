package com.cybertek.tests.day2_locators_getText;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P2_CybertekVerification {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://practice.cybertekschool.com");

        String currentURL = driver.getCurrentUrl();
        String currentTitle = driver.getTitle();
        System.out.println("currentTitle = " + currentTitle);
        System.out.println("currentURL = " + currentURL);

        if (currentURL.contains("cybertekschool")){
            System.out.println("URL Verified");
        }else {
            System.out.println("Not verified");
        }

        if (currentTitle.contains("practice")){
            System.out.println("Title verified");
        }else {
            System.out.println("Title not verified");
        }

        driver.close();
    }
}
