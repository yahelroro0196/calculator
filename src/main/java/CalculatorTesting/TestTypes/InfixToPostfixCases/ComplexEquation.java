package CalculatorTesting.TestTypes.InfixToPostfixCases;

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
    private static ArrayList<Pair<String, Type>> COMPLEX_EQUATION_INPUT;
    private static ArrayList<Pair<String, Type>> COMPLEX_EQUATION_OUTPUT;

    @Test
    public void test() {
        assertEquals(COMPLEX_EQUATION_OUTPUT, InfixToPostfix.infixToPostfix(COMPLEX_EQUATION_INPUT));
    }

    @Before
    public void setup() {
        inputSetup();
        outputSetup();
    }

    private void outputSetup() {
        COMPLEX_EQUATION_OUTPUT = new ArrayList<>();
        COMPLEX_EQUATION_OUTPUT = parseEquationString("5 8 ^ 5 1 * / 10 +");
    }

    private void inputSetup() {
        COMPLEX_EQUATION_INPUT = new ArrayList<>();
        COMPLEX_EQUATION_INPUT = parseEquationString("5 ^ 8 / ( 5 * 1 ) + 10");
    }

    @After
    public void finalizeTests() {
        COMPLEX_EQUATION_INPUT.clear();
        COMPLEX_EQUATION_OUTPUT = null;
    }
}
