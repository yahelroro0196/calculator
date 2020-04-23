package CalculatorTesting;

import ShuntingYardCalculator.Calculator.CalculationSteps.PostfixToResult;
import ShuntingYardCalculator.Enums.Type;
import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.InputMismatchException;

import static CalculatorTesting.TestingParsers.ParsePostfixString.parse;
import static ShuntingYardCalculator.ExceptionType.INVALID_EQUATION_ERROR;

public class PostfixToResultTests {
    @Test
    public void complexEquationChallenge() {
        double complexEquationExpected = 0.23226162615901796;
        ArrayList<Pair<String, Type>> complexEquationInput = parse("5 8 $ * %");

        double complexEquationOutput = PostfixToResult.postfixToResult(complexEquationInput);

        Assert.assertEquals(complexEquationExpected, complexEquationOutput, 0.01);
    }

    @Test
    public void doubleOperatorInputMismatch() {
        ArrayList<Pair<String, Type>> doubleOperatorInput = parse("/ /");

        try {
            PostfixToResult.postfixToResult(doubleOperatorInput);
        } catch (InputMismatchException e) {
            Assert.assertEquals(e.getMessage(), INVALID_EQUATION_ERROR);
        }
    }
}
