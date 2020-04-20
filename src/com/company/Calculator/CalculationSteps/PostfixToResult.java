package com.company.Calculator.CalculationSteps;

import com.company.Calculator.Operators.Operator;
import com.company.Calculator.Operators.OperatorFactory;
import com.company.Pair;

import java.util.ArrayList;
import java.util.Stack;

import static com.company.Constants.OPERAND;
import static com.company.Constants.OPERATOR;

public class PostfixToResult {
    public static double postfixToResult(ArrayList<Pair<String, String>> equation) throws Exception {
        Stack<Pair<String, String>> operandStack = new Stack<>();
        double result;
        for (Pair<String, String> currPair : equation) {
            if (currPair.getType().equals(OPERAND)) {
                operandStack.push(currPair);
            } else {
                if (operandStack.isEmpty() && currPair.getType().equals(OPERATOR)) {
                    throw new Exception("Invalid equation, retry!");
                } else {
                    PostfixToResult.calculateNumberPairs(operandStack, currPair);
                }
            }
        }
        result = Double.parseDouble(operandStack.pop().getValue());
        return result;
    }

    private static void calculateNumberPairs(Stack<Pair<String, String>> operandStack,
                                            Pair<String, String> currPair) {
        double rightOperand = Double.parseDouble(operandStack.pop().getValue());
        double leftOperand = Double.parseDouble(operandStack.pop().getValue());
        String operatorText = currPair.getValue();
        Operator operator = new OperatorFactory().factory(operatorText);
        double calculationResult = operator.calculateOperator(leftOperand, rightOperand);
        Pair<String, String> calculationPair = new Pair<>(String.valueOf(calculationResult), OPERAND);
        operandStack.push(calculationPair);
    }
}
