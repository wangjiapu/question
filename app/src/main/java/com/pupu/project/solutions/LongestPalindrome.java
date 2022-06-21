package com.pupu.project.solutions;

import com.pupu.project.lists.ListNode;

public class LongestPalindrome {
    public String longestPalindrome(String s) {

        if (s == null || s.length() < 2) {
            return s;
        }
        int len = s.length();
        int maxLen = 1;
        int startIndex = 0;

        boolean[][] resultArr = new boolean[len][len];
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                //                if (s.charAt(i)!=s.charAt(j)){
                //                    resultArr[i][j] = false;
                //                }else {
                //                    if (j-i<3){
                //                        resultArr[i][j]=true;
                //                    }else{
                //                        resultArr[i][j]=resultArr[i+1][j-1];
                //                    }
                //                }
                resultArr[i][j] = s.charAt(i) == s.charAt(j) &&
                        (j - i < 3 || resultArr[i + 1][j - 1]);
                if (resultArr[i][j] && maxLen < (j - i + 1)) {
                    maxLen = j - i + 1;
                    startIndex = i;
                }
            }
        }

        return s.substring(startIndex, startIndex + maxLen);
    }

    public boolean isPalindrome(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean isPalindrome(char[] chars, int start, int end) {

        while (start < end) {
            if (chars[start] != chars[end])
                return false;
            start++;
            end--;
        }
        return true;
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int y = 0;
        int s = x;
        while (x != 0) {
            y = y * 10 + x % 10;
            x = x / 10;
        }
        return y == s;
    }

    /**
     * 回文链表
     * 递归写法
     */
    private ListNode leftNode;

    public boolean isPalindrome(ListNode head) {

        leftNode = head;
        return traverse(head);
    }

    private boolean traverse(ListNode node) {
        if (node == null) {
            return true;
        }
        boolean res = traverse(node.next);
        res = res && (leftNode.val == node.val);
        leftNode = leftNode.next;
        return res;
    }

    /**
     * 非递归实现，翻转链表
     * @param head
     * @return
     */
    public boolean isPalindrome2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //链表为奇数，需要slow再前进一步
        if (fast != null) {
            slow = slow.next;
        }
        fast = reverse(slow);
        slow = head;
        while (slow != null && fast != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
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

}
