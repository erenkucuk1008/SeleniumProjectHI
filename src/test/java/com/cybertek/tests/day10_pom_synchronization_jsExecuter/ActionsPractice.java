package com.cybertek.tests.day10_pom_synchronization_jsExecuter;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ActionsPractice {

    @Test
    public void p2_double_click_test(){
        //go to https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
        //switch to iframe
        //double click on the text
        //Assert: text's style attribute value contains "red"

        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");

        Driver.getDriver().switchTo().frame("iframeResult");

        WebElement textDouble = Driver.getDriver().findElement(By.id("demo"));

        Actions actions = new Actions(Driver.getDriver());

        actions.doubleClick(textDouble).perform();

        String expected = "red";
        String actual = textDouble.getAttribute("style");

        Assert.assertTrue(actual.contains(expected));

    }

    @AfterMethod
    public void tearDown(){
        BrowserUtils.sleep(2);
        Driver.closeDriver();
    }
}
