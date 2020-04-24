package ShuntingYardCalculator.Calculator.Operators;

public class LeftBracket extends Operator {
    protected int precedence = 5;

    @Override
    public double calculate(double leftOperand, double rightOperand) {
        return 0;
    }

    public int getPrecedence() {
        return precedence;
    }
}
