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

public class Exit {
    public static final String EXIT_INPUT = "";
    private static final String EXIT_PREVIOUS_INPUT = Type.EQUATION_END.name();
    private static final String CONFIG_PATH = ".\\src\\main\\resources\\ValidOperators.properties";
    private static ArrayList<Pair<String, Type>> EXIT_EQUATION;
    private static ArrayList<String> VALID_OPERATORS = ConfigLoader.loadConfig(CONFIG_PATH);
    private static Type EXIT_OUTPUT;

    @Test
    public void test() {
        assertEquals(EXIT_OUTPUT, CalculatorLogic.determineInput(VALID_OPERATORS, EXIT_PREVIOUS_INPUT,
                EXIT_INPUT, EXIT_EQUATION));
    }

    @Before
    public void setup() {
        inputSetup();
        outputSetup();
    }

    private void outputSetup() {
        EXIT_OUTPUT = Type.EXIT;
    }

    private void inputSetup() {
        EXIT_EQUATION = new ArrayList<>();
        EXIT_EQUATION = parseEquationString("5 + 5");
    }

    @After
    public void finalize_tests() {
        EXIT_EQUATION.clear();
        EXIT_OUTPUT = null;
    }
}
