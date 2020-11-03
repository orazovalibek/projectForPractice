package com.library.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties = new Properties();

    static {
        try {

            FileInputStream file = new FileInputStream("Configuration.properties");
            properties.load(file);
            file.close();

        } catch (IOException e) {

            System.out.println("Unable to read from Configuration.properties file !");

        }
    }

    public static String getProperty(String keyWord){
        return properties.getProperty(keyWord);
    }

}