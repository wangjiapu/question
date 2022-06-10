package com.pupu.project.topk;

import java.util.Stack;

public class FindKthLargest {
    boolean check(int[] nums, int m, int k) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > m) {
                cnt++;
                if (cnt >= k)
                    return false;
            }
        }
        return true;
    }

    /**
     * 二分查找
     * @param nums
     * @param k
     * @return
     */
//    public int findKthLargest(int[] nums, int k) {
//        int l = -10001, r = 10001;
//        while (l + 1 < r) {
//            int m = (l + r) / 2;
//            if (!check(nums, m, k))
//                l = m;
//            else
//                r = m;
//        }
//        return r;
//    }

    /**
     * 快排
     *
     * @param nums
     * @param k
     * @return
     */
//    public int findKthLargest(int[] nums, int k) {
//        if (nums.length < 2) {
//            return nums[0];
//        }
//        return quickSort(nums, k);
//    }
    public int findKthLargest(int[] nums, int k) {
        if (nums.length < 2) {
            return nums[0];
        }
        return heapSort(nums, k);
    }


    private int heapSort(int[] nums, int k) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            temp = i;
            while (nums[temp] < nums[fatherIndex(temp)]) {
                swap(nums, temp, fatherIndex(temp));
                temp = fatherIndex(temp);
            }
        }
        for (int j = nums.length - 1; j >= 0; j--, k--) {
            if (k == 0) {
                return nums[j];
            }
            swap(nums, 0, j);
            heapify(nums, 0, j - 1);
        }
        return 0;
    }

    private void heapify(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        while (left < size) {
            int swapIndex = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            swapIndex = arr[index] > arr[swapIndex] ? index : swapIndex;
            if (swapIndex == index) {
                break;
            }
            swap(arr, index, swapIndex);
            index = swapIndex;
            left = index * 2 + 1;
        }
    }

    private void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    private int fatherIndex(int index) {
        return (index - 1) / 2;
    }

    private int quickSort(int[] nums, int k) {
        int len = nums.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(len - 1);
        int right, left, i, j;
        int key;
        int temp;
        while (!stack.empty()) {
            right = stack.pop();
            left = stack.pop();
            i = left;
            j = right;
            key = nums[i];
            while (i < j) {
                while (nums[j] >= key && i < j) {
                    j--;
                }
                nums[i] = nums[j];
                while (nums[i] <= key && i < j) {
                    i++;
                }
                nums[j] = nums[i];
            }
            nums[i] = key;
            temp = len - i;
            if (temp < k && i - 1 > left) {
                stack.push(left);
                stack.push(i - 1);
            } else if (temp > k && i + 1 < right) {
                stack.push(i + 1);
                stack.push(right);
            } else {
                return nums[len - k];
            }
        }
        return 0;
    }
}
