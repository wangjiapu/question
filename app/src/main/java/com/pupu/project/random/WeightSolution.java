package com.pupu.project.random;

import com.pupu.question.R;

import java.util.Random;

public class WeightSolution {
    private int[] preNum;

    private Random random=new Random();
    public WeightSolution(int[] w) {
        int len = w.length;
        preNum = new int[len + 1];
        preNum[0] = 0;
        for (int i = 1; i <= len; i++) {
            preNum[i] = preNum[i - 1] + w[i - 1];
        }
    }

    public int pickIndex() {
        int n= preNum.length;
        int target = random.nextInt(preNum[n - 1]) + 1;

        int left = 0;
        int right = n;
        while (left < right) {
            int mid = left + (right - left >> 2);
            if (preNum[mid] >= target) {
                right = mid;
            } else if (preNum[mid] < target) {
                left = mid + 1;
            }
        }
        return left - 1;
    }
}
