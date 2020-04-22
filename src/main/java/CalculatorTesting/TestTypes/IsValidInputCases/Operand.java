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
import static org.junit.Assert.assertEquals;

public class Operand {
    public static final String OPERAND_INPUT = "5";
    private static final String OPERAND_PREVIOUS_INPUT = "6";
    private static final String CONFIG_PATH = ".\\src\\main\\resources\\ValidOperators.properties";
    private static ArrayList<Pair<String, Type>> OPERAND_EQUATION;
    private static ArrayList<String> VALID_OPERATORS = ConfigLoader.loadConfig(CONFIG_PATH);
    private static Type OPERAND_OUTPUT;

    @Test
    public void test() {
        assertEquals(OPERAND_OUTPUT, isValidInput(OPERAND_PREVIOUS_INPUT, OPERAND_INPUT, VALID_OPERATORS));
    }

    @Before
    public void setup() {
        inputSetup();
        outputSetup();
    }

    private void outputSetup() {
        OPERAND_OUTPUT = Type.OPERAND;
    }

    private void inputSetup() {
        OPERAND_EQUATION = new ArrayList<>();
        OPERAND_EQUATION = parseEquationString("5 + 5");
    }

    @After
    public void finalize_tests() {
        OPERAND_EQUATION.clear();
        OPERAND_OUTPUT = null;
    }
}
