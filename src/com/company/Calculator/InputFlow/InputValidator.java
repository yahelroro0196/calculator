package com.company.Calculator.InputFlow;

import java.util.ArrayList;

import static com.company.Constants.EQUATION_END;

public class InputValidator {

    public static final String EMPTY_INPUT = "";

    public static String isValidInput(String previousInput, String input, ArrayList<String> validOperators) {
        if (isOperand(input)) {
            return "Operand";
        } else if (isOperator(input, validOperators)) {
            return "Operator";
        } else if (isExit(previousInput, input)) {
            return "Exit";
        } else if (isEndOfEquation(input)) {
            return "EquationEnd";
        } else {
            return "InvalidInput";
        }
    }

    private static boolean isOperand(String input) {
        if (input.equals(EMPTY_INPUT)) {
            return false;
        }
        try {
            Double d = Double.parseDouble(input);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private static boolean isOperator(String input, ArrayList<String> validOperators) {
        return validOperators.contains(input);
    }

    private static boolean isEndOfEquation(String input) {
        return input.equals(EMPTY_INPUT);
    }

    private static boolean isExit(String previousInput, String input) {
        return previousInput.equals(EQUATION_END) && input.equals(EMPTY_INPUT);
    }
}
