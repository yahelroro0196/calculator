package ShuntingYardCalculator.Calculator.Functions;

public class Cosines extends Function {
    private int precedence = 5;

    @Override
    public double calculateFunction(double operand) {
        return Math.cos(Math.toRadians(operand));
    }

    public int getPrecedence() {
        return precedence;
    }
}
