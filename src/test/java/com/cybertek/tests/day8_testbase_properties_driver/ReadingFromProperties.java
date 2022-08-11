package com.cybertek.tests.day8_testbase_properties_driver;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingFromProperties {

    @Test
    public void reading_from_properties_file() throws IOException {
        //Create Properties class object
        Properties properties = new Properties();

        //Open the file in JVM Memory and pass the path of file
        String path = "configuration.properties";

        FileInputStream file = new FileInputStream(path);

        //Load the opened file into the Properties object
        properties.load(file);

        //read some values from the file
        System.out.println("properties.getProperty(\"browser\") = " + properties.getProperty("browser"));

        System.out.println("properties.getProperty(\"username\") = " + properties.getProperty("username"));
    }


}
