package ShuntingYardCalculator.Config;

import java.util.ArrayList;
import java.util.Arrays;

public class ConfigParser extends ConfigLoader {

    public static final String OPERATOR_DELIMITER = ",";
    public static final int VALID_OPERATORS_INDEX = 16;

    protected static ArrayList<String> parseValidOperatorsString(String validOperatorsText) {
        String validOperatorsOnlyText = validOperatorsText.substring(VALID_OPERATORS_INDEX);
        String[] validOperatorsArray = validOperatorsOnlyText.split(OPERATOR_DELIMITER);
        return new ArrayList<>(Arrays.asList(validOperatorsArray));
    }
}
