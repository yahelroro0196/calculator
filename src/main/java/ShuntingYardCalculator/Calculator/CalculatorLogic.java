package ShuntingYardCalculator.Calculator;

import ShuntingYardCalculator.Calculator.CalculationSteps.InfixToPostfix;
import ShuntingYardCalculator.Type;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.InputMismatchException;

import static ShuntingYardCalculator.Calculator.CalculationSteps.PostfixToResult.postfixToResult;

public class CalculatorLogic {
    public static double calculate(ArrayList<Pair<String, Type>> equation) throws InputMismatchException,
            ArithmeticException {
        ArrayList<Pair<String, Type>> postfixEquation = InfixToPostfix.infixToPostfix(equation);
        System.out.println(postfixEquation);
        return postfixToResult(postfixEquation);
    }

    public static ArrayList<Pair<String, Type>> resetEquation() {
        return new ArrayList<>();
    }
}
