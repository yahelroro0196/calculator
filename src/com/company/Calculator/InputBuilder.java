package com.company.Calculator;

import com.company.Pair;

import java.util.ArrayList;
import java.util.Map;

import static com.company.Calculator.InputValidator.isValidInput;

public class InputBuilder {
    public static void buildInput(ArrayList<Pair<String, String>> equation, String previousInput,
                                  String input, ArrayList<String> validOperators) {
        String isValidInputResult = isValidInput(previousInput, input, validOperators);
        equation.add(new Pair<>(input, isValidInputResult));
    }
}
