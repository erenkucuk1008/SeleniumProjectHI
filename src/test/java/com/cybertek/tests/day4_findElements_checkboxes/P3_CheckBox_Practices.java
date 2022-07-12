package com.cybertek.tests.day4_findElements_checkboxes;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class P3_CheckBox_Practices {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/checkboxes");

        WebElement checkBox1 = driver.findElement(By.xpath("//input[@id='box1']"));

        if (!checkBox1.isSelected()){
            System.out.println("CheckBox1 is not selected by default. PASSED..");
        }else{
            System.out.println("CheckBox1 is selected by default. FAILED");
        }

        WebElement checkBox2 = driver.findElement(By.xpath("//input[@id='box2']"));

        if (checkBox2.isSelected()){
            System.out.println("CheckBox2 is selected by default. PASSED..");
        }else{
            System.out.println("CheckBox2 is not selected by default. FAILED");
        }

        Thread.sleep(1500);
        checkBox1.click();
        Thread.sleep(1500);
        checkBox2.click();


        if (checkBox1.isSelected()){
            System.out.println("CheckBox1 is selected. PASSED..");
        }else{
            System.out.println("CheckBox1 is not selected. FAILED");
        }

        if (!checkBox2.isSelected()){
            System.out.println("CheckBox2 is not selected. PASSED..");
        }else{
            System.out.println("CheckBox2 is selected. FAILED");
        }

        driver.findElement(By.linkText("Home")).click();

        Thread.sleep(2000);
        driver.navigate().back();

        checkBox1 = driver.findElement(By.xpath("//input[@id='box1']"));
        checkBox1.click();
        Thread.sleep(3000);

        driver.close();

    }
}
