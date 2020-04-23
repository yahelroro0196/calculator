package CalculatorTesting;

import ShuntingYardCalculator.Enums.Type;
import javafx.util.Pair;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static ShuntingYardCalculator.Calculator.CalculatorLogic.loadEquationFile;
import static ShuntingYardCalculator.Calculator.EquationParser.parseEquationString;
import static ShuntingYardCalculator.Calculator.InputFlow.InputValidator.isValidInput;
import static ShuntingYardCalculator.Config.Config.*;

public class ValidInputTests {
    @Test
    public void validOperand() {
        Type validOperandExpected = Type.OPERAND;

        Type validOperandOutput = isValidInput(PLACE_HOLDER_OPERAND, VALID_OPERATORS, VALID_FUNCTIONS);

        Assert.assertEquals(validOperandExpected, validOperandOutput);
    }

    @Test
    public void validOperator() {
        Type validOperatorExpected = Type.OPERATOR;

        Type validOperatorOutput = isValidInput(PLACE_HOLDER_OPERATOR, VALID_OPERATORS, VALID_FUNCTIONS);

        Assert.assertEquals(validOperatorExpected, validOperatorOutput);
    }
}
