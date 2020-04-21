package CalculatorTesting.EdgeCases.InfixToPostfixCases;

import ShuntingYardCalculator.Calculator.CalculationSteps.InfixToPostfix;
import ShuntingYardCalculator.Type;
import javafx.util.Pair;

import java.util.ArrayList;

import static CalculatorTesting.EdgeCases.TestParser.parseEquationString;
import static org.junit.Assert.assertEquals;

public class DoubleBrackets {
    private static ArrayList<Pair<String, Type>> doubleBracketsInput;
    private static ArrayList<Pair<String, Type>> doubleBracketsOutput;

    public static void test() {
        assertEquals(doubleBracketsOutput, InfixToPostfix.infixToPostfix(doubleBracketsInput));
    }

    public static void setup() {
        inputSetup();
        outputSetup();
    }

    public static void outputSetup() {
        doubleBracketsOutput = new ArrayList<>();
        doubleBracketsOutput = parseEquationString("555+5*+");
    }

    public static void inputSetup() {
        doubleBracketsInput = new ArrayList<>();
        doubleBracketsInput = parseEquationString("5+((5+5)*5)");
    }

    public static void finalize_tests() {
        doubleBracketsInput.clear();
        doubleBracketsOutput.clear();
    }
}
