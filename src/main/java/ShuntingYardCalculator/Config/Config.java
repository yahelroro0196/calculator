package ShuntingYardCalculator.Config;

import java.util.ArrayList;

public class Config {
    public static final String RELATIVE_PATH_PREFIX = ".\\src\\main\\resources\\";
    public static final String CONFIG_PATH = "ValidOperators.properties";
    public static final String SPACE = " ";
    public static final String EMPTY = "";
    public static final String PLACE_HOLDER_OPERAND = "1";
    public static final String PLACE_HOLDER_OPERATOR = "+";
    public static final String L_BRACKET = "(";
    public static final String R_BRACKET = ")";
    public static final String EQUATIONS_FILE_EXTENSION = ".txt";
    public static final String VALID_OPERATORS_CONFIG = "Valid_Operators";
    public static final String VALID_FUNCTIONS_CONFIG = "Valid_Functions";
    public static final ArrayList<String> VALID_OPERATORS = ConfigSpecificParser
            .parseCommaSeparatedConfig(
                    ConfigParser.parseConfigString(
                            ConfigLoader.streamFileLoader(RELATIVE_PATH_PREFIX + CONFIG_PATH))
                            .get(VALID_OPERATORS_CONFIG));
    public static final ArrayList<String> VALID_FUNCTIONS = ConfigSpecificParser
            .parseCommaSeparatedConfig(
                    ConfigParser.parseConfigString(
                            ConfigLoader.streamFileLoader(RELATIVE_PATH_PREFIX + CONFIG_PATH))
                            .get(VALID_FUNCTIONS_CONFIG));
}
