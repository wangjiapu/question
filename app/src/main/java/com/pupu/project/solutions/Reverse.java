package com.pupu.project.solutions;

public class Reverse {

    public int reverse(int x) {
        int re = 0;
        while (x != 0) {
            if (re < Integer.MIN_VALUE / 10 || re > Integer.MAX_VALUE / 10) {
                return 0;
            }

            re = re * 10 + x % 10;
            x = x / 10;
        }
        return re;
    }
}
