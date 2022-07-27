package com.cybertek.tests.day6_dropdown_review_javafaker;

import com.cybertek.utilities.WebDriverFactory;
import com.cybertek.utilities.WebOrderUtilities;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebOrder_Practices {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        //Open browser
        driver = WebDriverFactory.getDriver("chrome");

        //Go to website:
        //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        WebOrderUtilities.logIntoSmartBear(driver);
    }

    @Test
    public void test2_create_order_with_java_faker() throws InterruptedException {
        //Click on Order
        WebElement orderLink = driver.findElement(By.xpath("//a[.='Order']"));
        orderLink.click();

        //Select familyAlbum from product
        Select product = new Select(driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']")));
        product.selectByValue("FamilyAlbum");

        // set Quantity 2
        WebElement quantity = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
        Thread.sleep(1000); //Baslangicta 0 yaziyor, 2 yaz diyince 02 oluyor
        quantity.sendKeys(Keys.BACK_SPACE); // Bu komutla 0 siliniyor, bos kaliyor
        Thread.sleep(1000);
        quantity.sendKeys("2");// 2 yaziyor sadece not 02

        //Click the calculate button
        WebElement calculateButton = driver.findElement(By.xpath("//input[@type='submit']"));
        calculateButton.click();

        //Fill address Info with javaFaker
        WebElement name = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
        WebElement street = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2"));
        WebElement city = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3"));
        WebElement state = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4"));
        WebElement zipCode = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));

        Faker faker = new Faker();
        name.sendKeys(faker.name().fullName());
        street.sendKeys(faker.address().streetAddress());
        city.sendKeys(faker.address().cityName());
        state.sendKeys(faker.address().state());
        zipCode.sendKeys(faker.address().zipCode());

        //.Generate: name, street, city, state, zipCode
        //Click on "visa" radio button
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();

        //Generate card number using JavaFaker
        WebElement cardNumber = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6"));
        cardNumber.sendKeys(faker.finance().creditCard());

        //Expire date
        WebElement expireDate = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1"));
        expireDate.sendKeys("01/26");

        //Click on Process
        WebElement processButton = driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton"));
        processButton.click();
        Thread.sleep(5000);

        //Verify success message "New order has been successfully added".
        WebElement successMessage = driver.findElement(By.xpath("//div[@class='buttons_process']/strong"));
        Assert.assertTrue(successMessage.isDisplayed(),"Success message is not displayed!");
    }

    @Test
    public void test1_linkVerifications(){

        //Print out count of all the links on landing page
        List<WebElement> listOfLinks = driver.findElements(By.xpath("//body//a"));
        System.out.println("Number of Links : "+listOfLinks.size());

        //print each text
        for (WebElement each : listOfLinks) {
            System.out.println("Links: "+each.getText());
        }
    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

}
