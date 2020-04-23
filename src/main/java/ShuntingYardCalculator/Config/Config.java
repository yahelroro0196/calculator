package ShuntingYardCalculator.Config;

import java.util.ArrayList;

public class Config {
    public static final String RELATIVE_FILE_PATHS = ".\\src\\main\\resources\\";
    public static final String CONFIG_PATH = "ValidOperators.properties";
    public static final String SPACE = " ";
    public static final String EMPTY = "";
    public static final String PLACE_HOLDER_OPERAND = "1";
    public static final String PLACE_HOLDER_OPERATOR = "+";
    public static final String JSON_END = ".json";
    public static final String VALID_OPERATORS_CONFIG = "Valid_Operators";
    public static final String VALID_FUNCTIONS_CONFIG = "Valid_Functions";
    public static final ArrayList<String> VALID_OPERATORS = ConfigSpecificParser
            .parseCommaSeparatedConfig(ConfigLoader.loadConfig(RELATIVE_FILE_PATHS + CONFIG_PATH)
                    .get(VALID_OPERATORS_CONFIG));
    public static final ArrayList<String> VALID_FUNCTIONS = ConfigSpecificParser
            .parseCommaSeparatedConfig(ConfigLoader.loadConfig(RELATIVE_FILE_PATHS + CONFIG_PATH)
                    .get(VALID_FUNCTIONS_CONFIG));

}
