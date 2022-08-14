package com.cybertek.tests.day9_driver_actions_uploads;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadPractice {

    /*
    @BeforeMethod
    public void setUpMethod(){
        Driver.getDriver().get("http://practice.cybertekschool.com/upload");
    }

     */

    @Test
    public void upload_test(){
        //driver = Driver.getDriver()
        Driver.getDriver().get("http://practice.cybertekschool.com/upload");

        //Choose File butonunu locate edip, sendKeys diyoruz.
        WebElement chooseFile = Driver.getDriver().findElement(By.id("file-upload"));
        chooseFile.sendKeys("C:\\Users\\erenk\\Downloads\\1615238768289-CollectionsFrameworkHierarchy1.png");
        //resim path-> right click-> properties-> security den buluruz

        Driver.getDriver().findElement(By.id("file-submit")).click();

        WebElement fileUploaded = Driver.getDriver().findElement(By.xpath("//h3"));
        Assert.assertTrue(fileUploaded.isDisplayed());
    }
}
