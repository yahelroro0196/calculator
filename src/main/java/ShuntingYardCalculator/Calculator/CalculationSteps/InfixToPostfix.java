package ShuntingYardCalculator.Calculator.CalculationSteps;

import ShuntingYardCalculator.Calculator.Operators.Operator;
import ShuntingYardCalculator.Calculator.Operators.OperatorFactory;
import ShuntingYardCalculator.Type;
import ShuntingYardCalculator.Pair;

import java.util.ArrayList;
import java.util.Stack;

public class InfixToPostfix {
    public static final String L_BRACKET = "(";
    public static final String R_BRACKET = ")";

    public static ArrayList<Pair<String, Type>> infixToPostfix(ArrayList<Pair<String, Type>> equation) {
        ArrayList<Pair<String, Type>> postfixEquation = new ArrayList<>();
        Stack<Pair<String, Type>> operatorStack = new Stack<>();
        for (Pair<String, Type> currPair : equation) {
            if (currPair.getType().equals(Type.OPERATOR)) {
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

    private static void insertOperatorByPrecedence(ArrayList<Pair<String, Type>> postfixEquation,
                                                   Stack<Pair<String, Type>> operatorStack,
                                                   Pair<String, Type> currPair) {
        while (!operatorStack.isEmpty() && isHigherPrecedence(currPair.getValue(), operatorStack.peek().getValue())) {
            postfixEquation.add(operatorStack.pop());
        }
        operatorStack.push(currPair);
    }

    private static void insertRemainingOperators(ArrayList<Pair<String, Type>> postfixEquation,
                                                 Stack<Pair<String, Type>> operatorStack) {
        while (!operatorStack.isEmpty()) {
            postfixEquation.add(operatorStack.pop());
        }
    }

    private static void insertBracketsPart(ArrayList<Pair<String, Type>> postfixEquation,
                                           Stack<Pair<String, Type>> operatorStack) {
        while (!operatorStack.peek().getValue().equals(L_BRACKET)) {
            postfixEquation.add(operatorStack.pop());
        }
        operatorStack.pop();
    }

    private static boolean isHigherPrecedence(String operatorText, String subOperatorText) {
        OperatorFactory operatorFactory = new OperatorFactory();
        Operator operator = operatorFactory.factory(operatorText);
        Operator subOperator = operatorFactory.factory(subOperatorText);
        return (subOperator.getPrecedence() >= operator.getPrecedence());
    }
}
