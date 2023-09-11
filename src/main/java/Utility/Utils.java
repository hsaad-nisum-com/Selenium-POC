package Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utils {
    public static String getElementFromPropertiesFile(String key, String filename) {
        Properties property = new Properties();
        try {
            FileInputStream readMe = new FileInputStream("src/test/java/Resources/global.properties");
            property.load(readMe);
        } catch (IOException exception) {
            System.out.println("Something gone wrong in Utils. getElementFromPropertiesFile " + exception.getMessage());
        }
        return property.getProperty(key);
    }
}
