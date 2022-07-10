package com.cybertek.tests.day3_cssSelector_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonCssSelectorTask {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://www.amazon.com");

        WebElement amazonSearchBar = driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"));
        amazonSearchBar.sendKeys("apple"+ Keys.ENTER);

        String actualTitle = driver.getTitle();
        System.out.println("actualTitle = " + actualTitle);

        driver.close();
    }
}
