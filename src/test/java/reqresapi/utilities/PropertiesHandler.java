package reqresapi.utilities;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.FileInputStream;
import java.util.Properties;

@Slf4j
public class PropertiesHandler {
    private static final Logger log = LoggerFactory.getLogger(PropertiesHandler.class);

    //private static final Logger logger = LoggerFactory.getLogger(PropertiesHandler.class);
    public PropertiesHandler() {
    }

    public static Properties loadProperties(String path) {
        Properties properties = new Properties();
        try {
            FileInputStream input = new FileInputStream(path);
            properties.load(input);
            return properties;
        } catch (Exception exception) {
            log.error("Exception while loading properties: {}", exception.getMessage());
            return null;
        }
    }
}
