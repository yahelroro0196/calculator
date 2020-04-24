package ShuntingYardCalculator.Calculator.InputFlow;

import ShuntingYardCalculator.Enums.Type;
import javafx.util.Pair;

import java.util.ArrayList;

import static ShuntingYardCalculator.Calculator.InputFlow.InputValidator.isValidInput;

public class InputBuilder {

    public static void buildInput(ArrayList<Pair<String, Type>> equation,
                                  String input) {
        Type inputType = isValidInput(input);
        equation.add(new Pair<>(input, inputType));
    }
}
