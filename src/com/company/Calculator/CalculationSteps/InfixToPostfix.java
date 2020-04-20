package com.company.Calculator.CalculationSteps;

import com.company.Calculator.Operators.Operator;
import com.company.Calculator.Operators.OperatorFactory;
import com.company.Pair;

import java.util.ArrayList;
import java.util.Stack;

import static com.company.Constants.OPERATOR;

public class InfixToPostfix {
    public static final String L_BRACKET = "(";
    public static final String R_BRACKET = ")";

    public static ArrayList<Pair<String, String>> infixToPostfix(ArrayList<Pair<String, String>> equation) {
        ArrayList<Pair<String, String>> postfixEquation = new ArrayList<>();
        Stack<Pair<String, String>> operatorStack = new Stack<>();
        for (Pair<String, String> currPair : equation) {
            if (currPair.getType().equals(OPERATOR)) {
                insertOperatorByPrecedence(postfixEquation, operatorStack, currPair);
            } else if (currPair.getValue().equals(L_BRACKET)) {
                operatorStack.push(currPair);
            } else if (currPair.getValue().equals(R_BRACKET)) {
                insertBracketsPart(postfixEquation, operatorStack);
            } else {
                postfixEquation.add(currPair);
            }
        }
        insertRemainingOperators(postfixEquation, operatorStack);
        return postfixEquation;
    }

    private static void insertOperatorByPrecedence(ArrayList<Pair<String, String>> postfixEquation,
                                                   Stack<Pair<String, String>> operatorStack,
                                                   Pair<String, String> currPair) {
        while (!operatorStack.isEmpty() && isHigherPrecedence(currPair.getValue(), operatorStack.peek().getValue())) {
            postfixEquation.add(operatorStack.pop());
        }
        operatorStack.push(currPair);
    }

    private static void insertRemainingOperators(ArrayList<Pair<String, String>> postfixEquation,
                                                 Stack<Pair<String, String>> operatorStack) {
        while (!operatorStack.isEmpty()) {
            postfixEquation.add(operatorStack.pop());
        }
    }

    private static void insertBracketsPart(ArrayList<Pair<String, String>> postfixEquation,
                                           Stack<Pair<String, String>> operatorStack) {
        while (!operatorStack.peek().getValue().equals(L_BRACKET)) {
            postfixEquation.add(operatorStack.pop());
        }
        operatorStack.pop();
    }

    private static boolean isHigherPrecedence(String operatorText, String subOperatorText) {
        Operator operator = new OperatorFactory().factory(operatorText);
        Operator subOperator = new OperatorFactory().factory(operatorText);
        return (subOperator.getPrecedence() >= operator.getPrecedence());
    }
}
