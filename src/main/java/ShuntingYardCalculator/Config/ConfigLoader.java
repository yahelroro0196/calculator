package ShuntingYardCalculator.Config;

import ShuntingYardCalculator.Logging.Log4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

public class ConfigLoader {
    private static final String VALID_OPERATORS = "Valid_Operators";

    public static ArrayList<String> loadConfig(String CONFIG_PATH) {
        Properties prop = new Properties();
        try (InputStream inputStream = new FileInputStream(CONFIG_PATH)) {
            prop.load(inputStream);
            String validOperatorsText = prop.getProperty(VALID_OPERATORS);
            return ConfigParser.parseValidOperatorsString(validOperatorsText);
        } catch (IOException e) {
            Log4j.displayConfigError();
            System.exit(0);
            return null;
        }
    }
}
