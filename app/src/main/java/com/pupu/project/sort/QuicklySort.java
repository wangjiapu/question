package com.pupu.project.sort;

import java.util.Stack;

public class QuicklySort {

    public int[] sort(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }
        noRecursion(nums, 0, nums.length - 1);
        return nums;
    }

    /**
     * 非递归操作，使用stack来替换
     *
     * @param nums
     * @param left
     * @param right
     */
    private void noRecursion(int[] nums, int left, int right) {
        Stack<Integer> stack = new Stack<>();
        stack.push(left);
        stack.push(right);
        while (!stack.empty()) {
            int j = stack.pop(); //栈结构：后进先出
            int i = stack.pop();
            int l = i;
            int r = j;
            int flag = nums[i];
            while (i < j) {
                while (i < j && nums[j] >= flag) {
                    j--;
                }
                nums[i] = nums[j];
                while (i < j && nums[i] <= flag) {
                    i++;
                }
                nums[j] = nums[i];
            }
            nums[i] = flag;
            if (i - 1 > l) {
                stack.push(l);
                stack.push(i - 1);
            }
            if (i + 1 < r) {
                stack.push(i + 1);
                stack.push(r);
            }
        }
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left;
        int j = right;
        int flag = nums[i];
        while (i < j) {
            while (i < j && nums[j] >= flag) {
                j--;
            }
            nums[i] = nums[j];
            while (i < j && nums[i] <= flag) {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = flag;
        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);
    }

    public void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
