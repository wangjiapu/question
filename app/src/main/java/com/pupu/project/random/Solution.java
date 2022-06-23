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
     *
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

    /**
     * 返回链表中 k 个随机节点的值
     * @param head
     * @param k
     * @return
     */
    public int[] getRandom(ListNode head, int k) {
        Random random = new Random();
        int[] res = new int[k];
        ListNode p = head;

        for (int i = 0; i < k && p != null; i++) {
            res[i] = p.val;
            p = p.next;
        }
        int i = k;
        while (p != null) {
            int j = random.nextInt(++i);
            if (j < k) {
                res[j] = p.val;
            }
            p = p.next;
        }
        return res;
    }
}
