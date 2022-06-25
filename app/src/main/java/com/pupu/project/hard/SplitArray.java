package com.pupu.project.hard;

public class SplitArray {
    /**
     * 410. 分割数组的最大值
     * @param nums
     * @param m
     * @return
     */
    public int splitArray(int[] nums, int m) {
        int left = 0;
        int right = 1;
        for (int w : nums) {
            left = Math.max(left, w);
            right += w;
        }

        while (left < right) {
            int mid = left + (right - left >> 1);

            if (f(nums, mid) <= m) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int f(int[] nums, int m) {
        int w = 0;
        for (int i = 0; i < nums.length;) {
            int cap = m;
            while (i < nums.length) {
                if (cap < nums[i]) {
                    break;
                }else {
                    cap -= nums[i];
                }
                i++;
            }
            w++;
        }
        return w;
    }


}
