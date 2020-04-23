package CalculatorTesting.TestTypes.InfixToPostfixCases;

import ShuntingYardCalculator.Calculator.CalculationSteps.InfixToPostfix;
import ShuntingYardCalculator.Enums.Type;
import javafx.util.Pair;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static ShuntingYardCalculator.Calculator.EquationParser.parseEquationString;
import static org.junit.Assert.assertThrows;

public class DoubleEmptyBrackets {
    private static ArrayList<Pair<String, Type>> DOUBLE_EMPTY_BRACKETS_INPUT;
    private static Class<ArithmeticException> DOUBLE_EMPTY_BRACKETS_OUTPUT;

    @Test
    public void test() {
        assertThrows(DOUBLE_EMPTY_BRACKETS_OUTPUT, () ->
                InfixToPostfix.infixToPostfix(DOUBLE_EMPTY_BRACKETS_INPUT));
    }

    @Before
    public void setup() {
        inputSetup();
        outputSetup();
    }

    private void outputSetup() {
        DOUBLE_EMPTY_BRACKETS_OUTPUT = ArithmeticException.class;
    }

    private void inputSetup() {
        DOUBLE_EMPTY_BRACKETS_INPUT = new ArrayList<>();
        DOUBLE_EMPTY_BRACKETS_INPUT = parseEquationString("()");
    }

    @After
    public void finalizeTests() {
        DOUBLE_EMPTY_BRACKETS_INPUT.clear();
        DOUBLE_EMPTY_BRACKETS_OUTPUT = null;
    }
}
