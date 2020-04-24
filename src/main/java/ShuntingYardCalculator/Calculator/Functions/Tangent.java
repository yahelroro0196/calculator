package ShuntingYardCalculator.Calculator.Functions;

public class Tangent extends Function {
    @Override
    public double calculateFunction(double operand) {
        return Math.tan(operand);
    }
}
