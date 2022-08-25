package com.pupu.project.string;

import java.util.Stack;

public class RemoveDuplicates {
    public String removeDuplicates(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (top < 0 || stringBuilder.charAt(top) != ch) {
                stringBuilder.append(ch);
                top++;
            } else {
                stringBuilder.deleteCharAt(top);
                top--;
            }
        }
        return stringBuilder.toString();
    }
}
