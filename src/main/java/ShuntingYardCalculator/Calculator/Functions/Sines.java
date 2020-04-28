package ShuntingYardCalculator.Calculator.Functions;

public class Sines extends Function {
    private int precedence = 5;

    public double calculateFunction(double operand) {
        return Math.sin(Math.toRadians(operand));
    }

    public int getPrecedence() {
        return precedence;
    }
}
