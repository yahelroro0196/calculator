package ShuntingYardCalculator.Calculator.Operators;

public class Divide extends Operator {
    protected int precedence;

    @Override
    public double calculateOperator(double leftOperand, double rightOperand) {
        return leftOperand / rightOperand;
    }
}
