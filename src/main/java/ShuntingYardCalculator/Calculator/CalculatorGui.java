package ShuntingYardCalculator.Calculator;

import ShuntingYardCalculator.Config.ConfigLoader;
import ShuntingYardCalculator.Constants;
import ShuntingYardCalculator.Logging.Log4j;
import ShuntingYardCalculator.Pair;
import ShuntingYardCalculator.Type;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class CalculatorGui {

    public static final String CONFIG_PATH = ".\\src\\main\\resources\\ValidOperators.properties";
    private static final ArrayList<String> VALID_OPERATORS = ConfigLoader.loadConfig(CONFIG_PATH);

    public static void menu() {
        ArrayList<Pair<String, Type>> equation = new ArrayList<>();
        String previousResult = Constants.EMPTY_INPUT;
        Log4j.displayMenu(VALID_OPERATORS);
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
                Log4j.displayResult(result);
            } catch (InputMismatchException exception) {
                Log4j.displayInvalidEquation();
            }
            equation = CalculatorLogic.resetEquation();
            Log4j.displayMenu(VALID_OPERATORS);
        }
        return equation;
    }

    public static String receiveInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
