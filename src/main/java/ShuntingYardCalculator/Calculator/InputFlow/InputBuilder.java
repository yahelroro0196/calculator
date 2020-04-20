package ShuntingYardCalculator.Calculator.InputFlow;

import ShuntingYardCalculator.Pair;
import ShuntingYardCalculator.Type;

import java.util.ArrayList;

import static ShuntingYardCalculator.Calculator.InputFlow.InputValidator.isValidInput;

public class InputBuilder {
    public static void buildInput(ArrayList<Pair<String, Type>> equation, String previousInput,
                                  String input, ArrayList<String> validOperators) {
        Type isValidInputResult = isValidInput(previousInput, input, validOperators);
        equation.add(new Pair<>(input, isValidInputResult));
    }
}
