package CalculatorTesting.TestTypes.IsValidInputCases;

import ShuntingYardCalculator.Config.ConfigLoader;
import ShuntingYardCalculator.Config.ConfigSpecificParser;
import ShuntingYardCalculator.Type;
import javafx.util.Pair;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static ShuntingYardCalculator.Calculator.EquationParser.parseEquationString;
import static ShuntingYardCalculator.Calculator.InputFlow.InputValidator.isValidInput;
import static ShuntingYardCalculator.Config.Config.*;
import static org.junit.Assert.assertEquals;

public class Operator {
    public static String OPERATOR_INPUT;
    private static ArrayList<Pair<String, Type>> OPERATOR_EQUATION;
    private static ArrayList<String> VALID_OPERATORS = ConfigSpecificParser.
            parseValidOperators(ConfigLoader.loadConfig(CONFIG_PATH).get(VALID_OPERATORS_CONFIG));
    private static final ArrayList<String> VALID_FUNCTIONS = ConfigSpecificParser
            .parseValidOperators(ConfigLoader.loadConfig(CONFIG_PATH).get(VALID_FUNCTIONS_CONFIG));

    private static Type OPERATOR_OUTPUT;

    @Test
    public void test() {
        assertEquals(OPERATOR_OUTPUT, isValidInput(OPERATOR_INPUT, VALID_OPERATORS, VALID_FUNCTIONS));
    }

    @Before
    public void setup() {
        inputSetup();
        outputSetup();
    }

    private void outputSetup() {
        OPERATOR_OUTPUT = Type.OPERATOR;
    }

    private void inputSetup() {
        OPERATOR_EQUATION = new ArrayList<>();
        OPERATOR_EQUATION = parseEquationString("5+5");
        OPERATOR_INPUT = PLACE_HOLDER_OPERATOR;
    }

    @After
    public void finalizeTests() {
        OPERATOR_EQUATION.clear();
        OPERATOR_OUTPUT = null;
    }
}
