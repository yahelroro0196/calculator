package ShuntingYardCalculator.Calculator.Operators;

public class Divide extends Operator {
    protected int precedence;

    @Override
    public double calculateOperator(double leftOperand, double rightOperand) throws ArithmeticException {
        if (isNotDividingByZero(rightOperand)) {
            return leftOperand / rightOperand;
        } else {
            throw new ArithmeticException("Can't divide by Zero");
        }
    }

    public boolean isNotDividingByZero(double rightOperand) {
        return rightOperand != 0;
    }
}
