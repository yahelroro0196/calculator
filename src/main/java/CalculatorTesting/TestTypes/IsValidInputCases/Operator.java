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
import static ShuntingYardCalculator.Config.Config.*;
import static org.junit.Assert.assertEquals;

public class Operator {
    public static String OPERATOR_INPUT;
    private static String OPERATOR_PREVIOUS_INPUT;
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
        OPERATOR_INPUT = PLACE_HOLDER_OPERATOR;
        OPERATOR_PREVIOUS_INPUT = PLACE_HOLDER_OPERAND;
    }

    @After
    public void finalizeTests() {
        OPERATOR_EQUATION.clear();
        OPERATOR_OUTPUT = null;
    }
}
