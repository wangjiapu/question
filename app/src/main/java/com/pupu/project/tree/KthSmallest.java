package com.pupu.project.tree;

import java.util.Random;

public class KthSmallest {

    int res = 0;
    int tank = 0;

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }

    private void traverse(TreeNode node, int k) {
        if (node == null) {
            return;
        }
        traverse(node.left, k);
        tank++;
        if (tank == k) {
            res = node.val;
            return;
        }
        traverse(node.right, k);
    }

    /**
     * 洗牌算法
     *
     * @param arr
     */
    public void shuffle(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int rand = randInt(i, n - 1);
            swap(arr[i], arr[rand]);
        }
    }

    /**
     * 得到一个区间在【min,max】内的随机数
     *
     * @param min
     * @param max
     * @return
     */
    private int randInt(int min, int max) {
        // return (int) min + (int) (Math.random() * (max - min));
        return min + new Random().nextInt(max - min);
    }

    private void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }
}
