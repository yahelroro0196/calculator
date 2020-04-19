package com.company.Calculator;

import com.company.Pair;

import java.util.*;

public class CalculatorLogic {


    public static double calculate(ArrayList<Pair<String, String>> equation) {
        ArrayList<Pair<String, String>> postfixEquation = infixToPostfix(equation);
        System.out.println(postfixEquation);
        return 0.0;
    }

    private static ArrayList<Pair<String, String>> infixToPostfix(ArrayList<Pair<String, String>> equation) {
        ArrayList<Pair<String, String>> postfixEquation = new ArrayList<>();
        Stack<Pair<String, String>> operatorStack = new Stack<>();
        for (int i = 0; i < equation.size(); i++) {
            Pair<String, String> currentToken = equation.get(i);
            if (equation.get(i).getRight().equals("Operand"))  {
                postfixEquation.add(new Pair<>(currentToken.getLeft(), currentToken.getRight()));
            } else {
                operatorStack.push(new Pair<>(currentToken.getLeft(), currentToken.getRight()));
            }
        }
        while (!operatorStack.isEmpty()) {
            postfixEquation.add(operatorStack.pop());
        }
        return postfixEquation;
    }
}
