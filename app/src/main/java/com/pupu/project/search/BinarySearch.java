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
            int mid = left + (right - left >> 1); // 防止计算时溢出
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

    /**
     * 34. 在排序数组中查找元素的第一个和最后一个位置
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        return new int[]{leftBound(nums, target), rightBound(nums, target)};
    }

    /**
     * 二分查找target的left边界
     * @param nums
     * @param target
     * @return
     */
    private int leftBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] >= target) {
                right = mid - 1;
            }
        }
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    /**
     * 二分查找target的right边界
     * @param nums
     * @param target
     * @return
     */
    private int rightBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left >> 1);
            if (nums[mid] > target) {
                right = mid -1;
            } else if (nums[mid] <= target) {
                left = mid + 1;
            }
        }
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }
}
