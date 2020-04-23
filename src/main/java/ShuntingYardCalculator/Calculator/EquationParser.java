package ShuntingYardCalculator.Calculator;

import ShuntingYardCalculator.Enums.Type;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;

import static ShuntingYardCalculator.Calculator.InputFlow.InputBuilder.buildInput;
import static ShuntingYardCalculator.Config.Config.*;

public class EquationParser {
    public static ArrayList<Pair<String, Type>> parseEquationString(String equationText)
            throws ArithmeticException {
        equationText = equationText.replace(SPACE, EMPTY);
        ArrayList<String> splitEquation = new ArrayList<>(Arrays.asList(equationText.split(EMPTY)));
        ArrayList<Pair<String, Type>> equation = new ArrayList<>();
        String insertLast = loopEquation(splitEquation, equation);
        if (!insertLast.equals(EMPTY))
            insertLastToken(equation, insertLast);
        return equation;
    }

    private static String loopEquation(ArrayList<String> splitEquation, ArrayList<Pair<String, Type>> equation) {
        int currNumber = 0;
        int adjacentNumber = currNumber + 1;
        String insertLast = EMPTY;
        while (adjacentNumber < splitEquation.size()) {
            String token = splitEquation.get(currNumber);
            String subToken = splitEquation.get(adjacentNumber);
            if (checkIfMultiDigit(splitEquation, token, subToken)) {
                token = token + subToken;
                splitEquation.remove(subToken);
            } else if (adjacentNumber == splitEquation.size() - 1) {
                insertLast = subToken;
            }
            buildInput(equation, token, VALID_OPERATORS, VALID_FUNCTIONS);
            currNumber++;
            adjacentNumber++;
        }
        return insertLast;
    }

    private static void insertLastToken(ArrayList<Pair<String, Type>> equation, String lastToken) {
        buildInput(equation, lastToken, VALID_OPERATORS, VALID_FUNCTIONS);
    }

    private static boolean checkIfMultiDigit(ArrayList<String> splitEquation, String token, String subToken) {
        try {
            Double.parseDouble(token);
            Double.parseDouble(subToken);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }
}
