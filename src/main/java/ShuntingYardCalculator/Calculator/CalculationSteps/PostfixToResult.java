package ShuntingYardCalculator.Calculator.CalculationSteps;

import ShuntingYardCalculator.Calculator.Operators.Operator;
import ShuntingYardCalculator.Calculator.Operators.OperatorFactory;
import ShuntingYardCalculator.Type;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Stack;

import static ShuntingYardCalculator.ExceptionType.INVALID_EQUATION_ERROR;

public class PostfixToResult {
    private static final String[] trigoOperators = {"$", "%"};

    public static double postfixToResult(ArrayList<Pair<String, Type>> equation) throws InputMismatchException,
            ArithmeticException {
        Stack<Pair<String, Type>> operandStack = new Stack<>();
        double result;
        for (Pair<String, Type> currPair : equation) {
            if (currPair.getValue().equals(Type.OPERAND)) {
                operandStack.push(currPair);
            } else if (currPair.getValue().equals(Type.OPERATOR) && operandStack.isEmpty()) {
                throw new InputMismatchException(INVALID_EQUATION_ERROR);
            } else {
                PostfixToResult.calculateNumberPairs(operandStack, currPair);
            }
        }
        result = Double.parseDouble(operandStack.pop().getKey());
        return result;
    }

    private static void calculateNumberPairs(Stack<Pair<String, Type>> operandStack,
                                             Pair<String, Type> currPair) throws ArithmeticException {
        String operatorText = currPair.getKey();
        double rightOperand, leftOperand;
        if (isTrigoFunction(operatorText)) {
            rightOperand = handleTrigoFunctions(operandStack, currPair);
            leftOperand = rightOperand;
        } else {
            rightOperand = Double.parseDouble(operandStack.pop().getKey());
            leftOperand = Double.parseDouble(operandStack.pop().getKey());
        }
        Operator operator = new OperatorFactory().factory(operatorText);
        double calculationResult = operator.calculateOperator(leftOperand, rightOperand);
        Pair<String, Type> calculationPair = new Pair<>(String.valueOf(calculationResult), Type.OPERAND);
        operandStack.push(calculationPair);
    }

    private static double handleTrigoFunctions(Stack<Pair<String, Type>> operandStack,
                                               Pair<String, Type> currPair) {
        double operand = Double.parseDouble(operandStack.pop().getKey());
        return operand / 2;
    }

    private static boolean isTrigoFunction(String operatorText) {
        for (String operator : trigoOperators)
            if (operatorText.equals(operator))
                return true;
        return false;
    }
}
