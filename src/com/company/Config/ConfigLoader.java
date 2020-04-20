package com.company.Config;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class ConfigLoader {
    private static final String VALID_OPERATORS = "validOperators";

    public static ArrayList<String> loadConfig(String CONFIG_PATH) {
        Properties prop = new Properties();
        try (FileReader configFile = new FileReader(CONFIG_PATH)) {
            prop.load(configFile);
            String validOperatorsText = prop.getProperty(VALID_OPERATORS);
            return ConfigParser.parseValidOperatorsString(validOperatorsText);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
            return null;
        }
    }
}
