package utils.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private static final String propertyFilePath = "config.properties";

    private static Properties getProperties() {
        Properties value = new Properties();
        try {
            value.load(new FileInputStream(propertyFilePath));
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return value;
    }

    public static String getPropertyValue(String key){
        return getProperties().getProperty(key);
    }

    public static String getApplicationUrl(){
        return getPropertyValue("application.url");
    }

    public static String getSenderEmail(){
        return getPropertyValue("sender.email");
    }

    public static String getSenderPassword(){
        return getPropertyValue("sender.password");
    }

    public static String getRecipientEmail(){
        return getPropertyValue("recipient.email");
    }

    public static String getRecipientPassword(){
        return getPropertyValue("recipient.password");
    }



}
