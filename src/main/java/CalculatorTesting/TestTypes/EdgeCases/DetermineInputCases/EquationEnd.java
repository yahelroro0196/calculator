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

public class EquationEnd {
    public static final String equationEndInput = "";
    private static final String CONFIG_PATH = ".\\src\\main\\resources\\ValidOperators.properties";
    private static final String equationEndPreviousInput = "_";
    private static ArrayList<Pair<String, Type>> equationEndEquation;
    private static ArrayList<String> validOperators = ConfigLoader.loadConfig(CONFIG_PATH);
    private static Type equationEndOutput;

    @Test
    public void test() {
        assertEquals(equationEndOutput, CalculatorLogic.determineInput(validOperators, equationEndPreviousInput,
                equationEndInput, equationEndEquation));
    }

    @Before
    public void setup() {
        inputSetup();
        outputSetup();
    }

    private void outputSetup() {
        equationEndOutput = Type.EQUATION_END;
    }

    private void inputSetup() {
        equationEndEquation = new ArrayList<>();
        equationEndEquation = parseEquationString("5 + 5");
    }

    @After
    public void finalize_tests() {
        equationEndEquation.clear();
        equationEndOutput = null;
    }
}
