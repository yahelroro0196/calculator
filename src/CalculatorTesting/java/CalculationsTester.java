import ShuntingYardCalculator.Calculator.CalculationSteps.InfixToPostfix;
import ShuntingYardCalculator.Calculator.CalculationSteps.PostfixToResult;
import ShuntingYardCalculator.Type;
import javafx.util.Pair;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CalculationsTester {

    public static final int postfixToResultOutput = 65;
    private ArrayList<Pair<String, Type>> infixToPostfixInput;
    private ArrayList<Pair<String, Type>> infixToPostfixOutput;
    @Before
    public void prepareTests() {
        infixToPostfixOutput = new ArrayList<>();
        infixToPostfixInput = new ArrayList<>();
        infixToPostfixOutput.add(new Pair<>("5", Type.OPERAND));
        infixToPostfixOutput.add(new Pair<>("5", Type.OPERAND));
        infixToPostfixOutput.add(new Pair<>("+", Type.OPERATOR));
        infixToPostfixOutput.add(new Pair<>("55", Type.OPERAND));
        infixToPostfixOutput.add(new Pair<>("+", Type.OPERATOR));
        infixToPostfixInput.add(new Pair<>("5", Type.OPERAND));
        infixToPostfixInput.add(new Pair<>("+", Type.OPERATOR));
        infixToPostfixInput.add(new Pair<>("5", Type.OPERAND));
        infixToPostfixInput.add(new Pair<>("+", Type.OPERATOR));
        infixToPostfixInput.add(new Pair<>("55", Type.OPERAND));
    }
    @Test
    public void infixToPostfixTester() {
        assertEquals(infixToPostfixOutput, InfixToPostfix.infixToPostfix(infixToPostfixInput));
    }

    @Test
    public void postfixToResultTester() {
        assertEquals(postfixToResultOutput, PostfixToResult.postfixToResult(infixToPostfixOutput),0.01);
    }

    @After
    public void finalize_test() {
        infixToPostfixOutput.clear();
        infixToPostfixInput.clear();
    }
}
