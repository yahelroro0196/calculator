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

public class EquationEnd {
    public static final String EQUATION_END_INPUT = "";
    private static final String EQUATION_END_PREVIOUS_INPUT = "_";
    private static final String CONFIG_PATH = ".\\src\\main\\resources\\ValidOperators.properties";
    private static ArrayList<Pair<String, Type>> EQUATION_END_EQUATION;
    private static ArrayList<String> VALID_OPERATORS = ConfigLoader.loadConfig(CONFIG_PATH);
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
    }

    @After
    public void finalize_tests() {
        EQUATION_END_EQUATION.clear();
        EQUATION_END_OUTPUT = null;
    }
}
