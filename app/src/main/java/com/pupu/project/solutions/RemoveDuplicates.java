package com.pupu.project.solutions;

import com.pupu.project.lists.ListNode;

public class RemoveDuplicates {
    /**
     * 26. 删除有序数组中的重复项
     *
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

    /**
     * 83. 删除排序链表中的重复元素
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode left = head;
        ListNode right = head;
        while (right != null) {
            if (left.val < right.val) {
                left.next = right;
                left = left.next;
            }
            right = right.next;
        }
        // 断开与后面重复元素的连接
        left.next = null;
        return head;
    }

    /**
     * 27. 移除元素
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[left++] = nums[i];
            }
        }
        return left;
    }
}
