package com.names.score.calculator;

import java.util.HashMap;
import java.util.Map;

public class CharToNumberMapper {

    private static final Map<Character, Integer> charIntMap = new HashMap<>();

    static {
        charIntMap.put('A', 1);
        charIntMap.put('B', 2);
        charIntMap.put('C', 3);
        charIntMap.put('D', 4);
        charIntMap.put('E', 5);
        charIntMap.put('F', 6);
        charIntMap.put('G', 7);
        charIntMap.put('H', 8);
        charIntMap.put('I', 9);
        charIntMap.put('J', 10);
        charIntMap.put('K', 11);
        charIntMap.put('L', 12);
        charIntMap.put('M', 13);
        charIntMap.put('N', 14);
        charIntMap.put('O', 15);
        charIntMap.put('P', 16);
        charIntMap.put('Q', 17);
        charIntMap.put('R', 18);
        charIntMap.put('S', 19);
        charIntMap.put('T', 20);
        charIntMap.put('U', 21);
        charIntMap.put('V', 22);
        charIntMap.put('W', 23);
        charIntMap.put('X', 24);
        charIntMap.put('Y', 25);
        charIntMap.put('Z', 26);

    }

    public static int getIntFromMap(char ch) throws Exception {
        if (!charIntMap.containsKey(ch)) {
            throw new Exception("No Mapping number found.");
        }
        return charIntMap.get(ch);
    }

}
