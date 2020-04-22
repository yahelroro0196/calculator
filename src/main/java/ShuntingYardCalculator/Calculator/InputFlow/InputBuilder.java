package ShuntingYardCalculator.Calculator.InputFlow;

import ShuntingYardCalculator.Type;
import javafx.util.Pair;

import java.util.ArrayList;

import static ShuntingYardCalculator.Calculator.InputFlow.InputValidator.isValidInput;

public class InputBuilder {

    public static void buildInput(ArrayList<Pair<String, Type>> equation, String previousInput,
                                  String input, ArrayList<String> validOperators) {
        Type inputType = isValidInput(previousInput, input, validOperators);
        equation.add(new Pair<>(input, inputType));
    }
}
