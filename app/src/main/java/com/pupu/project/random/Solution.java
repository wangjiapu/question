package com.pupu.project.random;

import com.pupu.project.lists.ListNode;

import java.util.Random;

public class Solution {
    ListNode head;

    public Solution(ListNode head) {

        this.head = head;
    }

    /**
     * 382. 链表随机节点
     * @return
     */
    public int getRandom() {

        Random random = new Random();
        int i = 0;
        int res = 0;
        ListNode p = head;
        while (p != null) {
            if (random.nextInt(++i) == 0) {
                res = p.val;
            }
            p = p.next;
        }
        return res;
    }
}
