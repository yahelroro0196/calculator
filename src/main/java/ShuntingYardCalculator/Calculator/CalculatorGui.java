package ShuntingYardCalculator.Calculator;

import ShuntingYardCalculator.Enums.MenuOption;
import ShuntingYardCalculator.Enums.Type;
import ShuntingYardCalculator.Logging.Log4j;
import ShuntingYardCalculator.OptionsFactory;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static ShuntingYardCalculator.Config.Config.*;
import static ShuntingYardCalculator.ExceptionType.*;


public class CalculatorGui {
    public static void menu() {
        String input = SPACE;
        while (input.length() != 0) {
            displayMenu();
            input = receiveInput();
            MenuOption choice = OptionsFactory.factory(input);
            switch (choice) {
                case ENTER_EQUATION:
                    manualEquationInput();
                    break;
                case ENTER_FILENAME:
                    equationsFromFile();
                    break;
                case EXIT:
                    input = EMPTY;
                    break;
                case RETRY:
            }
        }
    }

    private static void equationsFromFile() {
        displayGetFilename();
        try {
            String inputFilename = receiveInput();
            CalculatorLogic.loadEquationFile(inputFilename);
        } catch (ArithmeticException exception) {
            Log4j.displayError("Invalid equation! reenter the equation");
        }
    }

    private static void manualEquationInput() {
        displayGetEquation();
        String inputEquation = receiveInput();
        if (!inputEquation.equals(EMPTY)) {
            try {
                ArrayList<Pair<String, Type>> equation = EquationParser.parseEquationString(inputEquation);
                evaluateEquation(equation);
            } catch (ArithmeticException exception) {
                Log4j.displayError("Invalid equation! reenter the equation");
            }
        }
    }

    private static void evaluateEquation(ArrayList<Pair<String, Type>> equation) {
        if (!equation.isEmpty()) {
            try {
                double result = CalculatorLogic.calculate(equation);
                displayResult(result);
            } catch (InputMismatchException exception) {
                Log4j.displayError("Invalid equation! reenter the equation");
            } catch (ArithmeticException exception) {
                arithmeticExceptionType(exception);
            }
            CalculatorLogic.resetEquation(equation);
        }
    }

    private static void arithmeticExceptionType(ArithmeticException exception) {
        switch (exception.getMessage()) {
            case ZERO_DIVISION_ERROR:
                Log4j.displayWarning("Can't divide by Zero");
                break;
            case EMPTY_BRACKETS_ERROR:
                Log4j.displayWarning("Empty brackets found in equation! reenter the equation!");
                break;
            case INVALID_BRACKETS_ERROR:
                Log4j.displayWarning("Invalid brackets form found in equation! reenter the equation!");
                break;
        }
    }

    public static String receiveInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void displayMenu() {
        Log4j.displayInfo("Welcome to the calculator!");
        Log4j.displayInfo("Type an equation and hit enter.\nenter empty input twice to exit program");
        Log4j.displayInfo("The valid operators you can use are: " + VALID_OPERATORS);
        Log4j.displayInfo("The valid functions you can use are: " + VALID_FUNCTIONS);
        displayExampleEquations();
        displayOptions();
    }

    public static void displayResult(double result) {
        Log4j.displayInfo("Equation result is: " + result);
    }

    public static void displayExampleEquations() {
        Log4j.displayInfo("Example equations:");
        Log4j.displayInfo("5^8/(5*1)+10");
        Log4j.displayInfo("cos(5)*sin(8)");
        Log4j.displayInfo("sin(5)*5*(10+2)");
    }

    public static void displayOptions() {
        Log4j.displayInfo("Options:");
        Log4j.displayInfo("1: Enter an equation (Type \"Enter Equation\")");
        Log4j.displayInfo("2: Enter a filename (.txt) with equations to solve (Type \"Enter File\")");
        Log4j.displayInfo("3: Exit (Type \"Exit\")");
        Log4j.displayInfo("Chosen option: ");
    }

    public static void displayGetEquation() {
        System.out.print("Equation: ");
    }

    public static void displayGetFilename() {
        System.out.print("Filename: ");
    }
}
