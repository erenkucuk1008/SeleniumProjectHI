package com.cybertek.tests.day8_testbase_properties_driver;

import com.cybertek.tests.base.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.WebOrderUtilities;
import org.testng.annotations.Test;

public class WebTablePractices extends TestBase {

    @Test
    public void verify_order_test(){

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        WebOrderUtilities.logIntoSmartBear(driver);
        BrowserUtils.sleep(1);
        WebOrderUtilities.verifyOrder(driver, "Mark Smith");

    }
}
