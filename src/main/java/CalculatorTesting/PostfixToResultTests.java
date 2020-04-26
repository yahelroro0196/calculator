package CalculatorTesting;

import ShuntingYardCalculator.Calculator.CalculationSteps.PostfixToResult;
import ShuntingYardCalculator.Enums.Type;
import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.InputMismatchException;

import static CalculatorTesting.TestingParsers.ParsePostfixString.parse;

public class PostfixToResultTests {
    @Test
    public void complexEquationChallenge() {
        double complexEquationExpected = 0.999926248642623;
        ArrayList<Pair<String, Type>> complexEquationInput = parse("8 s 5 * c");

        double complexEquationOutput = PostfixToResult.postfixToResult(complexEquationInput);

        Assert.assertEquals(complexEquationExpected, complexEquationOutput, 0.01);
    }

    @Test(expected = InputMismatchException.class)
    public void doubleOperatorInputMismatch() {
        ArrayList<Pair<String, Type>> doubleOperatorInput = parse("/ /");

        PostfixToResult.postfixToResult(doubleOperatorInput);
    }
}
