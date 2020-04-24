package CalculatorTesting;

import ShuntingYardCalculator.Enums.Type;
import org.junit.Assert;
import org.junit.Test;

import static ShuntingYardCalculator.Calculator.InputFlow.InputValidator.isValidInput;
import static ShuntingYardCalculator.Config.Config.PLACE_HOLDER_OPERAND;
import static ShuntingYardCalculator.Config.Config.PLACE_HOLDER_OPERATOR;

public class ValidInputTests {
    @Test
    public void validOperand() {
        Type validOperandExpected = Type.OPERAND;

        Type validOperandOutput = isValidInput(PLACE_HOLDER_OPERAND);

        Assert.assertEquals(validOperandExpected, validOperandOutput);
    }

    @Test
    public void validOperator() {
        Type validOperatorExpected = Type.OPERATOR;

        Type validOperatorOutput = isValidInput(PLACE_HOLDER_OPERATOR);

        Assert.assertEquals(validOperatorExpected, validOperatorOutput);
    }
}
