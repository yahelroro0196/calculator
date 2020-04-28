package ShuntingYardCalculator.Calculator.Operators;

public class Power extends Operator {
    protected int precedence = 3;

    @Override
    public double calculate(double leftOperand, double rightOperand) {
        return Math.pow(leftOperand, rightOperand);
    }

    public int getPrecedence() {
        return precedence;
    }
}
