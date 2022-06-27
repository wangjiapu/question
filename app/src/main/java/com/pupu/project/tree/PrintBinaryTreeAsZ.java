package com.pupu.project.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PrintBinaryTreeAsZ {
    public List<Integer> printBinaryTreeAsZ(TreeNode root) {

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        if (root == null) {
            return null;
        }
        List<Integer> res = new ArrayList<>();
        stack1.push(root);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                TreeNode node = stack1.pop();
                if (node.left != null) {
                    stack2.push(node.left);
                }
                if (node.right != null) {
                    stack2.push(node.right);
                }
                res.add(node.val);
            }
            while (!stack2.isEmpty()) {
                TreeNode node = stack2.pop();
                if (node.right != null) {
                    stack2.push(node.right);
                }
                if (node.left != null) {
                    stack1.push(node.left);
                }
                res.add(node.val);
            }
        }
        return res;
    }
}
