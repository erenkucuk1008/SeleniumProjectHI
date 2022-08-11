package com.cybertek.tests.day8_testbase_properties_driver;

import com.cybertek.tests.base.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.WebOrderUtilities;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class WebTablePractices extends TestBase {

    @Test
    public void verify_order_test() throws IOException {

        Properties properties = new Properties();
        FileInputStream file = new FileInputStream("configuration.properties");
        properties.load(file);
        String URL = properties.getProperty("weborderURL");
        driver.get(URL);
        WebOrderUtilities.logIntoSmartBear(driver);
        BrowserUtils.sleep(1);
        WebOrderUtilities.verifyOrder(driver, "Mark Smith");

    }
}
