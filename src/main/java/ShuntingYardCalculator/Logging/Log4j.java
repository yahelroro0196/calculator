package ShuntingYardCalculator.Logging;

import org.apache.log4j.Logger;

public class Log4j {

    static Logger logger = Logger.getLogger(Log4j.class.getName());

    public static void displayInvalidEquation() {
        logger.error("Invalid equation! reenter the equation");
    }

    public static void displayConfigError() {
        logger.error("Error loading config!");
    }

    public static void displayZeroDivisionError() {
        logger.error("Can't divide by Zero");
    }

    public static void displayEmptyBracketsError() {
        logger.error("Empty brackets found in equation! reenter the equation!");
    }

    public static void displayInvalidBracketsError() {
        logger.error("Invalid brackets form found in equation! reenter the equation!");
    }

    public static void displayEquationFileIOError() {
        logger.error("Error reading the equations file!");
    }

    public static void displayEquationFileParseError() {
        logger.error("Error parsing JSON format! try editing the json format to be correct!");
    }

    public static void displayEquationFileNotFound() {
        logger.error("File not found! check the name you typed!");
    }
}
