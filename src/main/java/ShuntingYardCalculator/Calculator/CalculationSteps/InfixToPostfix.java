package ShuntingYardCalculator.Calculator.CalculationSteps;

import ShuntingYardCalculator.Calculator.Functions.FunctionFactory;
import ShuntingYardCalculator.Calculator.Operators.OperatorFactory;
import ShuntingYardCalculator.Calculator.Symbol;
import ShuntingYardCalculator.Enums.Type;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Stack;

import static ShuntingYardCalculator.Config.Config.L_BRACKET;
import static ShuntingYardCalculator.Config.Config.R_BRACKET;
import static ShuntingYardCalculator.ExceptionType.EMPTY_BRACKETS_ERROR;
import static ShuntingYardCalculator.ExceptionType.INVALID_BRACKETS_ERROR;

public class InfixToPostfix {
    public static ArrayList<Pair<String, Type>> infixToPostfix(ArrayList<Pair<String, Type>> equation)
            throws ArithmeticException {
        ArrayList<Pair<String, Type>> postfixEquation = new ArrayList<>();
        Stack<Pair<String, Type>> operatorStack = new Stack<>();
        for (Pair<String, Type> currPair : equation) {
            if (currPair.getValue().equals(Type.OPERAND))
                postfixEquation.add(currPair);
            else if (currPair.getKey().equals(L_BRACKET))
                operatorStack.push(currPair);
            else if (currPair.getKey().equals(R_BRACKET))
                insertBracketsPart(postfixEquation, operatorStack);
            else
                insertByPrecedence(postfixEquation, operatorStack, currPair);
        }
        addRemaining(postfixEquation, operatorStack);
        return postfixEquation;
    }

    private static void insertByPrecedence(ArrayList<Pair<String, Type>> postfixEquation,
                                           Stack<Pair<String, Type>> operatorStack,
                                           Pair<String, Type> currPair) {
        while (!operatorStack.isEmpty()
                && (operatorStack.peek().getValue().equals(Type.FUNCTION)
                || isHigherPrecedence(operatorStack.peek(), currPair))
                && !operatorStack.peek().getKey().equals(L_BRACKET)) {
            postfixEquation.add(operatorStack.pop());
        }
        operatorStack.push(currPair);
    }

    private static void addRemaining(ArrayList<Pair<String, Type>> postfixEquation,
                                     Stack<Pair<String, Type>> operatorStack) {
        while (!operatorStack.isEmpty())
            postfixEquation.add(operatorStack.pop());
    }

    private static void insertBracketsPart(ArrayList<Pair<String, Type>> postfixEquation,
                                           Stack<Pair<String, Type>> operatorStack) throws ArithmeticException {
        boolean insertedBracketsContents = false;
        isStandaloneBracket(operatorStack);
        while (!operatorStack.peek().getKey().equals(L_BRACKET)) {
            postfixEquation.add(operatorStack.pop());
            insertedBracketsContents = true;
        }
        if (operatorStack.peek().getKey().equals(L_BRACKET))
            operatorStack.pop();
        isEmptyBrackets(insertedBracketsContents, postfixEquation);
    }

    private static void isStandaloneBracket(Stack<Pair<String, Type>> operatorStack) {
        if (operatorStack.isEmpty())
            throw new ArithmeticException(INVALID_BRACKETS_ERROR);
    }

    private static void isEmptyBrackets(boolean inserted, ArrayList<Pair<String, Type>> postfixEquation) {
        if (!inserted && (postfixEquation.size() == 0
                || !postfixEquation.get(postfixEquation.size() - 1).getValue().equals(Type.OPERAND)))
            throw new ArithmeticException(EMPTY_BRACKETS_ERROR);
    }

    private static boolean isHigherPrecedence(Pair<String, Type> stackSymbolPair, Pair<String, Type> currSymbolPair) {
        Symbol stackSymbol = isOperatorOrFunction(stackSymbolPair);
        Symbol currSymbol = isOperatorOrFunction(currSymbolPair);
        return (stackSymbol.getPrecedence() >= currSymbol.getPrecedence());
    }

    private static Symbol isOperatorOrFunction(Pair<String, Type> currSymbol) {
        Symbol symbol;
        OperatorFactory operatorFactory = new OperatorFactory();
        FunctionFactory functionFactory = new FunctionFactory();
        if (currSymbol.getValue().equals(Type.FUNCTION)) {
            symbol = functionFactory.factory(currSymbol.getKey());
        } else {
            symbol = operatorFactory.factory(currSymbol.getKey());
        }
        return symbol;
    }
}
