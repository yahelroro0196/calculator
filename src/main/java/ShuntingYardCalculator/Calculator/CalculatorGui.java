package ShuntingYardCalculator.Calculator;

import ShuntingYardCalculator.Config.ConfigLoader;
import ShuntingYardCalculator.Logging.Log4j;
import ShuntingYardCalculator.Type;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static ShuntingYardCalculator.ExceptionType.EMPTY_BRACKETS_ERROR;
import static ShuntingYardCalculator.ExceptionType.ZERO_DIVISION_ERROR;


public class CalculatorGui {

    public static final String PLACE_HOLDER = "_";
    private static final String CONFIG_PATH = ".\\src\\main\\resources\\ValidOperators.properties";
    private static final ArrayList<String> VALID_OPERATORS = ConfigLoader.loadConfig(CONFIG_PATH);

    public static void menu() {
        ArrayList<Pair<String, Type>> equation = new ArrayList<>();
        String previousResult = PLACE_HOLDER;
        displayMenu(VALID_OPERATORS);
        while (!previousResult.equalsIgnoreCase(Type.EXIT.name())) {
            String input = receiveInput();
            Type inputResult = CalculatorLogic.determineInput(VALID_OPERATORS, previousResult, input, equation);
            equation = determineInputResult(equation, inputResult);
            previousResult = inputResult.name();
        }
    }

    private static ArrayList<Pair<String, Type>> determineInputResult(ArrayList<Pair<String, Type>> equation,
                                                                      Type inputResult) {
        switch (inputResult) {
            case INVALID_INPUT:
                Log4j.displayInvalidInput();
                break;
            case EQUATION_END:
                equation = equationEndCase(equation);
                break;
        }
        return equation;
    }

    private static ArrayList<Pair<String, Type>> equationEndCase(ArrayList<Pair<String, Type>> equation) {
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
            case EMPTY_BRACKETS_ERROR:
                Log4j.displayZeroDivisionError();
        }
    }

    public static String receiveInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


    public static void displayMenu(ArrayList<String> VALID_OPERATORS) {
        System.out.println("Welcome to the calculator!");
        displayInputStructure();
        displayValidOperators(VALID_OPERATORS);
    }

    public static void displayValidOperators(ArrayList<String> VALID_OPERATORS) {
        System.out.println("The valid operators you can use are: " + VALID_OPERATORS);
    }

    public static void displayInputStructure() {
        System.out.println("Type an operator/operand and hit enter.");
        System.out.println("One per line, enter empty input twice to exit program");
    }

    public static void displayResult(double result) {
        System.out.println("Equation result is: " + result);
    }
}
