package ShuntingYardCalculator.Calculator.InputFlow;

import ShuntingYardCalculator.Type;

import java.util.ArrayList;

public class InputValidator {

    private final static String EMPTY_INPUT = "";

    public static Type isValidInput(String previousInput, String input, ArrayList<String> validOperators) {
        if (isOperand(input)) {
            return Type.OPERAND;
        } else if (validOperators.contains(input)) {
            return Type.OPERATOR;
        } else if (isExit(previousInput, input)) {
            return Type.EXIT;
        } else if (input.equals(EMPTY_INPUT)) {
            return Type.EQUATION_END;
        } else {
            return Type.INVALID_INPUT;
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
    private static boolean isExit(String previousInput, String input) {
        return previousInput.equals(Type.EQUATION_END.name()) && input.equals(EMPTY_INPUT);
    }
}
