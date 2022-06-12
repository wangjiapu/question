package com.pupu.project.lists;

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
}
