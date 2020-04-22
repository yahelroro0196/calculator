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

public class Exit {
    public static String EXIT_INPUT;
    private static String EXIT_PREVIOUS_INPUT;
    private static ArrayList<Pair<String, Type>> EXIT_EQUATION;
    private static ArrayList<String> VALID_OPERATORS = ConfigSpecificParser.
            parseValidOperators(ConfigLoader.loadConfig(CONFIG_PATH).get(VALID_OPERATORS_CONFIG));
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
        EXIT_INPUT = EMPTY;
        EXIT_PREVIOUS_INPUT = Type.EQUATION_END.name();
    }

    @After
    public void finalizeTests() {
        EXIT_EQUATION.clear();
        EXIT_OUTPUT = null;
    }
}
