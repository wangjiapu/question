package com.pupu.project.sort;

public class SortColors {
    public void sortColors(int[] nums) {
        int[] list = new int[3];
        for (int i : nums) {
            list[i]++;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            while (list[j] == 0) {
                j++;
            }
            nums[i] = j;
            list[j]--;
        }
    }

    public void sortColors2(int[] nums) {
        int p0 = 0;
        int p1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                swap(nums, p1, i);
                p1++;
            } else if (nums[i] == 0) {
                swap(nums, p0, i);
                if (p0 < p1) {
                    swap(nums, p1, i);
                }
                p0++;
                p1++;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
