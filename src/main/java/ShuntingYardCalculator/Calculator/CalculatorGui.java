package ShuntingYardCalculator.Calculator;

import ShuntingYardCalculator.Config.ConfigLoader;
import ShuntingYardCalculator.Config.ConfigSpecificParser;
import ShuntingYardCalculator.Logging.Log4j;
import ShuntingYardCalculator.Type;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static ShuntingYardCalculator.Config.Config.*;
import static ShuntingYardCalculator.ExceptionType.*;


public class CalculatorGui {
    private static final ArrayList<String> VALID_OPERATORS = ConfigSpecificParser.
            parseValidOperators(ConfigLoader.loadConfig(CONFIG_PATH).get(VALID_OPERATORS_CONFIG));

    public static void menu() {
        ArrayList<Pair<String, Type>> equation;
        String inputEquation = SPACE;
        displayMenu(VALID_OPERATORS);
        while (inputEquation.length() != 0) {
            inputEquation = receiveInput();
            if (!inputEquation.equals(EMPTY)) {
                try {
                    equation = EquationParser.parseEquationString(inputEquation);
                    solveEquation(equation);
                } catch (ArithmeticException exception) {
                    Log4j.displayInvalidEquation();
                }
            }
        }
    }

    private static ArrayList<Pair<String, Type>> solveEquation(ArrayList<Pair<String, Type>> equation) {
        if (!equation.isEmpty()) {
            try {
                double result = CalculatorLogic.calculate(equation);
                displayResult(result);
            } catch (InputMismatchException exception) {
                Log4j.displayInvalidEquation();
            } catch (ArithmeticException exception) {
                arithmeticExceptionType(exception);
            }
            equation = CalculatorLogic.resetEquation();
            displayMenu(VALID_OPERATORS);
        }
        return equation;
    }

    private static void arithmeticExceptionType(ArithmeticException exception) {
        switch (exception.getMessage()) {
            case ZERO_DIVISION_ERROR:
                Log4j.displayZeroDivisionError();
                break;
            case EMPTY_BRACKETS_ERROR:
                Log4j.displayEmptyBracketsError();
                break;
            case INVALID_BRACKETS_ERROR:
                Log4j.displayInvalidBracketsError();
                break;
        }
    }

    public static String receiveInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Equation: ");
        return scanner.nextLine();
    }

    public static void displayMenu(ArrayList<String> VALID_OPERATORS) {
        System.out.println("Welcome to the calculator!");
        displayInputStructure();
        displayValidOperators(VALID_OPERATORS);
        displayExampleEquations();
    }

    public static void displayValidOperators(ArrayList<String> VALID_OPERATORS) {
        System.out.println("The valid operators you can use are: " + VALID_OPERATORS);
    }

    public static void displayInputStructure() {
        System.out.println("Type an equation and hit enter.");
        System.out.println("enter empty input twice to exit program");
    }

    public static void displayResult(double result) {
        System.out.println("Equation result is: " + result);
    }

    public static void displayExampleEquations() {
        System.out.println("Example equations:");
        System.out.println("5 ^ 8 / ( 5 * 1 ) + 10");
        System.out.println("% 5 $ 8");
        System.out.println("% 5 * 5 * ( 10 + 2 )");
    }
}
