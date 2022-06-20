package com.pupu.project.lists;

import android.media.tv.TvView;

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

    /**
     * 876. 链表的中间结点
     *
     * @param head
     * @return
     */
    ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 160. 相交链表
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
    }
}