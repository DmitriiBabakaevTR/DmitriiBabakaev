package hw8;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {

    protected static Properties PROPERTIES;

    static {
        try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/hw8/test.properties"))
        {
            PROPERTIES = new Properties();
            PROPERTIES.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }
}