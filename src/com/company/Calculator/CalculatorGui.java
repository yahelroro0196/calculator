package com.company.Calculator;

import com.company.Pair;

import java.util.*;

import static com.company.Calculator.CalculatorLogic.*;
import static com.company.Constants.EQUATION_END;
import static com.company.Constants.INVALID_INPUT;

public class CalculatorGui {

    public static final String PLACE_HOLDER_INPUT = "0";
    public static final String NEW_LINE = "\n";

    public static void menu(ArrayList<String> validOperators) {
        ArrayList<Pair<String, String>> equation = new ArrayList<>();
        boolean calculatorLoop = true;
        String previousInput = PLACE_HOLDER_INPUT;
        String input;
        while (calculatorLoop) {
            displayMenu(validOperators);
            input = receiveInput();
            String inputResult = determineInput(validOperators, previousInput, input, equation);
            equation = determineInputResult(equation, inputResult);
        }
    }

    private static ArrayList<Pair<String, String>> determineInputResult(ArrayList<Pair<String, String>> equation,
                                                                        String result) {
        switch (result) {
            case INVALID_INPUT:
                displayInvalidInput();
            case EQUATION_END:
                displayResult(equation);
                equation = resetEquation(equation);
        }
        return equation;
    }

    public static void displayInvalidInput() {
        System.out.println("Invalid Input! Enter an input again.");
    }

    public static void displayMenu(ArrayList<String> validOperators) {
        System.out.println("Welcome to the calculator!");
        displayInputStructure();
        displayValidOperators(validOperators);
    }

    private static void displayValidOperators(ArrayList<String> validOperators) {
        System.out.printf("The valid operators you can use are:  %s" + NEW_LINE, validOperators);
    }

    private static void displayInputStructure() {
        System.out.println("Type an operator/operand and hit enter.");
        System.out.println("One per line, enter empty input twice to exit program");
    }

    private static void displayResult(ArrayList<Pair<String, String>> equation) {
        try {
            System.out.printf("Equation result is: %s" + NEW_LINE, calculate(equation));
        } catch (Exception invalidEquation) {
            System.out.println(invalidEquation);
        }
    }

    public static ArrayList<Pair<String, String>> resetEquation(ArrayList<Pair<String, String>> equation) {
        return new ArrayList<>();
    }
}
