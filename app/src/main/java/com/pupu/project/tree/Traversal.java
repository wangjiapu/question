package com.pupu.project.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Traversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        first1(root, list);
        return list;
    }

    /**
     * 中序遍历
     *
     * @param node
     * @param list
     */
    private void inorder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }

    private void inorder1(TreeNode node, List<Integer> list) {
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                list.add(node.val);
                node = node.right;
            }
        }
    }

    /**
     * 先序遍历
     *
     * @param node
     * @param list
     */
    private void first(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        first(node.left, list);
        first(node.right, list);
    }

    private void first1(TreeNode node, List<Integer> list) {
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                list.add(node.val);
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                node = node.right;
            }
        }
    }

    /**
     * 后序遍历
     *
     * @param root
     * @param list
     */
    private void end(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        end(root.left, list);
        end(root.right, list);
        list.add(root.val);
    }

    private void end1(TreeNode node, List<Integer> list) {
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                list.add(node.val);
                stack.push(node);
                node = node.right;
            } else {
                node = stack.pop();
                node = node.left;
            }
        }
        Collections.reverse(list);
    }


    /**
     * 层次遍历
     *
     * @param node
     * @return
     */
    public List<Integer> layerTraversal(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            result.add(p.val);
            if (p.left != null) {
                queue.offer(p.left);
            }
            if (p.right != null) {
                queue.offer(p.right);
            }

        }

        return result;
    }

    /**
     * 层次遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int levelSize = queue.size();
            for (int i = 1; i <= levelSize; i++) {
                TreeNode t = queue.poll();
                level.add(t.val);
                if (t.left != null) {
                    queue.offer(t.left);
                }
                if (t.right != null) {
                    queue.offer(t.right);
                }
            }
            result.add(level);
        }
        return result;
    }
}
