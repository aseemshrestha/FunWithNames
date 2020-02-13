package com.names.score.calculator;

import java.util.List;

public class ScoreCalculator {
    // LINDA  12 +9 + 14 + 4 + 1 = 40
    // "MARY","PATRICIA","LINDA","BARBARA","VINCENZO","SHON","LYNWOOD","JERE","HAI"

    public int calculateScore(List<String> list) throws Exception {
        int sum = 0;
        int pos;
        for (int i = 0; i < list.size(); i++) {
            pos = i + 1;
            //getSumOfCharsToInt(list.get(i)) == MARY
            sum = sum + (getSumOfCharsToInt(list.get(i)) * pos);
        }
        return sum;
    }

    private int getSumOfCharsToInt(String str) throws Exception {
        char[] chars = str.toCharArray(); // " M A R Y "
        int sum = 0;
        for (char c : chars) {
            if (!Character.isAlphabetic(c)) {
                continue;
            }
            sum = sum + CharToNumberMapper.getIntFromMap(c);  //M
        }
        return sum;
    }
}
