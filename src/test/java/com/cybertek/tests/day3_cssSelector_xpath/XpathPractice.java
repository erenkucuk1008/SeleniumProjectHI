package com.cybertek.tests.day3_cssSelector_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XpathPractice {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/");

        WebElement multipleButtons = driver.findElement(By.xpath("//a[.='Multiple Buttons']"));
        multipleButtons.click();

        Thread.sleep(1000);

        WebElement buttonThree = driver.findElement(By.xpath("//button[@onclick='button3()']"));
        buttonThree.click();

        WebElement result = driver.findElement(By.xpath("//p[@id='result']"));
        String resultText = result.getText();

        System.out.println("resultText = " + resultText);

        driver.close();
    }

}
