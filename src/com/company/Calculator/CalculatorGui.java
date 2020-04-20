package com.company.Calculator;

import com.company.Pair;

import java.util.*;

import static com.company.Calculator.CalculatorLogic.*;
import static com.company.Constants.*;

public class CalculatorGui {

    private static final String NEW_LINE = "\n";

    public static void menu(ArrayList<String> validOperators) {
        ArrayList<Pair<String, String>> equation = new ArrayList<>();
        String previousResult = PLACE_HOLDER_INPUT;
        String input;
        while (!isExitCalculator(previousResult)) {
            displayMenu(validOperators);
            input = receiveInput();
            String inputResult = determineInput(validOperators, previousResult, input, equation);
            equation = determineInputResult(equation, previousResult, inputResult);
            previousResult = inputResult;
        }
    }

    private static ArrayList<Pair<String, String>> determineInputResult(ArrayList<Pair<String, String>> equation,
                                                                        String previousResult, String result) {
        switch (result) {
            case INVALID_INPUT:
                displayInvalidInput();
                break;
            case EQUATION_END:
                equation = equationEndCase(equation, previousResult);
                break;
        }
        return equation;
    }

    private static ArrayList<Pair<String, String>> equationEndCase(ArrayList<Pair<String, String>> equation,
                                                                   String previousResult) {
        if (!equation.isEmpty()) {
            displayResult(equation);
            equation = resetEquation(equation);
        }
        return equation;
    }

    private static void displayEmptyEquation() {
        System.out.println("Empty equation!");
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
}
