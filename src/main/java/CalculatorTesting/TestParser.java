package CalculatorTesting;

import ShuntingYardCalculator.Config.ConfigLoader;
import ShuntingYardCalculator.Config.ConfigSpecificParser;
import ShuntingYardCalculator.Type;
import javafx.util.Pair;

import java.util.ArrayList;

import static ShuntingYardCalculator.Calculator.InputFlow.InputValidator.isValidInput;
import static ShuntingYardCalculator.Config.Config.*;

public class TestParser {
    private static final ArrayList<String> VALID_OPERATORS = ConfigSpecificParser.
            parseValidOperators(ConfigLoader.loadConfig(CONFIG_PATH).get(VALID_OPERATORS_CONFIG));

    public static ArrayList<Pair<String, Type>> parseEquationString(String equationText) {
        String[] equationChars = equationText.split(SPACE);
        ArrayList<Pair<String, Type>> equation = new ArrayList<>();
        for (String character : equationChars) {
            Type inputType = isValidInput(PLACE_HOLDER, String.valueOf(character), VALID_OPERATORS);
            equation.add(new Pair<>(String.valueOf(character), inputType));
        }
        return equation;
    }
}
