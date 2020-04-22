package ShuntingYardCalculator.Config;

import java.util.ArrayList;

public class Config {
    public static final String CONFIG_PATH = ".\\src\\main\\resources\\ValidOperators.properties";
    public static final String SPACE = " ";
    public static final String EMPTY = "";
    public static final String PLACE_HOLDER_OPERAND = "1";
    public static final String PLACE_HOLDER_OPERATOR = "+";
    public static final String VALID_OPERATORS_CONFIG = "Valid_Operators";
    public static final String VALID_FUNCTIONS_CONFIG = "Valid_Functions";
    public static final ArrayList<String> VALID_OPERATORS = ConfigSpecificParser
            .parseValidOperators(ConfigLoader.loadConfig(CONFIG_PATH).get(VALID_OPERATORS_CONFIG));
    public static final ArrayList<String> VALID_FUNCTIONS = ConfigSpecificParser
            .parseValidOperators(ConfigLoader.loadConfig(CONFIG_PATH).get(VALID_FUNCTIONS_CONFIG));

}
