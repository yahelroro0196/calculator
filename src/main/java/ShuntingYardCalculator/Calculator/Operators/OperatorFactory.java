package ShuntingYardCalculator.Calculator.Operators;

public class OperatorFactory {
    public Operator factory(String operator) {
        switch (operator) {
            case "+":
                return new Plus();
            case "-":
                return new Minus();
            case "*":
                return new Multiply();
            case "/":
                return new Divide();
            case "^":
                return new Power();
            default:
                return null;
        }
    }
}
