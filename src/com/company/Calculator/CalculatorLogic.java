package com.company.Calculator;

import com.company.Calculator.CalculationSteps.InfixToPostfix;
import com.company.Pair;

import java.util.ArrayList;
import java.util.Scanner;

import static com.company.Calculator.CalculationSteps.PostfixToResult.postfixToResult;
import static com.company.Calculator.InputBuilder.buildInput;
import static com.company.Constants.*;

public class CalculatorLogic {


    public static final String VALID_INPUT = "ValidInput";

    public static double calculate(ArrayList<Pair<String, String>> equation) throws Exception {
        ArrayList<Pair<String, String>> postfixEquation = InfixToPostfix.infixToPostfix(equation);
        return postfixToResult(postfixEquation);
    }

    public static String determineInput(ArrayList<String> validOperators, String previousInput, String input,
                                        ArrayList<Pair<String, String>> equation) {
        buildInput(equation, previousInput, input, validOperators);
        Pair<String, String> lastEntry = equation.get(equation.size() - 1);
        switch (lastEntry.getType()) {
            case INVALID_INPUT:
                equation.remove(equation.size() - 1);
                return INVALID_INPUT;
            case EQUATION_END:
                equation.remove(equation.size() - 1);
                return EQUATION_END;
            case EXIT:
                return EXIT;
        }
        return VALID_INPUT;
    }

    public static String receiveInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static ArrayList<Pair<String, String>> resetEquation(ArrayList<Pair<String, String>> equation) {
        return new ArrayList<>();
    }

    public static boolean isExitCalculator(String previousResult) {
        return previousResult.equals(EXIT);
    }
}
