package ShuntingYardCalculator.Calculator;

import ShuntingYardCalculator.Calculator.CalculationSteps.InfixToPostfix;
import ShuntingYardCalculator.Enums.Type;
import javafx.util.Pair;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;

import static ShuntingYardCalculator.Calculator.CalculationSteps.PostfixToResult.postfixToResult;
import static ShuntingYardCalculator.Config.Config.JSON_END;
import static ShuntingYardCalculator.Config.Config.RELATIVE_FILE_PATHS;

public class CalculatorLogic {
    private static final String equationKey = "equation";
    public static final String EQUALS_SYMBOL = "=";

    public static double calculate(ArrayList<Pair<String, Type>> equation) throws InputMismatchException,
            ArithmeticException {
        ArrayList<Pair<String, Type>> postfixEquation = InfixToPostfix.infixToPostfix(equation);
        return postfixToResult(postfixEquation);
    }

    public static ArrayList<Pair<String, Type>> resetEquation() {
        return new ArrayList<>();
    }

    public static void loadEquationFile(String fileName) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        try {
            Object fileReader = parser.parse(new FileReader(RELATIVE_FILE_PATHS + fileName + JSON_END));
            FileWriter fileWriter = new FileWriter(RELATIVE_FILE_PATHS + fileName + JSON_END);
            JSONObject jsonOfEquation = (JSONObject) fileReader;
            iterateEquation(jsonOfEquation);
            fileWriter.write(jsonOfEquation.toJSONString());
            fileWriter.close();
        } catch (FileNotFoundException exception) {
            throw new FileNotFoundException(Type.FILE_NOT_FOUND.name());
        } catch (IOException exception) {
            throw new IOException(Type.INVALID_IO.name());
        }
    }

    private static JSONObject iterateEquation(JSONObject jsonOfEquations) {
        for (Object currEquationKey : jsonOfEquations.keySet()) {
            String equationText = (String) jsonOfEquations.get(currEquationKey);
            ArrayList<Pair<String, Type>> equation = EquationParser.parseEquationString(equationText);
            String answer = String.valueOf(CalculatorLogic.calculate(equation));
            String completeAnswer = equationText + EQUALS_SYMBOL + answer;
            jsonOfEquations.put(currEquationKey, completeAnswer);
        }
        return jsonOfEquations;
    }
}
