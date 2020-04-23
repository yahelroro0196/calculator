package ShuntingYardCalculator;

import ShuntingYardCalculator.Enums.MenuOption;

import static ShuntingYardCalculator.Enums.MenuOption.*;

public class OptionsFactory {
    public static MenuOption factory(String chosenOption) {
        switch (chosenOption) {
            case "1":
                return ENTER_EQUATION;
            case "2":
                return ENTER_FILENAME;
            case "3":
                return EXIT;
            default:
                return RETRY;
        }
    }
}
