package com.cybertek.tests.day5_testNG_intro_dropDowns;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Drowdown_Introduction {

    WebDriver driver;

    @BeforeClass
    public void setupClass(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test
    public void dropdown_test1(){
        WebElement simpleDropdown = driver.findElement(By.xpath("//select[@id='dropdown']"));

        Select select = new Select(simpleDropdown);
        WebElement currentlySelected = select.getFirstSelectedOption();

        String expectedDefaultValue = "Please select an option";
        String actualDefaultValue = currentlySelected.getText();

        Assert.assertEquals(actualDefaultValue,expectedDefaultValue);
    }

    @Test
    public void selectState_test2(){
        WebElement selectState = driver.findElement(By.xpath("//select[@id='state']"));

        Select select = new Select(selectState);
        WebElement currentlySelected = select.getFirstSelectedOption();

        String expectedDefaultValue = "Select a State";
        String actualDefaultValue = currentlySelected.getText();

        Assert.assertEquals(actualDefaultValue,expectedDefaultValue);
    }

    @AfterClass
    public void tear(){
        driver.close();
    }
}
