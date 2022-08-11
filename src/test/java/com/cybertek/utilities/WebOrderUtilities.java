package com.cybertek.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

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

    public static void verifyOrder(WebDriver driver, String expectedName){
        //Listede verilen isim var mi, yok mu diye verify edecek methodu yaziyoruz
            //table[@id='ctl00_MainContent_orderGrid']//tr//td[2] ---- ISMI VEREN WEB ELEMENT

        List<WebElement> allNames = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr//td[2]"));

        for (WebElement eachName : allNames) {
            if (eachName.getText().equals(expectedName)){
                Assert.assertTrue(eachName.getText().equals(expectedName));
                return;
            }
        }

        //The only condition where the Assert.fail() line below executed is if 'expectedName' is not in the table
        Assert.fail("The expectedName is not in the table.");

    }

}
