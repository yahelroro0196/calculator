package ShuntingYardCalculator.Calculator.Operators;

public class Cosines extends Operator {
    protected int precedence = 3;

    @Override
    public double calculateOperator(double leftOperand, double rightOperand) throws ArithmeticException {
        return Math.cos(Math.toRadians(leftOperand + rightOperand));
    }
}
