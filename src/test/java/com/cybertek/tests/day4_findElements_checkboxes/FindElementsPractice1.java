package com.cybertek.tests.day4_findElements_checkboxes;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FindElementsPractice1 {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("http://practice.cybertekschool.com/forgot_password");

        List<WebElement> listOfLinks = driver.findElements(By.xpath("//body//a"));

        int linkWithText = 0;
        int linkWithoutText = 0;

        for (WebElement eachLink : listOfLinks){
            System.out.println(eachLink.getText());

            if (eachLink.getText().isEmpty()){
                linkWithoutText++;
            }else {
                linkWithText++;
            }
        }

        System.out.println("linkWithoutText = " + linkWithoutText);
        System.out.println("linkWithText = " + linkWithText);
        int numberOfLinks = listOfLinks.size();
        System.out.println("numberOfLinks = " + numberOfLinks);

        driver.close();
    }
}
