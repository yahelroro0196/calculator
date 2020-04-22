package CalculatorTesting.TestTypes.EdgeCases.DetermineInputCases;

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

public class InvalidInput {
    public static final String invalidInput_Input = "~";
    private static final String CONFIG_PATH = ".\\src\\main\\resources\\ValidOperators.properties";
    private static final String previousInput_Input = "_";
    private static ArrayList<Pair<String, Type>> invalidInputEquation;
    private static ArrayList<String> validOperators = ConfigLoader.loadConfig(CONFIG_PATH);
    private static Type invalidInput_Output;

    @Test
    public void test() {
        assertEquals(invalidInput_Output, CalculatorLogic.determineInput(validOperators, previousInput_Input,
                invalidInput_Input, invalidInputEquation));
    }

    @Before
    public void setup() {
        inputSetup();
        outputSetup();
    }

    private void outputSetup() {
        invalidInput_Output = Type.INVALID_INPUT;
    }

    private void inputSetup() {
        invalidInputEquation = new ArrayList<>();
        invalidInputEquation = parseEquationString("5 + 5");
    }

    @After
    public void finalize_tests() {
        invalidInputEquation.clear();
        invalidInput_Output = null;
    }
}
