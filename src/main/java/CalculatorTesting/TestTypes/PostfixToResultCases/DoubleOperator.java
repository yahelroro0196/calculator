package CalculatorTesting.TestTypes.PostfixToResultCases;

import ShuntingYardCalculator.Calculator.CalculationSteps.PostfixToResult;
import ShuntingYardCalculator.Type;
import javafx.util.Pair;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.InputMismatchException;

import static ShuntingYardCalculator.Calculator.EquationParser.parseEquationString;
import static org.junit.Assert.assertThrows;

public class DoubleOperator {
    private static ArrayList<Pair<String, Type>> DOUBLE_OPERATOR_INPUT;
    private static Class<InputMismatchException> DOUBLE_OPERATOR_OUTPUT;

    @Test
    public void test() {
        assertThrows(DOUBLE_OPERATOR_OUTPUT, () ->
                PostfixToResult.postfixToResult(DOUBLE_OPERATOR_INPUT));
    }

    @Before
    public void setup() {
        inputSetup();
        outputSetup();
    }

    private void outputSetup() {
        DOUBLE_OPERATOR_OUTPUT = InputMismatchException.class;
    }

    private void inputSetup() {
        DOUBLE_OPERATOR_INPUT = new ArrayList<>();
        DOUBLE_OPERATOR_INPUT = parseEquationString("/ /");
    }

    @After
    public void finalize_tests() {
        DOUBLE_OPERATOR_INPUT.clear();
        DOUBLE_OPERATOR_OUTPUT = null;
    }
}
