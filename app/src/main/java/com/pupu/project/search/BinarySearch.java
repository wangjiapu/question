package com.pupu.project.search;

public class BinarySearch {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int mid = 0;
        int left = 0;
        int right = nums.length - 1;
        int num;

        while (left <= right) {
            mid = (right - left >> 1) + left;
            num = nums[mid];
            if (num == target) {
                return mid;
            }
            if (num < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left < right) { // 循环直至区间左右端点相同
            int mid = left + (right - left >>1); // 防止计算时溢出
            if (guess(mid) <= 0) {
                right = mid; // 答案在区间 [left, mid] 中
            } else {
                left = mid + 1; // 答案在区间 [mid+1, right] 中
            }
        }
        // 此时有 left == right，区间缩为一个点，即为答案
        return left;
    }

    private int guess(int mid) {
        return 0;
    }
}
