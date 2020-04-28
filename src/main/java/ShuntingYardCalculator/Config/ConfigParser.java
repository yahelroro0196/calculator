package ShuntingYardCalculator.Config;

import java.util.HashMap;

import static ShuntingYardCalculator.Config.Config.EMPTY;

public class ConfigParser extends ConfigLoader {

    public static final String CONFIG_DELIMITER = "=";
    public static final String NEW_LINE = "\n";
    public static final String LEFT_OVER = "\r";
    public static final int CONFIG_TYPE_INDEX = 0;
    public static final int CONFIG_VALUE_INDEX = 1;

    protected static HashMap<String, String> parseConfigString(String configString) {
        String[] configLines = configString.split(NEW_LINE);
        HashMap<String, String> configMap = new HashMap<>();
        for (String line : configLines) {
            handleConfigLine(line, configMap);
        }
        return configMap;
    }

    private static void handleConfigLine(String line, HashMap<String, String> configMap) {
        String[] splitLine = line.split(CONFIG_DELIMITER);
        String configType = splitLine[CONFIG_TYPE_INDEX];
        String configValue = splitLine[CONFIG_VALUE_INDEX];
        configValue = configValue.replace(LEFT_OVER, EMPTY);
        configMap.put(configType, configValue);
    }
}
