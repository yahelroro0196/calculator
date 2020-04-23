package CalculatorTesting;

import ShuntingYardCalculator.Calculator.CalculationSteps.InfixToPostfix;
import ShuntingYardCalculator.Enums.Type;
import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static CalculatorTesting.TestingParsers.ParsePostfixString.parse;
import static ShuntingYardCalculator.Calculator.EquationParser.parseEquationString;
import static ShuntingYardCalculator.ExceptionType.EMPTY_BRACKETS_ERROR;

public class InfixToPostfixTests {
    @Test
    public void complexDoubleBracketsChallenge() {
        ArrayList<Pair<String, Type>> complexDoubleInput = parseEquationString("5+((5+5)*5)");
        ArrayList<Pair<String, Type>> complexDoubleExpected = parse("5 5 5 + 5 * +");

        ArrayList<Pair<String, Type>> complexDoubleOutput = InfixToPostfix.infixToPostfix(complexDoubleInput);

        Assert.assertEquals(complexDoubleExpected, complexDoubleOutput);
    }

    @Test
    public void doubleEmptyBracketsWarning() {
        ArrayList<Pair<String, Type>> doubleEmptyInput = parseEquationString("(())");

        try {
            InfixToPostfix.infixToPostfix(doubleEmptyInput);
        } catch (ArithmeticException e) {
            Assert.assertEquals(e.getMessage(), EMPTY_BRACKETS_ERROR);
        }
    }

    @Test
    public void complexEquationChallenge() {
        ArrayList<Pair<String, Type>> complexDoubleInput = parseEquationString("%5*5^(10+2)");
        ArrayList<Pair<String, Type>> complexDoubleExpected = parse("5 5 * 10 2 + ^ %");

        ArrayList<Pair<String, Type>> complexDoubleOutput = InfixToPostfix.infixToPostfix(complexDoubleInput);

        Assert.assertEquals(complexDoubleExpected, complexDoubleOutput);
    }
}
