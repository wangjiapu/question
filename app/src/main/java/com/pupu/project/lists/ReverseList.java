package com.pupu.project.lists;

import java.util.List;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    /**
     * 剑指 Offer II 024. 反转链表 递归实现
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    ListNode suffix = null;

    /**
     * 翻转链表前n个节点
     *
     * @param head
     * @param n
     * @return
     */
    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            suffix = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = suffix;
        return last;
    }

    /**
     * 翻转链表[m,n]的区间
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseN(head, n);
        }
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    /**
     * 25. K 个一组翻转链表
     * @param p1
     * @param p2
     * @return
     */
    ListNode reverseRange(ListNode p1, ListNode p2) {
        ListNode pre = null;
        ListNode cur = p1;
        ListNode next = null;
        while (cur != p2) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode start = head;
        ListNode end = head;
        for (int i = 0; i < k; i++) {
            if (end == null) {
                return head;
            }
            end = end.next;
        }
        ListNode last = reverseRange(start, end);
        start.next = reverseKGroup(end, k);
        return last;
    }
}
