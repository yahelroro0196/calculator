package ShuntingYardCalculator.Calculator.Operators;

public class Power extends Operator {
    protected int precedence = 3;

    @Override
    public double calculateOperator(double leftOperand, double rightOperand) {
        return Math.pow(leftOperand, rightOperand);
    }
}
