package ShuntingYardCalculator.Config;

import java.util.ArrayList;
import java.util.Arrays;

public class ConfigSpecificParser {
    public static final String OPERATOR_DELIMITER = ",";

    public static ArrayList<String> parseValidOperators(String validOperators) {
        String[] splitOperators = validOperators.split(OPERATOR_DELIMITER);
        return new ArrayList<>(Arrays.asList(splitOperators));
    }
}
