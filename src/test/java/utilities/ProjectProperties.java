package utilities;

import utilities.exceptions.PropertyNotFound;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ProjectProperties {

    File file;
    FileInputStream stream;
    Properties properties;

    public ProjectProperties() {
        file = new File("src/test/resources/uiFramework.properties");
        try {
            stream = new FileInputStream(file);
            properties = new Properties();
            properties.load(stream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String get(String key) throws PropertyNotFound {
        if(properties.containsKey(key))
            return properties.getProperty(key);
        else
            throw new PropertyNotFound(key);
    }
}
