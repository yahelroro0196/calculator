package CalculatorTesting.TestTypes.EdgeCases.PostfixToResultCases;

import ShuntingYardCalculator.Calculator.CalculationSteps.PostfixToResult;
import ShuntingYardCalculator.Type;
import javafx.util.Pair;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.InputMismatchException;

import static CalculatorTesting.TestParser.parseEquationString;
import static org.junit.Assert.assertThrows;

public class DoubleOperator {
    private static ArrayList<Pair<String, Type>> doubleOperatorInput;
    private static Class<InputMismatchException> doubleOperatorOutput;

    @Test
    public void test() {
        assertThrows(doubleOperatorOutput, () ->
                PostfixToResult.postfixToResult(doubleOperatorInput));
    }

    @Before
    public void setup() {
        inputSetup();
        outputSetup();
    }

    private void outputSetup() {
        doubleOperatorOutput = InputMismatchException.class;
    }

    private void inputSetup() {
        doubleOperatorInput = new ArrayList<>();
        doubleOperatorInput = parseEquationString("/ /");
    }

    @After
    public void finalize_tests() {
        doubleOperatorInput.clear();
        doubleOperatorOutput = null;
    }
}
