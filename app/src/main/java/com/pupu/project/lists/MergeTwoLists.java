package com.pupu.project.lists;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode newHead = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                dummy.next = list2;
                list2 = list2.next;
            } else {
                dummy.next = list1;
                list1 = list1.next;
            }
            dummy = dummy.next;
        }
        dummy.next = list1 != null ? list1 : list2;
        return newHead.next;
    }

    /**
     * 23. 合并K个升序链表
     * @param lists
     * @return
     */
    ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }

        while (!queue.isEmpty()) {
            ListNode minNode = queue.poll();
            p.next = minNode;
            if (minNode.next != null) {
                queue.offer(minNode.next);
            }
            p = p.next;
        }
        return dummy.next;
    }
}
