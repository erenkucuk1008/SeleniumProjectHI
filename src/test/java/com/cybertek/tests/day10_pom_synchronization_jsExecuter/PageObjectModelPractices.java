package com.cybertek.tests.day10_pom_synchronization_jsExecuter;

import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.testng.annotations.Test;

public class PageObjectModelPractices {

    @Test
    public void login_to_smartbear(){

        String url = ConfigurationReader.getProperty("weborderURL");
        Driver.getDriver().get(url);

        LoginPage loginPage = new LoginPage();

        loginPage.inputUsername.sendKeys("tester");
        loginPage.inputPassword.sendKeys("test");
        loginPage.loginButton.click();
    }
}
