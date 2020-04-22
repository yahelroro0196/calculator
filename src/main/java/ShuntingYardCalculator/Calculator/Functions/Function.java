package ShuntingYardCalculator.Calculator.Functions;

public abstract class Function {
    public int precedence = 4;

    public abstract double calculateFunction(double operand);
}
