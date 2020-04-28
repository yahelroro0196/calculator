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
            case "(":
                return new LeftBracket();
            case ")":
                return new RightBracket();
            default:
                return null;
        }
    }
}
