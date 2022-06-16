package com.pupu.project.hard;

import java.util.Arrays;
import java.util.Comparator;

public class MaxEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });
        int[] height = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            height[i] = envelopes[i][1];
        }

        return lenghtLTS(height);
    }

    private int lenghtLTS(int[] height) {
        int[] top = new int[height.length];
        int b = 0;
        for (int i = 0; i < height.length; i++) {
            int num = height[i];

            int left = 0;
            int right = b;
            while (left < right) {
                int mid = left + (right - left >> 1);
                if (top[mid] >= num) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            if (left == b) {
                b++;
            }
            top[left] = num;
        }
        return b;
    }
}
