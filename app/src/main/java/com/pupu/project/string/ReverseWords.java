package com.pupu.project.string;

import java.util.Arrays;
import java.util.Stack;

public class ReverseWords {
    /**
     * 151. 颠倒字符串中的单词
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == ' ') {
                if (stack.isEmpty() || stack.peek() == ' ') {
                    continue;
                }
                stack.push(c);
            } else {
                stack.push(c);
            }
        }
        if (stack.peek() == ' ') {
            stack.pop();
        }
        int index = 0;
        chars = new char[stack.size()];
        while (!stack.isEmpty()) {
            chars[index++] = stack.pop();
        }
        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                reverse(chars, start, i - 1);
                start = i + 1;
            }
            if (i == chars.length - 1) {
                reverse(chars, start, i);
            }
        }
        return new String(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char c = chars[start];
            chars[start] = chars[end];
            chars[end] = c;
            start++;
            end--;
        }
    }
}
