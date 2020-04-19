package com.company.CalculatorLogic;
import java.util.*;

import static com.company.CalculatorLogic.InputBuilder.buildInput;

public class CalculatorGui {

    public static final String PLACE_HOLDER_INPUT = "0";

    // TODO menu logic
    public static void menu(ArrayList<String> validOperators) {
        Scanner scanner = new Scanner(System.in);
        NavigableMap<String, String> equation = new TreeMap<>();
        boolean calculatorLoop = true;
        String previousInput = PLACE_HOLDER_INPUT;
        String input;
        while (calculatorLoop) {
            displayMenu(validOperators);
            input = scanner.next();
            determineInput(validOperators, previousInput, input, equation);
            // TODO calculation logic
            // TODO display equation result
            // TODO operator factory
        }
    }

    private static void determineInput(ArrayList<String> validOperators, String previousInput, String input, NavigableMap<String, String> equation) {
        buildInput(equation, previousInput, input, validOperators);
        Map.Entry<String, String> lastEntry = equation.lastEntry();
        if (lastEntry.getValue().equals("Invalid Input")) {
            equation.remove(lastEntry.getKey());
            displayInvalidInput();
        }
    }

    private static void displayInvalidInput() {
        System.out.println("Invalid Input! Enter an input again.");
    }
    private static void displayMenu(ArrayList<String> validOperators) {
        System.out.println("Welcome to the calculator!");
        displayInputStructure();
        displayValidOperators(validOperators);
    }

    private static void displayValidOperators(ArrayList<String> validOperators) {
        System.out.println("The valid operators you can use are:  %s".formatted(validOperators));
    }

    private static void displayInputStructure() {
        System.out.println("Type an operator/operand and hit enter.");
        System.out.println("One per line, enter empty input twice to exit program");
    }

    private static void  displayResult() {
        // TODO display result
    }
}
