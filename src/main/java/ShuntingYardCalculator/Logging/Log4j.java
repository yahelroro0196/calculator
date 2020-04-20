package ShuntingYardCalculator.Logging;

import org.apache.log4j.Logger;

import java.util.ArrayList;

public class Log4j {

    static Logger logger = Logger.getLogger(Log4j.class.getName());

    public static void displayMenu(ArrayList<String> VALID_OPERATORS) {
        logger.info("Welcome to the calculator!");
        displayInputStructure();
        displayValidOperators(VALID_OPERATORS);
    }

    public static void displayValidOperators(ArrayList<String> VALID_OPERATORS) {
        logger.info("The valid operators you can use are:  %s".formatted(VALID_OPERATORS));
    }

    public static void displayInputStructure() {
        logger.info("Type an operator/operand and hit enter.");
        logger.info("One per line, enter empty input twice to exit program");
    }

    public static void displayResult(double result) {
        logger.info("Equation result is: %s".formatted(result));
    }

    public static void displayInvalidEquation() {
        logger.error("Invalid equation! reenter the equation");
    }

    public static void displayInvalidInput() {
        logger.warn("Invalid input! reenter the input");
    }

    public static void displayConfigError() {
        logger.error("Error loading config!");
    }

    public static void displayZeroDivision() {
        logger.error("Can't divide by Zero");
    }
}
