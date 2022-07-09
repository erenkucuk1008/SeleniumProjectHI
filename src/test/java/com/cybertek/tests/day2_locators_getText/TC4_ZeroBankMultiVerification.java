package com.cybertek.tests.day2_locators_getText;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC4_ZeroBankMultiVerification {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://zero.webappsecurity.com/login.html");
        driver.findElement(By.id("user_login")).sendKeys("username");
        driver.findElement(By.id("user_password")).sendKeys("password"+ Keys.ENTER);
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);

        driver.findElement(By.id("account_activity_link")).click();
        Thread.sleep(2500);
        String actualTitle = driver.getTitle();
        //System.out.println("actualTitle = " + actualTitle);
        String expectedTitle = "Zero - Account Activity";

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Account activity verification Passed!");
        }else {
            System.err.println("Title verification Failed..");
        }
        System.out.println("=====================================");
        driver.findElement(By.linkText("Transfer Funds")).click();
        Thread.sleep(2500);
        String actualTitle2 = driver.getTitle();
        //System.out.println("actualTitle2 = " + actualTitle2);
        String expectedTitle2 = "Zero - Transfer Funds";

        if (actualTitle2.equals(expectedTitle2)){
            System.out.println("Transfer funds verification Passed!");
        }else {
            System.err.println("Title verification Failed..");
        }
        System.out.println("=====================================");
        driver.findElement(By.linkText("Pay Bills")).click();
        Thread.sleep(2500);
        String actualTitle3 = driver.getTitle();
        //System.out.println("actualTitle3 = " + actualTitle3);
        String expectedTitle3 = "Zero - Pay Bills";

        if (actualTitle3.equals(expectedTitle3)){
            System.out.println("Pay Bills verification Passed!");
        }else {
            System.err.println("Title verification Failed..");
        }
        System.out.println("=====================================");
        driver.findElement(By.linkText("My Money Map")).click();
        Thread.sleep(2500);
        String actualTitle4 = driver.getTitle();
        //System.out.println("actualTitle4 = " + actualTitle4);
        String expectedTitle4 = "Zero - My Money Map";

        if (actualTitle4.equals(expectedTitle4)){
            System.out.println("My money map verification Passed!");
        }else {
            System.err.println("Title verification Failed..");
        }
        System.out.println("=====================================");
        driver.findElement(By.linkText("Online Statements")).click();
        Thread.sleep(2500);
        String actualTitle5 = driver.getTitle();
        //System.out.println("actualTitle5 = " + actualTitle5);
        String expectedTitle5 = "Zero - Online Statements";

        if (actualTitle5.equals(expectedTitle5)){
            System.out.println("Online Statements verification Passed!");
        }else {
            System.err.println("Title verification Failed..");
        }

        driver.close();
    }
}
