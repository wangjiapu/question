package com.pupu.project.solutions;

public class MyAtoi {

    public int myAtoi(String s) {
        int index = 0;
        int flag = 1;
        int result = 0;
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }
        if (index < s.length()) {
            if (s.charAt(index) == '+' || s.charAt(index) == '-') {
                flag = s.charAt(index) == '-' ? -1 : 1;
                index++;
            }
        }
        for (int i = index; i < s.length(); i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                return result * flag;
            }
            if (result * flag > Integer.MAX_VALUE / 10 || result * flag < Integer.MIN_VALUE / 10) {
                return flag > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            int tmp = s.charAt(i) - '0';
            if (result * flag == Integer.MAX_VALUE / 10) {
                if (tmp >= Integer.MAX_VALUE % 10) {
                    return Integer.MAX_VALUE;
                }
            }
            if (result * flag == Integer.MIN_VALUE / 10) {
                if (-tmp <= Integer.MIN_VALUE % 10) {
                    return Integer.MIN_VALUE;
                }
            }
            result = result * 10 + tmp;
        }
        return result * flag;

    }
}
