package com.cybertek.utilities;

public class BrowserUtils {

    //wait method

    public static void sleep(int second){

        second *= 1000;
        try{
            Thread.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
