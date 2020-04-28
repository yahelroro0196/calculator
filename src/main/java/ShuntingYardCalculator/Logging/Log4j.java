package ShuntingYardCalculator.Logging;

import org.apache.log4j.Logger;

public class Log4j {

    static Logger logger = Logger.getLogger(Log4j.class.getName());

    public static void displayInfo(String text) {
        logger.info(text);
    }

    public static void displayWarning(String text) {
        logger.warn(text);
    }

    public static void displayError(String text) {
        logger.error(text);
    }
}
