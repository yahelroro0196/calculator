package com.company.Calculator;

import com.company.Calculator.Operators.Operator;
import com.company.Calculator.Operators.OperatorFactory;
import com.company.Pair;

import java.util.*;

import static com.company.Calculator.InputBuilder.buildInput;
import static com.company.Constants.*;

public class CalculatorLogic {


    public static final String VALID_INPUT = "ValidInput";
    public static final String L_BRACKET = "(";
    public static final String R_BRACKET = ")";

    public static double calculate(ArrayList<Pair<String, String>> equation) throws Exception {
        ArrayList<Pair<String, String>> postfixEquation = infixToPostfix(equation);
        return postfixToResult(postfixEquation);
    }

    public static String determineInput(ArrayList<String> validOperators, String previousInput, String input,
                                        ArrayList<Pair<String, String>> equation) {
        buildInput(equation, previousInput, input, validOperators);
        Pair<String, String> lastEntry = equation.get(equation.size() - 1);
        if (lastEntry.getType().equals(INVALID_INPUT)) {
            equation.remove(equation.size() - 1);
            return INVALID_INPUT;
        } else if (lastEntry.getType().equals(EQUATION_END)) {
            equation.remove(equation.size() - 1);
            return EQUATION_END;
        }
        return VALID_INPUT;
    }

    private static ArrayList<Pair<String, String>> infixToPostfix(ArrayList<Pair<String, String>> equation) {
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

    private static void insertOperatorByPrecedence(ArrayList<Pair<String, String>> postfixEquation,
                                                   Stack<Pair<String, String>> operatorStack,
                                                   Pair<String, String> currPair) {
        while (!operatorStack.isEmpty() && isHigherPrecedence(currPair.getValue(), operatorStack.peek().getValue())) {
            postfixEquation.add(operatorStack.pop());
        }
        operatorStack.push(currPair);
    }

    private static boolean isHigherPrecedence(String operatorText, String subOperatorText) {
        Operator operator = new OperatorFactory().factory(operatorText);
        Operator subOperator = new OperatorFactory().factory(operatorText);
        return (subOperator.getPrecedence() >= operator.getPrecedence());
    }

    private static double postfixToResult(ArrayList<Pair<String, String>> equation) throws Exception {
        Stack<Pair<String, String>> operandStack = new Stack<>();
        double result;
        for (Pair<String, String> currPair : equation) {
            if (currPair.getType().equals(OPERAND)) {
                operandStack.push(currPair);
            } else {
                if (operandStack.isEmpty() && currPair.getType().equals(OPERATOR)) {
                    throw new Exception("Invalid equation, retry!");
                } else {
                    calculateNumberPairs(operandStack, currPair);
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
        Pair<String, String> calculationPair = new Pair<>(String.valueOf(calculationResult), "Operand");
        operandStack.push(calculationPair);
    }

    public static String receiveInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
