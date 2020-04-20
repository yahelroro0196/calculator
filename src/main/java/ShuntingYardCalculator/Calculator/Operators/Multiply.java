package ShuntingYardCalculator.Calculator.Operators;

public class Multiply extends Operator {
    protected int precedence = 2;

    @Override
    public double calculateOperator(double leftOperand, double rightOperand) {
        return leftOperand * rightOperand;
    }
}
