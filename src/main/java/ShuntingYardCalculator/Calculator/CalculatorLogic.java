package ShuntingYardCalculator.Calculator;

import ShuntingYardCalculator.Calculator.CalculationSteps.InfixToPostfix;
import ShuntingYardCalculator.Pair;
import ShuntingYardCalculator.Type;

import java.util.ArrayList;
import java.util.InputMismatchException;

import static ShuntingYardCalculator.Calculator.CalculationSteps.PostfixToResult.postfixToResult;
import static ShuntingYardCalculator.Calculator.InputFlow.InputBuilder.buildInput;

public class CalculatorLogic {
    public static double calculate(ArrayList<Pair<String, Type>> equation) throws InputMismatchException,
            ArithmeticException {
        ArrayList<Pair<String, Type>> postfixEquation = InfixToPostfix.infixToPostfix(equation);
        return postfixToResult(postfixEquation);
    }

    public static Type determineInput(ArrayList<String> validOperators, String previousInput, String input,
                                      ArrayList<Pair<String, Type>> equation) {
        buildInput(equation, previousInput, input, validOperators);
        Pair<String, Type> lastEntry = equation.get(equation.size() - 1);
        switch (lastEntry.getType()) {
            case INVALID_INPUT:
                equation.remove(equation.size() - 1);
                return Type.INVALID_INPUT;
            case EQUATION_END:
                equation.remove(equation.size() - 1);
                return Type.EQUATION_END;
            case EXIT:
                return Type.EXIT;
        }
        return Type.VALID_INPUT;
    }

    public static ArrayList<Pair<String, Type>> resetEquation() {
        return new ArrayList<>();
    }
}
