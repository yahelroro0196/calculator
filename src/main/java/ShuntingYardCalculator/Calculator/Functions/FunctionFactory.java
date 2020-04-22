package ShuntingYardCalculator.Calculator.Functions;

public class FunctionFactory {
    public Function factory(String function) {
        switch (function) {
            case "$":
                return new Sines();
            case "%":
                return new Cosines();
            default:
                return null;
        }
    }
}
