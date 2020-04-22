package ShuntingYardCalculator.Calculator;

import ShuntingYardCalculator.Config.ConfigLoader;
import ShuntingYardCalculator.Config.ConfigSpecificParser;
import ShuntingYardCalculator.Type;
import javafx.util.Pair;

import java.util.ArrayList;

import static ShuntingYardCalculator.Calculator.InputFlow.InputBuilder.buildInput;
import static ShuntingYardCalculator.Config.Config.*;

public class EquationParser {
    private static final ArrayList<String> VALID_OPERATORS = ConfigSpecificParser.
            parseValidOperators(ConfigLoader.loadConfig(CONFIG_PATH).get(VALID_OPERATORS_CONFIG));

    public static ArrayList<Pair<String, Type>> parseEquationString(String equationText)
            throws ArithmeticException {
        String[] splitEquation = equationText.split(SPACE);
        ArrayList<Pair<String, Type>> equation = new ArrayList<>();
        for (String token : splitEquation) {
            buildInput(equation, token, VALID_OPERATORS);
        }
        return equation;
    }
}
