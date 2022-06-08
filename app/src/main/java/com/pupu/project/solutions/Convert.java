package com.pupu.project.solutions;

import java.util.Arrays;

public class Convert {

    public String convert(String s, int numRows) {
        if (1 == numRows) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        String[] strings = new String[numRows];
        Arrays.fill(strings, "");
        char[] chars = s.toCharArray();
        int period = numRows * 2 - 2;
        for (int i = 0; i < chars.length; i++) {
            int mod = i % period;
            if (mod < numRows) {
                strings[mod] += chars[i];
            } else {
                strings[period - mod] += chars[i];
            }
        }
        for (String s1 : strings) {
            sb.append(s1);
        }
        return sb.toString();
    }
}
