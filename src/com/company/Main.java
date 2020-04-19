package com.company;

import com.company.Config.ConfigLoader;

import java.io.IOException;
import java.util.ArrayList;

import static com.company.Calculator.CalculatorGui.menu;

public class Main {

    public static final String VALID_OPERATORS = "validOperators";
    public static final String CONFIG_PATH = "src\\com\\company\\config\\ValidOperators.properties";

    public static void main(String[] args) throws IOException {
        ArrayList<String> validOperators = ConfigLoader.loadConfig(CONFIG_PATH);
        menu(validOperators);
    }

}
