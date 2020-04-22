package CalculatorTesting.TestTypes.EdgeCases.PostfixToResultCases;

import ShuntingYardCalculator.Calculator.CalculationSteps.PostfixToResult;
import ShuntingYardCalculator.Type;
import javafx.util.Pair;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static CalculatorTesting.TestParser.parseEquationString;
import static org.junit.Assert.assertEquals;

public class ComplexEquation {
    private static ArrayList<Pair<String, Type>> complexEquationInput;
    private static double complexEquationOutput;

    @Test
    public void test() {
        assertEquals(complexEquationOutput, PostfixToResult.postfixToResult(complexEquationInput), 0.01);
    }

    @Before
    public void setup() {
        inputSetup();
        outputSetup();
    }

    private void outputSetup() {
        complexEquationOutput = 78135;
    }

    private void inputSetup() {
        complexEquationInput = new ArrayList<>();
        complexEquationInput = parseEquationString("5 8 ^ 5 1 * / 10 +");
    }

    @After
    public void finalize_tests() {
        complexEquationInput.clear();
        complexEquationOutput = 0;
    }
}
