package ShuntingYardCalculator.Calculator.Operators;

public class Sinus extends Operator {
    protected int precedence = 3;

    @Override
    public double calculateOperator(double leftOperand, double rightOperand) throws ArithmeticException {
        return Math.sin(Math.toRadians(leftOperand + rightOperand));
    }
}
