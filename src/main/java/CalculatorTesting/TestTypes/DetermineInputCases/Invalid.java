package CalculatorTesting.TestTypes.DetermineInputCases;

import ShuntingYardCalculator.Calculator.CalculatorLogic;
import ShuntingYardCalculator.Config.ConfigLoader;
import ShuntingYardCalculator.Config.ConfigSpecificParser;
import ShuntingYardCalculator.Type;
import javafx.util.Pair;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static CalculatorTesting.TestParser.parseEquationString;
import static ShuntingYardCalculator.Config.Config.*;
import static org.junit.Assert.assertEquals;

public class Invalid {
    public static String INVALID_INPUT;
    private static String INVALID_PREVIOUS_INPUT;
    private static ArrayList<Pair<String, Type>> INVALID_EQUATION;
    private static ArrayList<String> VALID_OPERATORS = ConfigSpecificParser.
            parseValidOperators(ConfigLoader.loadConfig(CONFIG_PATH).get(VALID_OPERATORS_CONFIG));
    private static Type INVALID_OUTPUT;

    @Test
    public void test() {
        assertEquals(INVALID_OUTPUT, CalculatorLogic.determineInput(VALID_OPERATORS, INVALID_PREVIOUS_INPUT,
                INVALID_INPUT, INVALID_EQUATION));
    }

    @Before
    public void setup() {
        inputSetup();
        outputSetup();
    }

    private void outputSetup() {
        INVALID_OUTPUT = Type.INVALID_INPUT;
    }

    private void inputSetup() {
        INVALID_EQUATION = new ArrayList<>();
        INVALID_EQUATION = parseEquationString("5 + 5");
        INVALID_INPUT = PLACE_HOLDER;
        INVALID_PREVIOUS_INPUT = PLACE_HOLDER;
    }

    @After
    public void finalizeTests() {
        INVALID_EQUATION.clear();
        INVALID_OUTPUT = null;
    }
}
