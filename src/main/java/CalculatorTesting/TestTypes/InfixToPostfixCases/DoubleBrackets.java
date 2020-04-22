package CalculatorTesting.TestTypes.InfixToPostfixCases;

import ShuntingYardCalculator.Calculator.CalculationSteps.InfixToPostfix;
import ShuntingYardCalculator.Type;
import javafx.util.Pair;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static ShuntingYardCalculator.Calculator.EquationParser.parseEquationString;
import static org.junit.Assert.assertEquals;

public class DoubleBrackets {
    private static ArrayList<Pair<String, Type>> DOUBLE_BRACKETS_INPUT;
    private static ArrayList<Pair<String, Type>> DOUBLE_BRACKETS_OUTPUT;

    @Test
    public void test() {
        assertEquals(DOUBLE_BRACKETS_OUTPUT, InfixToPostfix.infixToPostfix(DOUBLE_BRACKETS_INPUT));
    }

    @Before
    public void setup() {
        inputSetup();
        outputSetup();
    }

    private void outputSetup() {
        DOUBLE_BRACKETS_OUTPUT = new ArrayList<>();
        DOUBLE_BRACKETS_OUTPUT = parseEquationString("5 5 5 + 5 * +");
    }

    private void inputSetup() {
        DOUBLE_BRACKETS_INPUT = new ArrayList<>();
        DOUBLE_BRACKETS_INPUT = parseEquationString("5 + ( ( 5 + 5 ) * 5 )");
    }

    @After
    public void finalizeTests() {
        DOUBLE_BRACKETS_INPUT.clear();
        DOUBLE_BRACKETS_OUTPUT.clear();
    }
}
