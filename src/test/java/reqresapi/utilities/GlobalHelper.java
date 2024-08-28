package reqresapi.utilities;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.util.Properties;

@Slf4j
public class GlobalHelper {
    private static final Logger logger = LoggerFactory.getLogger(GlobalHelper.class);
    private static final String routesPropertiesFile = "routes.properties";
    private static final File file = new File("src\\test\\resources");

    public static Properties getGlobalPropertiesFile() {
        logger.info("Entering method getGlobalPropertiesFile to load properties");
        File resourcePath = file.getAbsoluteFile();
        return PropertiesHandler.loadProperties(resourcePath + "\\" + routesPropertiesFile);
    }
}
