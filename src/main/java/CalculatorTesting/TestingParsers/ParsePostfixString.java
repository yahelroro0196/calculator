package CalculatorTesting.TestingParsers;

import ShuntingYardCalculator.Enums.Type;
import javafx.util.Pair;

import java.util.ArrayList;

import static ShuntingYardCalculator.Calculator.InputFlow.InputBuilder.buildInput;
import static ShuntingYardCalculator.Config.Config.SPACE;

public class ParsePostfixString {
    public static ArrayList<Pair<String, Type>> parse(String postfix) {
        ArrayList<Pair<String, Type>> postfixEquation = new ArrayList<>();
        for (String token : postfix.split(SPACE)) {
            buildInput(postfixEquation, token);
        }
        return postfixEquation;
    }
}