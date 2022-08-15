package com.cybertek.tests.day10_pom_synchronization_jsExecuter;

import com.cybertek.pages.DynamicLoad7Page;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebDriverWaitPractices {

    @Test
    public void dynamic_load_7(){

        Driver.getDriver().get("http://practice.cybertekschool.com/dynamic_loading/7");

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.titleIs("Dynamic title"));

        DynamicLoad7Page dynamicLoad7Page = new DynamicLoad7Page();

        Assert.assertTrue(dynamicLoad7Page.infoMessage.isDisplayed());
        //BrowserUtils.sleep(2);title resimden once geliyor, dolayisyla test fail oluyor. Thread.sleep() koymak gerekiyor bende
        Assert.assertTrue(dynamicLoad7Page.image.isDisplayed());
    }
}
