package com.pupu.project.lists;

public class FindKfromList {
    /**
     * 返回链表的倒数第 k 个节点
     * @param head
     * @param k
     * @return
     */
    ListNode findFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
