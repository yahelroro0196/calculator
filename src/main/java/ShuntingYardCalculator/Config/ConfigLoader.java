package ShuntingYardCalculator.Config;

import ShuntingYardCalculator.Logging.Log4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConfigLoader {
    public static String streamFileLoader(String CONFIG_PATH) {
        try {
            FileInputStream configFile = new FileInputStream(CONFIG_PATH);
            InputStreamReader configStreamReader = new InputStreamReader(configFile);

            return loadStreamData(configFile, configStreamReader);
        } catch (IOException e) {
            Log4j.displayError("Error loading config!");
            System.exit(0);
            return null;
        }
    }

    private static String loadStreamData(FileInputStream configFile, InputStreamReader configStreamReader)
            throws IOException {
        StringBuilder propertiesData = new StringBuilder();
        int charAsInt;
        while ((charAsInt = configStreamReader.read()) != -1) {
            char dataChar = (char) charAsInt;
            propertiesData.append(dataChar);
        }
        configStreamReader.close();
        configFile.close();
        return propertiesData.toString();
    }
}
