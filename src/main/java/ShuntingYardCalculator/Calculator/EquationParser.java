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
        String insertLast = parseEquation(splitEquation, equation);
        if (!insertLast.equals(EMPTY))
            insertLastToken(equation, insertLast);
        return equation;
    }

    private static String parseEquation(ArrayList<String> splitEquation, ArrayList<Pair<String, Type>> equation) {
        int currNumIndex = 0;
        int nextNumIndex = currNumIndex + 1;
        String insertLast = EMPTY;
        while (nextNumIndex < splitEquation.size()) {
            insertLast = parseToken(splitEquation, currNumIndex, nextNumIndex, insertLast, equation);
            currNumIndex++;
            nextNumIndex++;
        }
        return insertLast;
    }

    private static String parseToken(ArrayList<String> splitEquation, int currNumIndex, int nextNumIndex,
                                     String insertLast, ArrayList<Pair<String, Type>> equation) {
        String token = splitEquation.get(currNumIndex);
        String subToken = splitEquation.get(nextNumIndex);
        if (isMultiDigit(token, subToken)) {
            token = combineConnectedDigits(splitEquation, token, nextNumIndex);
            if (isLastToken(splitEquation, nextNumIndex))
                insertLast = splitEquation.get(nextNumIndex);
        }
        else if (isFunction(token))
            insertLast = parseFunction(splitEquation, nextNumIndex, insertLast, subToken);
        else if (isLastToken(splitEquation, nextNumIndex))
            insertLast = subToken;
        buildInput(equation, token);
        return insertLast;
    }

    private static boolean isLastToken(ArrayList<String> splitEquation, int nextNumIndex) {
        return nextNumIndex == splitEquation.size() - 1;
    }

    private static String parseFunction(ArrayList<String> splitEquation, int nextNumIndex, String insertLast, String subToken) {
        while (!splitEquation.get(nextNumIndex).equals(L_BRACKET))
            splitEquation.remove(splitEquation.get(nextNumIndex));
        if (isLastToken(splitEquation, nextNumIndex))
            insertLast = subToken;
        return insertLast;
    }

    private static String combineConnectedDigits(ArrayList<String> splitEquation, String token, int nextNumIndex) {
        StringBuilder tokenBuilder = new StringBuilder(token);
        while (!VALID_OPERATORS.contains(splitEquation.get(nextNumIndex)) &&
        !VALID_FUNCTIONS.contains(splitEquation.get(nextNumIndex))) {
            tokenBuilder.append(splitEquation.get(nextNumIndex));
            splitEquation.remove(splitEquation.get(nextNumIndex));
        }
        token = tokenBuilder.toString();
        return token;
    }

    private static void insertLastToken(ArrayList<Pair<String, Type>> equation, String lastToken) {
        buildInput(equation, lastToken);
    }

    private static boolean isMultiDigit(String token, String subToken) {
        try {
            Double.parseDouble(token);
            Double.parseDouble(subToken);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    private static boolean isFunction(String token) {
        return VALID_FUNCTIONS.contains(token);
    }
}
