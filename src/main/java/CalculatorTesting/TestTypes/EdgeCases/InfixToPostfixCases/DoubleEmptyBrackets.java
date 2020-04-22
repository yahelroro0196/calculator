package CalculatorTesting.TestTypes.EdgeCases.InfixToPostfixCases;

import ShuntingYardCalculator.Calculator.CalculationSteps.InfixToPostfix;
import ShuntingYardCalculator.Type;
import javafx.util.Pair;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static CalculatorTesting.TestParser.parseEquationString;
import static org.junit.Assert.assertThrows;

public class DoubleEmptyBrackets {
    private static ArrayList<Pair<String, Type>> doubleEmptyBracketsInput;
    private static Class<ArithmeticException> doubleEmptyBracketsOutput;

    @Test
    public void test() {
        assertThrows(doubleEmptyBracketsOutput, () ->
                InfixToPostfix.infixToPostfix(doubleEmptyBracketsInput));
    }

    @Before
    public void setup() {
        inputSetup();
        outputSetup();
    }

    private void outputSetup() {
        doubleEmptyBracketsOutput = ArithmeticException.class;
    }

    private void inputSetup() {
        doubleEmptyBracketsInput = new ArrayList<>();
        doubleEmptyBracketsInput = parseEquationString("( )");
    }

    @After
    public void finalize_tests() {
        doubleEmptyBracketsInput.clear();
        doubleEmptyBracketsOutput = null;
    }
}
