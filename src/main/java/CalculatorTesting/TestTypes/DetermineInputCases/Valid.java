package CalculatorTesting.TestTypes.DetermineInputCases;

import ShuntingYardCalculator.Calculator.CalculatorLogic;
import ShuntingYardCalculator.Config.ConfigLoader;
import ShuntingYardCalculator.Type;
import javafx.util.Pair;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static CalculatorTesting.TestParser.parseEquationString;
import static ShuntingYardCalculator.Config.Config.CONFIG_PATH;
import static ShuntingYardCalculator.Config.Config.PLACE_HOLDER_OPERAND;
import static org.junit.Assert.assertEquals;

public class Valid {
    public static String VALID_INPUT;
    private static String VALID_PREVIOUS_INPUT;
    private static ArrayList<Pair<String, Type>> VALID_EQUATION;
    private static ArrayList<String> VALID_OPERATORS = ConfigLoader.loadConfig(CONFIG_PATH);
    private static Type VALID_OUTPUT;

    @Test
    public void test() {
        assertEquals(VALID_OUTPUT, CalculatorLogic.determineInput(VALID_OPERATORS, VALID_PREVIOUS_INPUT,
                VALID_INPUT, VALID_EQUATION));
    }

    @Before
    public void setup() {
        inputSetup();
        outputSetup();
    }

    private void outputSetup() {
        VALID_OUTPUT = Type.VALID_INPUT;
    }

    private void inputSetup() {
        VALID_EQUATION = new ArrayList<>();
        VALID_EQUATION = parseEquationString("5 + 5");
        VALID_INPUT = PLACE_HOLDER_OPERAND;
        VALID_PREVIOUS_INPUT = PLACE_HOLDER_OPERAND;
    }

    @After
    public void finalizeTests() {
        VALID_EQUATION.clear();
        VALID_OUTPUT = null;
    }
}
