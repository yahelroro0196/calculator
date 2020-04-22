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
import static org.junit.Assert.assertEquals;

public class Invalid {
    public static final String INVALID_INPUT = "~";
    private static final String INVALID_PREVIOUS_INPUT = "_";
    private static final String CONFIG_PATH = ".\\src\\main\\resources\\ValidOperators.properties";
    private static ArrayList<Pair<String, Type>> INVALID_EQUATION;
    private static ArrayList<String> VALID_OPERATORS = ConfigLoader.loadConfig(CONFIG_PATH);
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
    }

    @After
    public void finalize_tests() {
        INVALID_EQUATION.clear();
        INVALID_OUTPUT = null;
    }
}
