package com.company.Calculator;

import com.company.Config.ConfigLoader;
import com.company.Pair;

import java.util.*;

import static com.company.Calculator.CalculatorLogic.*;
import static com.company.Constants.*;

public class CalculatorGui {

    public static final String CONFIG_PATH = "src\\com\\company\\config\\ValidOperators.properties";
    private static final String NEW_LINE = "\n";
    private static final ArrayList<String> VALID_OPERATORS = ConfigLoader.loadConfig(CONFIG_PATH);

    public static void menu() {
        ArrayList<Pair<String, String>> equation = new ArrayList<>();
        String previousResult = PLACE_HOLDER_INPUT;
        displayMenu();
        while (!isExitCalculator(previousResult)) {
            String input = receiveInput();
            String inputResult = determineInput(VALID_OPERATORS, previousResult, input, equation);
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
            displayMenu();
        }
        return equation;
    }

    public static void displayInvalidInput() {
        System.out.println("Invalid Input! Enter an input again.");
    }

    public static void displayMenu() {
        System.out.println("Welcome to the calculator!");
        displayInputStructure();
        displayValidOperators();
    }

    private static void displayValidOperators() {
        System.out.printf("The valid operators you can use are:  %s" + NEW_LINE, VALID_OPERATORS);
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
