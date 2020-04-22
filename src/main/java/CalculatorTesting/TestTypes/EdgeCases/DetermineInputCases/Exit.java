package CalculatorTesting.TestTypes.EdgeCases.DetermineInputCases;

import ShuntingYardCalculator.Calculator.CalculatorLogic;
import ShuntingYardCalculator.Config.ConfigLoader;
import ShuntingYardCalculator.Type;
import javafx.util.Pair;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static CalculatorTesting.TestParser.parseEquationString;
import static org.junit.Assert.assertEquals;

public class Exit {
    public static final String exitInput = "";
    private static final String CONFIG_PATH = ".\\src\\main\\resources\\ValidOperators.properties";
    private static final String exitPreviousInput = Type.EQUATION_END.name();
    private static ArrayList<Pair<String, Type>> exitEquation;
    private static ArrayList<String> validOperators = ConfigLoader.loadConfig(CONFIG_PATH);
    private static Type exitOutput;

    @Test
    public void test() {
        assertEquals(exitOutput, CalculatorLogic.determineInput(validOperators, exitPreviousInput,
                exitInput, exitEquation));
    }

    @Before
    public void setup() {
        inputSetup();
        outputSetup();
    }

    private void outputSetup() {
        exitOutput = Type.EXIT;
    }

    private void inputSetup() {
        exitEquation = new ArrayList<>();
        exitEquation = parseEquationString("5 + 5");
    }

    @After
    public void finalize_tests() {
        exitEquation.clear();
        exitOutput = null;
    }
}
