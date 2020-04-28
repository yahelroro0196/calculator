package ShuntingYardCalculator.Calculator;

import ShuntingYardCalculator.Calculator.CalculationSteps.InfixToPostfix;
import ShuntingYardCalculator.Config.ConfigLoader;
import ShuntingYardCalculator.Enums.Type;
import ShuntingYardCalculator.Logging.Log4j;
import javafx.util.Pair;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;

import static ShuntingYardCalculator.Calculator.CalculationSteps.PostfixToResult.postfixToResult;
import static ShuntingYardCalculator.Config.Config.EQUATIONS_FILE_EXTENSION;
import static ShuntingYardCalculator.Config.Config.RELATIVE_PATH_PREFIX;

public class CalculatorLogic {
    public static final String EQUALS_SYMBOL = "=";
    private static String NEW_LINE = "\r\n";

    public static double calculate(ArrayList<Pair<String, Type>> equation) throws InputMismatchException,
            ArithmeticException {
        ArrayList<Pair<String, Type>> postfixEquation = InfixToPostfix.infixToPostfix(equation);
        return postfixToResult(postfixEquation);
    }

    public static void resetEquation(ArrayList<Pair<String, Type>> equation) {
        equation.clear();
    }

    public static void loadEquationFile(String fileName) {
        String relativeFilePath = RELATIVE_PATH_PREFIX + fileName + EQUATIONS_FILE_EXTENSION;
        String equationsData = ConfigLoader.streamFileLoader(relativeFilePath);
        ArrayList<String> equations = new ArrayList<>(Arrays.asList(equationsData.split(NEW_LINE)));
        StringBuilder updatedEquationsText = new StringBuilder();
        calculateEquations(equations, updatedEquationsText);
        writeCalculatedEquations(relativeFilePath, updatedEquationsText);
    }

    private static void writeCalculatedEquations(String relativeFilePath, StringBuilder updatedEquationsText) {
        try (FileWriter fileWriter = new FileWriter(relativeFilePath)) {
            fileWriter.write(updatedEquationsText.toString());
        } catch (IOException e) {
            Log4j.displayError("Error loading Equations file!");
        }
    }

    private static void calculateEquations(ArrayList<String> equations, StringBuilder updatedEquationsText) {
        for (String equationText : equations) {
            ArrayList<Pair<String, Type>> equation = EquationParser.parseEquationString(equationText);
            String answer = String.valueOf(calculate(equation));
            updatedEquationsText.append(equationText).append(EQUALS_SYMBOL).append(answer).append(NEW_LINE);
        }
    }
}
