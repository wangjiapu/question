package com.pupu.project.solutions;

public class RemoveDuplicates {
    /**
     * 26. 删除有序数组中的重复项
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {

        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[left]) {
                nums[++left] = nums[i];
            }
        }
        return left + 1;
    }
}
