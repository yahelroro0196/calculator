package ShuntingYardCalculator.Calculator;

import ShuntingYardCalculator.Enums.MenuOption;
import ShuntingYardCalculator.Enums.Type;
import ShuntingYardCalculator.Logging.Log4j;
import ShuntingYardCalculator.OptionsFactory;
import javafx.util.Pair;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static ShuntingYardCalculator.Config.Config.*;
import static ShuntingYardCalculator.ExceptionType.*;


public class CalculatorGui {
    public static void menu() {
        ArrayList<Pair<String, Type>> equation;
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
        String inputFilename = receiveInput();
        try {
            CalculatorLogic.loadEquationFile(inputFilename);
        } catch (FileNotFoundException exception) {
            Log4j.displayEquationFileNotFound();
        } catch (IOException exception) {
            Log4j.displayEquationFileIOError();
        } catch (ParseException exception) {
            Log4j.displayEquationFileParseError();
        } catch (ArithmeticException exception) {
            Log4j.displayInvalidEquation();
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
                Log4j.displayInvalidEquation();
            }
        }
    }

    private static ArrayList<Pair<String, Type>> evaluateEquation(ArrayList<Pair<String, Type>> equation) {
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
        return scanner.nextLine();
    }

    public static void displayMenu() {
        System.out.println("Welcome to the calculator!");
        displayInputStructure();
        displayValidOperators();
        displayValidFunctions();
        displayExampleEquations();
        displayOptions();
    }

    public static void displayValidOperators() {
        System.out.println("The valid operators you can use are: " + VALID_OPERATORS);
    }

    public static void displayValidFunctions() {
        System.out.println("The valid functions you can use are: " + VALID_FUNCTIONS);
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
        System.out.println("5^8/(5*1)+10");
        System.out.println("%5*$8");
        System.out.println("%5*5*(10+2)");
    }

    public static void displayOptions() {
        System.out.println("Options:");
        System.out.println("1: Enter an equation");
        System.out.println("2: Enter a filename (json) with equations to solve");
        System.out.println("3: Exit");
        System.out.print("Chosen option: ");
    }

    public static void displayGetEquation() {
        System.out.print("Equation: ");
    }

    public static void displayGetFilename() {
        System.out.print("Filename: ");
    }
}
