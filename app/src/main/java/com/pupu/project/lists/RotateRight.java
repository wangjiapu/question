package com.pupu.project.lists;

public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode temp = head;
        int len = 0;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        k = k % len;
        ListNode firstNode = new ListNode(-1, head);
        ListNode secondNode = new ListNode(-1, head);
        while (k > 0) {
            secondNode = secondNode.next;
            k--;
        }
        while (secondNode.next != null) {
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }
        secondNode.next = head;
        ListNode newHead = firstNode.next;
        firstNode.next = null;
        return newHead;
    }
}
