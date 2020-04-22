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

public class EquationEnd {
    public static String EQUATION_END_INPUT;
    private static String EQUATION_END_PREVIOUS_INPUT;
    private static ArrayList<Pair<String, Type>> EQUATION_END_EQUATION;
    private static ArrayList<String> VALID_OPERATORS = ConfigSpecificParser.
            parseValidOperators(ConfigLoader.loadConfig(CONFIG_PATH).get(VALID_OPERATORS_CONFIG));
    private static Type EQUATION_END_OUTPUT;

    @Test
    public void test() {
        assertEquals(EQUATION_END_OUTPUT, CalculatorLogic.determineInput(VALID_OPERATORS, EQUATION_END_PREVIOUS_INPUT,
                EQUATION_END_INPUT, EQUATION_END_EQUATION));
    }

    @Before
    public void setup() {
        inputSetup();
        outputSetup();
    }

    private void outputSetup() {
        EQUATION_END_OUTPUT = Type.EQUATION_END;
    }

    private void inputSetup() {
        EQUATION_END_EQUATION = new ArrayList<>();
        EQUATION_END_EQUATION = parseEquationString("5 + 5");
        EQUATION_END_PREVIOUS_INPUT = PLACE_HOLDER;
        EQUATION_END_INPUT = EMPTY;
    }

    @After
    public void finalizeTests() {
        EQUATION_END_EQUATION.clear();
        EQUATION_END_OUTPUT = null;
    }
}
