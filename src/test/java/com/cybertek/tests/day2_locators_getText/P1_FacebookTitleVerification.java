package com.cybertek.tests.day2_locators_getText;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P1_FacebookTitleVerification {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.facebook.com");
        String currentTitle = driver.getTitle();
        System.out.println(currentTitle);

        if (currentTitle.equalsIgnoreCase("Facebook - Log In or Sign Up")){
            System.out.println("Title verify successfully");
        }else{
            System.out.println("not verified");
        }

        driver.close();
    }
}
