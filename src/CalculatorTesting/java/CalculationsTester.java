import EdgeCases.InfixToPostfixCases;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculationsTester {

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
