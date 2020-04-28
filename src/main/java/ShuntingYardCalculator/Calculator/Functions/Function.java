package ShuntingYardCalculator.Calculator.Functions;

import ShuntingYardCalculator.Calculator.Symbol;

public abstract class Function extends Symbol {
    private int precedence;

    public abstract double calculateFunction(double operand);

    public abstract int getPrecedence();
}
