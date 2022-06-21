package com.pupu.project.tree;


public class MultiChildTree {
    public void traverse(TreeNode2 root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        for (TreeNode2 child : root.children) {
            traverse(child);
        }
    }

}
