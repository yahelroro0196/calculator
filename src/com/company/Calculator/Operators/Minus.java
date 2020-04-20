package com.company.Calculator.Operators;

public class Minus extends Operator {
    protected int precedence = 1;

    @Override
    public double calculateOperator(double leftOperand, double rightOperand) {
        return leftOperand - rightOperand;
    }
}
