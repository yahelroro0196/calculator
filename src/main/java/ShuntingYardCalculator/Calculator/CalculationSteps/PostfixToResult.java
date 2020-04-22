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
        double rightOperand = Double.parseDouble(operandStack.pop().getKey());
        double leftOperand = Double.parseDouble(operandStack.pop().getKey());
        String operatorText = currPair.getKey();
        Operator operator = new OperatorFactory().factory(operatorText);
        double calculationResult = operator.calculateOperator(leftOperand, rightOperand);
        Pair<String, Type> calculationPair = new Pair<>(String.valueOf(calculationResult), Type.OPERAND);
        operandStack.push(calculationPair);
    }
}
