package com.cybertek.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebOrderUtilities {


    public static void logIntoSmartBear(WebDriver driver){
        //Enter username: "Tester"
        WebElement username = driver.findElement(By.id("ctl00_MainContent_username"));
        username.sendKeys("Tester");

        //Enter password: "test"
        WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));
        password.sendKeys("test");

        //Click to Login button
        WebElement logInButton = driver.findElement(By.id("ctl00_MainContent_login_button"));
        logInButton.click();
    }
}
