package com.pupu.project.solutions;

import java.util.Arrays;

public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i : dp) {
            res = Math.max(i, res);
        }
        return res;
    }

    public int lengthOfLIS2(int[] nums) {
        int[] top = new int[nums.length];
        int block = 0;
        for (int i = 0; i < nums.length; i++) {
            int poker = nums[i];

            int left = 0;
            int right = block;
            while (left < right) {
                int mid = left + (right - left >> 1);
                if (top[mid] >= poker) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            if (left == block) {
                block++;
            }
            top[left] = poker;
        }
        return block;
    }
}
