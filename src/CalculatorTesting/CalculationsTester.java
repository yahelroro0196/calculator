package CalculatorTesting;

import CalculatorTesting.EdgeCases.InfixToPostfixTests;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculationsTester {

    @Before
    public void programWideTestsPreparation() {
        InfixToPostfixTests.initialize_tests();
    }

    @Test
    public void programWideTests() {
        InfixToPostfixTests.do_tests();
    }

    @After
    public void finalize_test() {
        InfixToPostfixTests.finalize_tests();
    }
}
