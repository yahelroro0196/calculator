package ShuntingYardCalculator.Config;

import ShuntingYardCalculator.Logging.Log4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Properties;

import static ShuntingYardCalculator.Config.ConfigParser.parseValidOperatorsString;

public class ConfigLoader {
    private static final String VALID_OPERATORS = "Valid_Operators";

    public static ArrayList<String> loadConfig(String CONFIG_PATH) {
        Properties prop = new Properties();
        try {
            FileInputStream configFile = new FileInputStream(CONFIG_PATH);
            InputStreamReader configStreamReader = new InputStreamReader(configFile);

            String propertiesData = loadStreamData(configFile, configStreamReader);
            return parseValidOperatorsString(propertiesData);
        } catch (IOException e) {
            Log4j.displayConfigError();
            System.exit(0);
            return null;
        }
    }

    private static String loadStreamData(FileInputStream configFile, InputStreamReader configStreamReader) throws IOException {
        StringBuilder propertiesData = new StringBuilder();
        int charAsInt;
        while ((charAsInt=configStreamReader.read()) != -1) {
            char dataChar = (char) charAsInt;
            propertiesData.append(dataChar);
        }
        configStreamReader.close();
        configFile.close();
        return propertiesData.toString();
    }
}
