package com.cybertek.tests.day5_testNG_intro_dropDowns;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_Intro {

    @BeforeMethod
    public void setUpMethod(){
        System.out.println("Before method is running...");
    }

    @AfterMethod
    public void teardownMethod(){
        System.out.println("After method is running...");
    }

    @BeforeClass
    public void setUpClass(){
        System.out.println("Before class is running...");
    }

    @AfterClass
    public void teardownClass(){
        System.out.println("After class is running...");
    }

    @Test
    public void Test1(){
        System.out.println("Running test 1...");
    }

    @Test
    public void Test2(){
        System.out.println("Running test 2...");
    }

    @Test
    public void Test3(){
        System.out.println("Running test 3...");

        String str1 = "hello";
        String str2 = "hello";
        String str3 = "helloHawaii";

        Assert.assertTrue(str1.equals(str2),"SELF NOTE TO OURSELVES");

        Assert.assertEquals(str3, str1,"Error on line 48");
        //                actual, expected
    }

}
