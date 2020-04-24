package ShuntingYardCalculator.Calculator.Functions;

public class Tangent extends Function {
    private int precedence = 5;

    public double calculateFunction(double operand) {
        return Math.tan(Math.toRadians(operand));
    }


    public int getPrecedence() {
        return precedence;
    }
}
