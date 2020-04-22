package ShuntingYardCalculator.Calculator.Operators;

public class Plus extends Operator {
    protected int precedence = 1;

    @Override
    public double calculateOperator(double leftOperand, double rightOperand) {
        return leftOperand + rightOperand;
    }
}
