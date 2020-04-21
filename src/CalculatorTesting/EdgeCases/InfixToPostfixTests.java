package CalculatorTesting.EdgeCases;

import CalculatorTesting.EdgeCases.InfixToPostfixCases.DoubleBrackets;
import CalculatorTesting.EdgeCases.InfixToPostfixCases.DoubleEmptyBrackets;

public class InfixToPostfixTests {
    public static void initialize_tests() {
        DoubleBrackets.setup();
        DoubleEmptyBrackets.setup();
    }

    public static void do_tests() {
        DoubleBrackets.test();
        DoubleEmptyBrackets.test();
    }

    public static void finalize_tests() {
        DoubleBrackets.finalize_tests();
        DoubleEmptyBrackets.finalize_tests();
    }
}
