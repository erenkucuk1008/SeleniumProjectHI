package com.cybertek.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        /*
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver1 = new FirefoxDriver();    we can assign another browser
         */

        driver.manage().window().maximize();

        driver.get("https://www.google.com");
        System.out.println("Current title is: "+driver.getTitle());

        String currentURL = driver.getCurrentUrl();
        System.out.println("Current URL is: "+currentURL);

        Thread.sleep(3000);
        driver.navigate().back();

        Thread.sleep(3000);
        driver.navigate().forward();

        Thread.sleep(3000);
        driver.navigate().to("https://www.tesla.com");
        System.out.println("Current title is: "+driver.getTitle());

        currentURL = driver.getCurrentUrl();
        System.out.println("Current URL is: "+currentURL);

        driver.close();

    }
}
