package com.selenium.dataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;
import java.io.IOException;
import java.io.FileNotFoundException;
//This is a java class for reading the properties file.
public class ConfigFileReader {

    private Properties properties;
    private final String propertyFilePath= "Configs//Configuration.properties";


    public ConfigFileReader(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public long getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
        else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
    }

    public String getApplicationUrl() {
        String url = properties.getProperty("url");
        if(url != null) return url;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }

    public String getUsername() {
        String username = properties.getProperty("username");
        if(username != null) return username;
        else throw new RuntimeException("username not specified in the Configuration.properties file.");
    }

    public String getPassword() {
        String password = properties.getProperty("password");
        if(password != null) return password;
        else throw new RuntimeException("password not specified in the Configuration.properties file.");
    }

    public String getAlert() {
        String alert = properties.getProperty("alert");
        if(alert != null) return alert;
        else throw new RuntimeException("alert not specified in the Configuration.properties file.");
    }
    public String getForgotPageContains() {
        String forgotLink = properties.getProperty("forgotPageContains");
        if(forgotLink != null) return forgotLink;
        else throw new RuntimeException("forgotLink not specified in the Configuration.properties file.");
    }
}
