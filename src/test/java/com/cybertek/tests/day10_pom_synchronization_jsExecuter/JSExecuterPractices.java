package com.cybertek.tests.day10_pom_synchronization_jsExecuter;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JSExecuterPractices {

    @Test
    public void scroll_using_jsexecuter_test1() {

        Driver.getDriver().get("http://practice.cybertekschool.com/infinite_scroll");

        //create instance of JSExecuter and cast our driver type to it
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        //Use "js" to reach JavascriptExecuter method

        //creating the for loop just to scroll down 750pixels, 10 times
        for (int i=0; i<10; i++){
            BrowserUtils.sleep(1);
            js.executeScript("window.scrollBy(0, 750)");
        }



    }

    @Test
    public void scroll_using_jsexecuter_test2(){
        Driver.getDriver().get("http://practice.cybertekschool.com/large");

        //create object of js executer
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        WebElement cydeoLink = Driver.getDriver().findElement(By.linkText("CYDEO"));
        js.executeScript("arguments[0].scrollIntoView(true)",cydeoLink);
        //     parantez icini google search ettik oyle yazdik ","den sonrasi da nereye kadar asagi inecegimizi belirliyoruz.

    }
}
