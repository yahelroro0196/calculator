package CalculatorTesting.TestTypes.IsValidInputCases;

import ShuntingYardCalculator.Type;
import javafx.util.Pair;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static ShuntingYardCalculator.Calculator.EquationParser.parseEquationString;
import static ShuntingYardCalculator.Calculator.InputFlow.InputValidator.isValidInput;
import static ShuntingYardCalculator.Config.Config.*;
import static org.junit.Assert.assertEquals;

public class Operand {
    public static String OPERAND_INPUT;
    private static ArrayList<Pair<String, Type>> OPERAND_EQUATION;
    private static Type OPERAND_OUTPUT;

    @Test
    public void test() {
        assertEquals(OPERAND_OUTPUT, isValidInput(OPERAND_INPUT, VALID_OPERATORS, VALID_FUNCTIONS));
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
        OPERAND_EQUATION = parseEquationString("5+5");
        OPERAND_INPUT = PLACE_HOLDER_OPERAND;
    }

    @After
    public void finalizeTests() {
        OPERAND_EQUATION.clear();
        OPERAND_OUTPUT = null;
    }
}
