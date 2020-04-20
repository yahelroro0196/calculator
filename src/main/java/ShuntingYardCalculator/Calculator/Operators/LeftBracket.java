package ShuntingYardCalculator.Calculator.Operators;

public class LeftBracket extends Operator {
    protected int precedence = 4;

    @Override
    public double calculateOperator(double leftOperand, double rightOperand) {
        return 0;
    }

    public int getPrecedence() {
        return precedence;
    }
}
