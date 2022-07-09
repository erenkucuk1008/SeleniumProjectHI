package com.cybertek.tests.day2_locators_getText;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC2_LinkTextVerification {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://zero.webappsecurity.com/login.html");

        String actualHREF = driver.findElement(By.className("brand")).getAttribute("href");
        String expectedHREF = "index.html";
        System.out.println("actualHREF = " + actualHREF);

        if (actualHREF.contains(expectedHREF)){
            System.out.println("HREF verification Passed!");
        }else {
            System.err.println("HREF verification Failed..");
        }

        String actualLinkText = driver.findElement(By.className("brand")).getText();
        String expectedLinkText = "Zero Bank";
        System.out.println("actualLinkText = " + actualLinkText);

        if (actualLinkText.equals(expectedLinkText)){
            System.out.println("Link Text verification Passed!");
        }else {
            System.err.println("Link Text verification Failed..");
        }

        driver.close();
    }
}
