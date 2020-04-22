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

public class Valid {
    public static final String VALID_INPUT = "5";
    private static final String VALID_PREVIOUS_INPUT = "6";
    private static final String CONFIG_PATH = ".\\src\\main\\resources\\ValidOperators.properties";
    private static ArrayList<Pair<String, Type>> validEquation;
    private static ArrayList<String> validOperators = ConfigLoader.loadConfig(CONFIG_PATH);
    private static Type validOutput;

    @Test
    public void test() {
        assertEquals(validOutput, CalculatorLogic.determineInput(validOperators, VALID_PREVIOUS_INPUT,
                VALID_INPUT, validEquation));
    }

    @Before
    public void setup() {
        inputSetup();
        outputSetup();
    }

    private void outputSetup() {
        validOutput = Type.VALID_INPUT;
    }

    private void inputSetup() {
        validEquation = new ArrayList<>();
        validEquation = parseEquationString("5 + 5");
    }

    @After
    public void finalize_tests() {
        validEquation.clear();
        validOutput = null;
    }
}
