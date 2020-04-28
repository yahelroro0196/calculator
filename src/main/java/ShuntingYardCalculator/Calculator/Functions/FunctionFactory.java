package ShuntingYardCalculator.Calculator.Functions;

public class FunctionFactory {
    public Function factory(String function) {
        switch (function) {
            case "s":
                return new Sines();
            case "c":
                return new Cosines();
            case "t":
                return new Tangent();
            default:
                return null;
        }
    }
}
