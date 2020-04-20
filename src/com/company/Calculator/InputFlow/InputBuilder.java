package com.company.Calculator.InputFlow;

import com.company.Pair;

import java.util.ArrayList;

import static com.company.Calculator.InputFlow.InputValidator.isValidInput;

public class InputBuilder {
    public static void buildInput(ArrayList<Pair<String, String>> equation, String previousInput,
                                  String input, ArrayList<String> validOperators) {
        String isValidInputResult = isValidInput(previousInput, input, validOperators);
        equation.add(new Pair<>(input, isValidInputResult));
    }
}
