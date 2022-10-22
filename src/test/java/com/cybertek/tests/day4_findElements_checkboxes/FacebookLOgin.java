package com.cybertek.tests.day4_findElements_checkboxes;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FacebookLOgin {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        Thread.sleep(5000);
        driver.manage().window().maximize();
        driver.get("http://www.facebook.com");

        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.name("pass"));
        WebElement login = driver.findElement(By.name("login"));

        email.sendKeys("abc@gmail.com");
        Thread.sleep(3000);
        password.sendKeys("ABC123");
        Thread.sleep(3000);
        login.click();

        String expectedErrorText = "Forgot Password";
        WebElement errorText = driver.findElement(By.linkText("Forgot Password?"));
        String actualErrorText = errorText.getText();

        if (actualErrorText.contains(expectedErrorText)){
            System.out.println("PASSED");
        }

        driver.close();
    }
}
