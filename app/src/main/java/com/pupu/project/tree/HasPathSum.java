package com.pupu.project.tree;

public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        int m = targetSum - root.val;
        return hasPathSum(root.left, m) || hasPathSum(root.right, m);
    }

}
