package com.pupu.project.solutions;

import java.util.ArrayList;

public class Subsequence {
    public boolean isSubsequence(String s, String t) {
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        int i = 0;
        int j = 0;

        while (i < ch1.length && j < ch2.length) {

            if (ch1[i] == ch2[j]) {
                i++;
                j++;
            } else {
                j++;
            }
        }

        return i == ch1.length;
    }

    public boolean isSubsequence2(String s, String t) {
        int m = s.length();
        int n = t.length();
        ArrayList<Integer>[] list = new ArrayList[256];
        for (int i = 0; i < n; i++) {
            char c = t.charAt(i);
            if (list[c] == null) {
                list[c] = new ArrayList<>();
            }
            list[c].add(i);
        }
        int index = 0;
        for (int j = 0; j < m; j++) {
            char c = s.charAt(j);
            if (list[c] == null) {
                return false;
            }
            int pos = leftBound(list[c], index);
            if (pos == list[c].size()) {
                return false;
            }
            index = list[c].get(pos) + 1;
        }
        return true;
    }

    private int leftBound(ArrayList<Integer> integers, int c) {
        int right = integers.size();
        int left = 0;
        while (left < right) {
            int mid = left + (right - left >> 1);
            if (integers.get(mid) >= c) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
