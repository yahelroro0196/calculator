package ShuntingYardCalculator.Calculator.Functions;

public class Sines extends Function {
    @Override
    public double calculateFunction(double leftOperand) {
        return Math.sin(leftOperand);
    }
}
