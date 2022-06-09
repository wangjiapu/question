package com.pupu.project.solutions;

import java.util.HashMap;
import java.util.Map;

public class IntToRoman {

    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            String symbol = symbols[i];
            while (num >= value) {
                num -= value;
                sb.append(symbol);
            }
            if (num == 0) {
                break;
            }
        }
        return sb.toString();
    }

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>(7);
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);

        char[] chars = s.toCharArray();
        int value = 0;
        int preValue = map.get(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            int num = map.get(chars[i]);
            if (num > preValue) {
                value -= preValue;
            } else {
                value += preValue;
            }
            preValue = num;
        }
        value += preValue;
        return value;
    }
}
