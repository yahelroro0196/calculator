package ShuntingYardCalculator.Calculator.CalculationSteps;

import ShuntingYardCalculator.Calculator.Operators.Operator;
import ShuntingYardCalculator.Calculator.Operators.OperatorFactory;
import ShuntingYardCalculator.Type;
import ShuntingYardCalculator.Pair;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Stack;

public class PostfixToResult {
    public static double postfixToResult(ArrayList<Pair<String, Type>> equation) throws InputMismatchException {
        Stack<Pair<String, Type>> operandStack = new Stack<>();
        double result;
        for (Pair<String, Type> currPair : equation) {
            if (currPair.getType().equals(Type.OPERAND)) {
                operandStack.push(currPair);
            } else if (currPair.getType().equals(Type.OPERATOR) && operandStack.isEmpty()) {
                throw new InputMismatchException("Invalid equation, reenter the equation!");
            } else {
                PostfixToResult.calculateNumberPairs(operandStack, currPair);
            }
        }
        result = Double.parseDouble(operandStack.pop().getValue());
        return result;
    }

    private static void calculateNumberPairs(Stack<Pair<String, Type>> operandStack,
                                             Pair<String, Type> currPair) {
        double rightOperand = Double.parseDouble(operandStack.pop().getValue());
        double leftOperand = Double.parseDouble(operandStack.pop().getValue());
        String operatorText = currPair.getValue();
        Operator operator = new OperatorFactory().factory(operatorText);
        double calculationResult = operator.calculateOperator(leftOperand, rightOperand);
        Pair<String, Type> calculationPair = new Pair<>(String.valueOf(calculationResult), Type.OPERAND);
        operandStack.push(calculationPair);
    }
}
