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

public class DoubleBrackets {
    private static ArrayList<Pair<String, Type>> doubleBracketsInput;
    private static ArrayList<Pair<String, Type>> doubleBracketsOutput;

    @Test
    public void test() {
        assertEquals(doubleBracketsOutput, InfixToPostfix.infixToPostfix(doubleBracketsInput));
    }

    @Before
    public void setup() {
        inputSetup();
        outputSetup();
    }

    private void outputSetup() {
        doubleBracketsOutput = new ArrayList<>();
        doubleBracketsOutput = parseEquationString("5 5 5 + 5 * +");
    }

    private void inputSetup() {
        doubleBracketsInput = new ArrayList<>();
        doubleBracketsInput = parseEquationString("5 + ( ( 5 + 5 ) * 5 )");
    }

    @After
    public void finalize_tests() {
        doubleBracketsInput.clear();
        doubleBracketsOutput.clear();
    }
}
