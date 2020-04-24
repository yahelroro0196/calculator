package ShuntingYardCalculator.Calculator.InputFlow;

import ShuntingYardCalculator.Enums.Type;

import java.util.ArrayList;

import static ShuntingYardCalculator.Config.Config.VALID_FUNCTIONS;
import static ShuntingYardCalculator.Config.Config.VALID_OPERATORS;

public class InputValidator {
    private final static String EMPTY_INPUT = "";

    public static Type isValidInput(String input) {
        if (isOperand(input))
            return Type.OPERAND;
        else if (VALID_OPERATORS.contains(input))
            return Type.OPERATOR;
        else if (input.equals(EMPTY_INPUT))
            return Type.EQUATION_END;
        else if (VALID_FUNCTIONS.contains(input))
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
