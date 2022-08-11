package com.cybertek.tests.day8_testbase_properties_driver;

import com.cybertek.utilities.WebDriverFactory;
import com.cybertek.utilities.WebOrderUtilities;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WebTablePractices {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() throws InterruptedException {

        driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void verify_order_test(){

        WebOrderUtilities.logIntoSmartBear(driver);

        WebOrderUtilities.verifyOrder(driver, "Mark Smith");

    }
}
