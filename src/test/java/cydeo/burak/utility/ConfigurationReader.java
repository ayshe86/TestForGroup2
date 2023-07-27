package cydeo.burak.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties=new Properties();

    static {

        try {
            FileInputStream file=new FileInputStream("configuration.properties");
            properties.load(file);

        } catch (IOException e) {

        }
    }
        public static String getProperty(String keyword){

        return properties.getProperty(keyword);
        }
}
