package CalculatorTesting.TestTypes.IsValidInputCases;

import ShuntingYardCalculator.Config.ConfigLoader;
import ShuntingYardCalculator.Type;
import javafx.util.Pair;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static CalculatorTesting.TestParser.parseEquationString;
import static ShuntingYardCalculator.Calculator.InputFlow.InputValidator.isValidInput;
import static org.junit.Assert.assertEquals;

public class Operator {
    public static final String OPERATOR_INPUT = "+";
    private static final String OPERATOR_PREVIOUS_INPUT = "6";
    private static final String CONFIG_PATH = ".\\src\\main\\resources\\ValidOperators.properties";
    private static ArrayList<Pair<String, Type>> OPERATOR_EQUATION;
    private static ArrayList<String> VALID_OPERATORS = ConfigLoader.loadConfig(CONFIG_PATH);
    private static Type OPERATOR_OUTPUT;

    @Test
    public void test() {
        assertEquals(OPERATOR_OUTPUT, isValidInput(OPERATOR_PREVIOUS_INPUT, OPERATOR_INPUT, VALID_OPERATORS));
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
        OPERATOR_EQUATION = parseEquationString("5 + 5");
    }

    @After
    public void finalize_tests() {
        OPERATOR_EQUATION.clear();
        OPERATOR_OUTPUT = null;
    }
}
