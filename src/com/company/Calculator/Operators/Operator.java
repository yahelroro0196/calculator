package com.company.Calculator.Operators;

public abstract class Operator extends OperatorFactory {
    private int precedence;

    public abstract double calculateOperator(double leftOperand, double rightOperand);

    public int getPrecedence() {
        return precedence;
    }
}
