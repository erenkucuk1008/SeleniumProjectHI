package com.cybertek.tests.day9_driver_actions_uploads;

import org.testng.annotations.Test;

public class SingletonPractice {

    @Test
    public void singleton_test1(){
        String str1 = Singleton.getWord();
        System.out.println("str1 = " + str1);
    }
}
