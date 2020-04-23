package ShuntingYardCalculator.Calculator.InputFlow;

import ShuntingYardCalculator.Enums.Type;

import java.util.ArrayList;

public class InputValidator {
    private final static String EMPTY_INPUT = "";

    public static Type isValidInput(String input, ArrayList<String> validOperators,
                                    ArrayList<String> validFunctions) {
        if (isOperand(input))
            return Type.OPERAND;
        else if (validOperators.contains(input))
            return Type.OPERATOR;
        else if (input.equals(EMPTY_INPUT))
            return Type.EQUATION_END;
        else if (validFunctions.contains(input))
            return Type.FUNCTION;
        else
            return Type.INVALID_INPUT;
    }

    private static boolean isOperand(String input) {
        if (input.equals(EMPTY_INPUT))
            return false;
        try {
            Double d = Double.parseDouble(input);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
