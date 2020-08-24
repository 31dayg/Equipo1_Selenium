package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
    public static String getProperty(String fileName, String key) {
        Properties properties = new Properties();
        InputStream inputStream = null;
        String propertyValue = null;

        try {
            //inputStream = new FileInputStream(fileName);
            inputStream = ClassLoader.getSystemResourceAsStream(fileName);
            properties.load(inputStream);
            propertyValue = properties.getProperty(key);
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } finally { // Pase lo que pase se va a correr lo que esta dentro de aqui.
            closeInput(inputStream);
            return propertyValue;
        }
    }

    public static void closeInput(InputStream inputStream) {
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
