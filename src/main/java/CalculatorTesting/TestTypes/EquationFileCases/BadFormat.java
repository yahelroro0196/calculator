package CalculatorTesting.TestTypes.EquationFileCases;

import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static ShuntingYardCalculator.Calculator.CalculatorLogic.loadEquationFile;
import static org.junit.Assert.assertThrows;

public class BadFormat {
    private static String BAD_FORMAT_INPUT;
    private static Class<ParseException> BAD_FORMAT_OUTPUT;

    @Test
    public void test() {
        assertThrows(BAD_FORMAT_OUTPUT, () -> loadEquationFile(BAD_FORMAT_INPUT));
    }

    @Before
    public void setup() {
        inputSetup();
        outputSetup();
    }

    private void outputSetup() {
        BAD_FORMAT_OUTPUT = ParseException.class;
    }

    private void inputSetup() {
        BAD_FORMAT_INPUT = "BadFormatEquations";
    }

    @After
    public void finalizeTests() {
        BAD_FORMAT_INPUT = "";
        BAD_FORMAT_OUTPUT = null;
    }
}
