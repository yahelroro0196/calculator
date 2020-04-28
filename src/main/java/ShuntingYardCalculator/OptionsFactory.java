package ShuntingYardCalculator;

import ShuntingYardCalculator.Enums.MenuOption;

import static ShuntingYardCalculator.Enums.MenuOption.*;

public class OptionsFactory {
    public static MenuOption factory(String chosenOption) {
        switch (chosenOption) {
            case "Enter Equation":
                return ENTER_EQUATION;
            case "Enter File":
                return ENTER_FILENAME;
            case "Exit":
                return EXIT;
            default:
                return RETRY;
        }
    }
}
