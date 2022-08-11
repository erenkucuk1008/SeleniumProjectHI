package com.cybertek.tests.day8_testbase_properties_driver;

import com.cybertek.tests.base.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.WebOrderUtilities;
import org.testng.annotations.Test;

import java.io.IOException;

public class WebTablePractices extends TestBase {

    @Test
    public void verify_order_test() throws IOException {

        String URL = ConfigurationReader.getProperty("weborderURL");
        driver.get(URL);
        WebOrderUtilities.logIntoSmartBear(driver);
        BrowserUtils.sleep(1);
        WebOrderUtilities.verifyOrder(driver, "Mark Smith");

    }
}
