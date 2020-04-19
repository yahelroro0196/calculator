package com.company.Config;

import com.company.Main;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class ConfigLoader {
    public static ArrayList<String> loadConfig(String CONFIG_PATH) throws IOException {
        Properties prop = new Properties();
        try (FileReader configFile = new FileReader(CONFIG_PATH)) {
            prop.load(configFile);
            String validOperatorsText = prop.getProperty(Main.VALID_OPERATORS);
            return ConfigParser.parseValidOperatorsString(validOperatorsText);
        } catch (IOException exception) {
            throw exception;
        }
    }
}
