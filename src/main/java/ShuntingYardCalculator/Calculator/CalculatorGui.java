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
            CalculatorLogic.loadEquationFile(inputFilename);
//        } catch (FileNotFoundException exception) {
//            Log4j.displayError("File not found! check the name you typed!");
//        } catch (IOException exception) {
//            Log4j.displayError("Error reading the equations file!");
//        } catch (ParseException exception) {
//            Log4j.displayError("Error parsing JSON format! try editing the json format to be correct!");
//        } catch (ArithmeticException exception) {
//            Log4j.displayError("Invalid equation! reenter the equation");
//        }
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
        System.out.println("Welcome to the calculator!");
        Log4j.displayInfo("Type an equation and hit enter.\nenter empty input twice to exit program");
        Log4j.displayInfo("The valid operators you can use are: " + VALID_OPERATORS);
        Log4j.displayInfo("The valid functions you can use are: " + VALID_FUNCTIONS);
        displayExampleEquations();
        displayOptions();
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
