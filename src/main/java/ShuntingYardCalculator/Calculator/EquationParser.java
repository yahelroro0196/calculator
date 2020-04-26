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
        String insertLast = iterateEquation(splitEquation, equation);
        if (!insertLast.equals(EMPTY))
            insertLastToken(equation, insertLast);
        return equation;
    }

    private static String iterateEquation(ArrayList<String> splitEquation, ArrayList<Pair<String, Type>> equation) {
        int currNumIndex = 0;
        int nextNumIndex = currNumIndex + 1;
        String insertLast = EMPTY;
        while (nextNumIndex < splitEquation.size()) {
            String token = splitEquation.get(currNumIndex);
            String subToken = splitEquation.get(nextNumIndex);
            if (isMultiDigit(token, subToken)) {
                token = token + subToken;
                splitEquation.remove(subToken);
            } else if (isFunction(token)) {
                while (!splitEquation.get(nextNumIndex).equals(L_BRACKET))
                    splitEquation.remove(splitEquation.get(nextNumIndex));
                if (nextNumIndex == splitEquation.size() - 1)
                    insertLast = subToken;
            } else if (nextNumIndex == splitEquation.size() - 1)
                insertLast = subToken;
            buildInput(equation, token);
            currNumIndex++;
            nextNumIndex++;
        }
        return insertLast;
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
