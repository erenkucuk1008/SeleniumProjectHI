package com.cybertek.tests.day4_findElements_checkboxes;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ornek_Copy_WebELement_AsXpath {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("http://practice.cybertekschool.com/forgot_password");

        WebElement inputBox = driver.findElement(By.xpath("//*[@id=\"forgot_password\"]/div/div/label"));
        /*
        html de attribute nin uzerine gelip,
        copy --> copy xpath
        dedigimizde xpath formationda web elementi bize veriyor. SUPER KOLAYLIKkkkkkkk!!!!1
         */
        System.out.println(inputBox.getText());

    }
}
