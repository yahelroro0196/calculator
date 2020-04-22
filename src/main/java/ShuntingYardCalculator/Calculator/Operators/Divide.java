package ShuntingYardCalculator.Calculator.Operators;

import static ShuntingYardCalculator.ExceptionType.ZERO_DIVISION_ERROR;

public class Divide extends Operator {
    protected int precedence = 2;

    @Override
    public double calculateOperator(double leftOperand, double rightOperand) throws ArithmeticException {
        if (isNotDividingByZero(rightOperand))
            return leftOperand / rightOperand;
        else
            throw new ArithmeticException(ZERO_DIVISION_ERROR);
    }

    public boolean isNotDividingByZero(double rightOperand) {
        return rightOperand != 0;
    }
}
