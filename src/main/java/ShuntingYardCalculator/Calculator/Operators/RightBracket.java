package ShuntingYardCalculator.Calculator.Operators;

public class RightBracket extends Operator {
    protected int precedence = 6;

    @Override
    public double calculate(double leftOperand, double rightOperand) {
        return 0;
    }

    public int getPrecedence() {
        return precedence;
    }
}
