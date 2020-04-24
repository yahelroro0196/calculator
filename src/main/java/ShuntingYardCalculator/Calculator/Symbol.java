package ShuntingYardCalculator.Calculator;

public abstract class Symbol {
    private int precedence;

    public abstract int getPrecedence();
}
