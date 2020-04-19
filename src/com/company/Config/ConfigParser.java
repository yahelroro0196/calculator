package com.company.Config;

import java.util.ArrayList;
import java.util.Arrays;

public class ConfigParser {
    public static ArrayList<String> parseValidOperatorsString(String validOperatorsText) {
        String[] validOperatorsArray = validOperatorsText.split(",");
        return new ArrayList<>(Arrays.asList(validOperatorsArray));
    }
}
