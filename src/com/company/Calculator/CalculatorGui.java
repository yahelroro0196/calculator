package com.company.Calculator;
import com.company.Pair;

import java.util.*;

import static com.company.Calculator.CalculatorLogic.calculate;
import static com.company.Calculator.InputBuilder.buildInput;

public class CalculatorGui {

    public static final String PLACE_HOLDER_INPUT = "0";

    // TODO menu logic
    public static void menu(ArrayList<String> validOperators) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Pair<String, String>> equation = new ArrayList<>();
        boolean calculatorLoop = true;
        String previousInput = PLACE_HOLDER_INPUT;
        String input;
        while (calculatorLoop) {
            displayMenu(validOperators);
            input = scanner.nextLine();
            determineInput(validOperators, previousInput, input, equation);
            // TODO calculation logic
            // TODO display equation result
            // TODO operator factory
        }
    }

    private static void determineInput(ArrayList<String> validOperators, String previousInput, String input,
                                       ArrayList<Pair<String, String>> equation) {
        buildInput(equation, previousInput, input, validOperators);
        Pair<String, String> lastEntry = equation.get(equation.size() - 1);
        if (lastEntry.getRight().equals("Invalid Input")) {
            equation.remove(equation.size() - 1);
            displayInvalidInput();
        } else if (lastEntry.getRight().equals("EquationEnd")) {
            equation.remove(equation.size() - 1);
            displayResult(equation);
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

    private static void  displayResult(ArrayList<Pair<String, String>> equation) {
        System.out.println("Equation result is: %s".formatted(calculate(equation)));
    }
}
