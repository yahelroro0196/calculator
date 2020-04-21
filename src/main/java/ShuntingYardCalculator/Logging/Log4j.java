package ShuntingYardCalculator.Logging;

import org.apache.log4j.Logger;

public class Log4j {

    static Logger logger = Logger.getLogger(Log4j.class.getName());

    public static void displayInvalidEquation() {
        logger.error("Invalid equation! reenter the equation");
    }

    public static void displayInvalidInput() {
        logger.warn("Invalid input! reenter the input");
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
}
