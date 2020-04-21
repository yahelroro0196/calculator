import ShuntingYardCalculator.Calculator.CalculationSteps.InfixToPostfix;
import ShuntingYardCalculator.Calculator.CalculationSteps.PostfixToResult;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;
import EdgeCases.InfixToPostfixCases;

public class CalculationsTester {

    public static final int postfixToResultOutput = 65;

    @Before
    public void programWideTestsPreparation() {
        InfixToPostfixCases.inputSetup();
        InfixToPostfixCases.outputSetup();
    }

    @Test
    public void programWideTests() {
        InfixToPostfixCases.doubleBrackets();
    }

    @After
    public void finalize_test() {
        InfixToPostfixCases.finalize_tests();
    }
}
