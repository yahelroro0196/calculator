package ShuntingYardCalculator.Calculator.Operators;

import ShuntingYardCalculator.Calculator.Symbol;

public abstract class Operator extends Symbol {
    private int precedence;

    public abstract double calculate(double leftOperand, double rightOperand);

    public abstract int getPrecedence();
}
