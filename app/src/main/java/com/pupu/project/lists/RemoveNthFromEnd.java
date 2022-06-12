package com.pupu.project.lists;

import com.pupu.project.lists.ListNode;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0, head); //用一个虚拟头结点，理解更简单
        ListNode firstNode = dummyNode;
        ListNode secondNode = head;
        while (n > 0) {
            secondNode = secondNode.next;
            n--;
        }
        while (secondNode != null) {
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }
        firstNode.next = firstNode.next.next;

        return dummyNode.next;
    }
}