package com.company.Calculator.Operators;

public class Divide extends Operator {
    protected int precedence = 2;

    @Override
    public double calculateOperator(double leftOperand, double rightOperand) {
        return leftOperand / rightOperand;
    }
}
