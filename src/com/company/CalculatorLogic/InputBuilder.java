package com.company.CalculatorLogic;

import java.util.ArrayList;
import java.util.Map;

import static com.company.CalculatorLogic.InputValidator.isValidInput;

public class InputBuilder {
    public static void buildInput(Map<String, String> equation, String previousInput,
                                                 String input, ArrayList<String> validOperators) {
        String isValidInputResult = isValidInput(previousInput, input, validOperators);
        equation.put(input, isValidInputResult);
    }
}
