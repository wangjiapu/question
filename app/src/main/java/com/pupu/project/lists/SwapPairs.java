package com.pupu.project.lists;

import java.util.Stack;

public class SwapPairs {
    /**
     * 递归方式
     *
     * @param head
     * @return
     */
    public ListNode swapPairs01(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head.next;
        head.next = swapPairs01(temp.next);
        temp.next = head;
        return temp;
    }

    /**
     * 使用辅助栈
     *
     * @param head
     * @return
     */
    public ListNode swapPairs02(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode dummy = new ListNode(-1);
        ListNode newHead = dummy;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            stack.push(cur);
            stack.push(cur.next);
            cur = cur.next.next;
            dummy.next = stack.pop();
            dummy = dummy.next;
            dummy.next = stack.pop();
            dummy = dummy.next;
        }
        dummy.next = cur;
        return newHead.next;
    }
}
