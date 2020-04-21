package CalculatorTesting.EdgeCases;

import ShuntingYardCalculator.Config.ConfigLoader;
import ShuntingYardCalculator.Type;
import javafx.util.Pair;

import java.util.ArrayList;

import static ShuntingYardCalculator.Calculator.InputFlow.InputValidator.isValidInput;

public class TestParser {
    private static final String PLACE_HOLDER = "_";
    private static final String CONFIG_PATH = ".\\src\\main\\resources\\ValidOperators.properties";
    private static final ArrayList<String> VALID_OPERATORS = ConfigLoader.loadConfig(CONFIG_PATH);


    public static ArrayList<Pair<String, Type>> parseEquationString(String equationText) {
        ArrayList<Pair<String, Type>> equation = new ArrayList<>();
        for (int i = 0; i < equationText.length(); i++) {
            char character = equationText.charAt(i);
            Type inputType = isValidInput(PLACE_HOLDER, String.valueOf(character), VALID_OPERATORS);
            equation.add(new Pair<>(String.valueOf(character), inputType));
        }
        return equation;
    }
}
