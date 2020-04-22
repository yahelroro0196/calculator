package CalculatorTesting.TestTypes.PostfixToResultCases;

import ShuntingYardCalculator.Calculator.CalculationSteps.PostfixToResult;
import ShuntingYardCalculator.Type;
import javafx.util.Pair;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static ShuntingYardCalculator.Calculator.EquationParser.parseEquationString;
import static org.junit.Assert.assertEquals;

public class ComplexEquation {
    private static ArrayList<Pair<String, Type>> COMPLEX_EQUATION_INPUT;
    private static double COMPLEX_EQUATION_OUTPUT;

    @Test
    public void test() {
        assertEquals(COMPLEX_EQUATION_OUTPUT, PostfixToResult.postfixToResult(COMPLEX_EQUATION_INPUT), 0.01);
    }

    @Before
    public void setup() {
        inputSetup();
        outputSetup();
    }

    private void outputSetup() {
        COMPLEX_EQUATION_OUTPUT = 78135;
    }

    private void inputSetup() {
        COMPLEX_EQUATION_INPUT = new ArrayList<>();
        COMPLEX_EQUATION_INPUT = parseEquationString("5 8 ^ 5 1 * / 10 +");
    }

    @After
    public void finalize_tests() {
        COMPLEX_EQUATION_INPUT.clear();
        COMPLEX_EQUATION_OUTPUT = 0;
    }
}
