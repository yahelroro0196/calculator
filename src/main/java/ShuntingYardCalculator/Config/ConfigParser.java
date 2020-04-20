package ShuntingYardCalculator.Config;

import java.util.ArrayList;
import java.util.Arrays;

public class ConfigParser extends ConfigLoader {

    public static final String OPERATOR_DELIMITER = ",";

    protected static ArrayList<String> parseValidOperatorsString(String validOperatorsText) {
        String[] validOperatorsArray = validOperatorsText.split(OPERATOR_DELIMITER);
        return new ArrayList<>(Arrays.asList(validOperatorsArray));
    }
}
