package ShuntingYardCalculator.Calculator.CalculationSteps;

import ShuntingYardCalculator.Calculator.Functions.Function;
import ShuntingYardCalculator.Calculator.Functions.FunctionFactory;
import ShuntingYardCalculator.Calculator.Operators.Operator;
import ShuntingYardCalculator.Calculator.Operators.OperatorFactory;
import ShuntingYardCalculator.Enums.Type;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Stack;

import static ShuntingYardCalculator.ExceptionType.INVALID_EQUATION_ERROR;

public class PostfixToResult {
    public static final String PLUS = "+";

    public static double postfixToResult(ArrayList<Pair<String, Type>> equation) throws InputMismatchException,
            ArithmeticException {
        double result;
        Stack<Pair<String, Type>> operandStack = new Stack<>();
        for (Pair<String, Type> currPair : equation) {
            if (currPair.getValue().equals(Type.OPERAND)) {
                operandStack.push(currPair);
            } else if (currPair.getValue().equals(Type.OPERATOR) && operandStack.isEmpty()) {
                throw new InputMismatchException(INVALID_EQUATION_ERROR);
            } else if (currPair.getValue().equals(Type.FUNCTION)) {
                calculateFunction(operandStack, currPair);
            } else {
                calculateNumberPairs(operandStack, currPair);
            }
        }
        while (operandStack.size() > 1) {
            calculateNumberPairs(operandStack, new Pair<>(PLUS, Type.OPERATOR));
        }
        result = Double.parseDouble(operandStack.pop().getKey());
        return result;
    }

    private static void calculateNumberPairs(Stack<Pair<String, Type>> operandStack,
                                             Pair<String, Type> currPair) throws ArithmeticException {
        String operatorText = currPair.getKey();
        double rightOperand = Double.parseDouble(operandStack.pop().getKey());
        double leftOperand = Double.parseDouble(operandStack.pop().getKey());
        Operator operator = new OperatorFactory().factory(operatorText);
        double calculationResult = operator.calculateOperator(leftOperand, rightOperand);
        Pair<String, Type> calculationPair = new Pair<>(String.valueOf(calculationResult), Type.OPERAND);
        operandStack.push(calculationPair);
    }

    private static void calculateFunction(Stack<Pair<String, Type>> operandStack,
                                          Pair<String, Type> currPair) {
        String functionSymbol = currPair.getKey();
        double operand = Double.parseDouble(operandStack.pop().getKey());
        Function function = new FunctionFactory().factory(functionSymbol);
        double calculationResult = function.calculateFunction(operand);
        Pair<String, Type> calculationPair = new Pair<>(String.valueOf(calculationResult), Type.OPERAND);
        operandStack.push(calculationPair);
    }
}
