package EdgeCases;

import ShuntingYardCalculator.Calculator.CalculationSteps.InfixToPostfix;
import ShuntingYardCalculator.Type;
import javafx.util.Pair;
import static org.junit.Assert.assertEquals;


import java.util.ArrayList;

public class InfixToPostfixCases {

    private static ArrayList<Pair<String, Type>> infixToPostfixInput;
    private static ArrayList<Pair<String, Type>> infixToPostfixOutput;

    public static void doubleBrackets() {
        assertEquals(infixToPostfixOutput, InfixToPostfix.infixToPostfix(infixToPostfixInput));
    }

    public static void outputSetup() {
        infixToPostfixOutput = new ArrayList<>();
        infixToPostfixOutput.add(new Pair<>("5", Type.OPERAND));
        infixToPostfixOutput.add(new Pair<>("5", Type.OPERAND));
        infixToPostfixOutput.add(new Pair<>("5", Type.OPERAND));
        infixToPostfixOutput.add(new Pair<>("+", Type.OPERATOR));
        infixToPostfixOutput.add(new Pair<>("5", Type.OPERAND));
        infixToPostfixOutput.add(new Pair<>("*", Type.OPERATOR));
        infixToPostfixOutput.add(new Pair<>("+", Type.OPERATOR));
    }

    public static void inputSetup() {
        infixToPostfixInput = new ArrayList<>();
        infixToPostfixInput.add(new Pair<>("5", Type.OPERAND));
        infixToPostfixInput.add(new Pair<>("+", Type.OPERATOR));
        infixToPostfixInput.add(new Pair<>("(", Type.OPERATOR));
        infixToPostfixInput.add(new Pair<>("(", Type.OPERATOR));
        infixToPostfixInput.add(new Pair<>("5", Type.OPERAND));
        infixToPostfixInput.add(new Pair<>("+", Type.OPERATOR));
        infixToPostfixInput.add(new Pair<>("5", Type.OPERAND));
        infixToPostfixInput.add(new Pair<>(")", Type.OPERATOR));
        infixToPostfixInput.add(new Pair<>("*", Type.OPERATOR));
        infixToPostfixInput.add(new Pair<>("5", Type.OPERAND));
        infixToPostfixInput.add(new Pair<>(")", Type.OPERATOR));
    }

    public static void finalize_tests() {
        infixToPostfixInput.clear();
        infixToPostfixOutput.clear();
    }
}
