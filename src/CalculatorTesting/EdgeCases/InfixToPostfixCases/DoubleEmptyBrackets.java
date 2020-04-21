package CalculatorTesting.EdgeCases.InfixToPostfixCases;

import ShuntingYardCalculator.Calculator.CalculationSteps.InfixToPostfix;
import ShuntingYardCalculator.Type;
import javafx.util.Pair;

import java.util.ArrayList;

import static CalculatorTesting.EdgeCases.TestParser.parseEquationString;
import static org.junit.Assert.assertThrows;

public class DoubleEmptyBrackets {
    private static ArrayList<Pair<String, Type>> doubleEmptyBracketsInput;
    private static Class<ArithmeticException> doubleEmptyBracketsOutput;

    public static void test() {
        Exception exception = assertThrows(doubleEmptyBracketsOutput, () ->
                InfixToPostfix.infixToPostfix(doubleEmptyBracketsInput));
    }

    public static void setup() {
        inputSetup();
        outputSetup();
    }

    public static void outputSetup() {
        doubleEmptyBracketsOutput = ArithmeticException.class;
    }

    public static void inputSetup() {
        doubleEmptyBracketsInput = new ArrayList<>();
        doubleEmptyBracketsInput = parseEquationString("()");
    }

    public static void finalize_tests() {
        doubleEmptyBracketsInput.clear();
        doubleEmptyBracketsOutput = null;
    }
}
