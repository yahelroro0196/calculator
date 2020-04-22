package CalculatorTesting.TestTypes.EdgeCases.InfixToPostfixCases;

import ShuntingYardCalculator.Calculator.CalculationSteps.InfixToPostfix;
import ShuntingYardCalculator.Type;
import javafx.util.Pair;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static CalculatorTesting.TestParser.parseEquationString;
import static org.junit.Assert.assertEquals;

public class ComplexEquation {
    private static ArrayList<Pair<String, Type>> doubleEmptyBracketsInput;
    private static ArrayList<Pair<String, Type>> doubleEmptyBracketsOutput;

    @Test
    public void test() {
        assertEquals(doubleEmptyBracketsOutput, InfixToPostfix.infixToPostfix(doubleEmptyBracketsInput));
    }

    @Before
    public void setup() {
        inputSetup();
        outputSetup();
    }

    private void outputSetup() {
        doubleEmptyBracketsOutput = new ArrayList<>();
        doubleEmptyBracketsOutput = parseEquationString("5 8 ^ 5 1 * / 10 +");
    }

    private void inputSetup() {
        doubleEmptyBracketsInput = new ArrayList<>();
        doubleEmptyBracketsInput = parseEquationString("5 ^ 8 / ( 5 * 1 ) + 10");
    }

    @After
    public void finalize_tests() {
        doubleEmptyBracketsInput.clear();
        doubleEmptyBracketsOutput = null;
    }
}
