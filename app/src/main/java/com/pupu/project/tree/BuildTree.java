package com.pupu.project.tree;

import java.util.HashMap;
import java.util.Map;

public class BuildTree {
    Map<Integer, Integer> inorderMap;

    /**
     * 105. 从前序与中序遍历序列构造二叉树
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderMap = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; ++i) {
            inorderMap.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] pre, int preStart, int preEnd, int[] inoder, int inorderStart, int inorderEnd) {
        if (preStart > preEnd) {
            return null;
        }
        TreeNode node = new TreeNode(pre[preStart]);

        int rootIndex = inorderMap.get(pre[preStart]);
        int range = rootIndex - inorderStart;

        node.left = build(pre, preStart + 1, preStart + range, inoder, inorderStart, rootIndex - 1);
        node.right = build(pre, preStart + range + 1, preEnd, inoder, rootIndex + 1, inorderEnd);
        return node;
    }

    /**
     * 106. 从中序与后序遍历序列构造二叉树
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        inorderMap = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; ++i) {
            inorderMap.put(inorder[i], i);
        }
        return build1(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build1(int[] inorder, int inorderStart, int inorderEnd, int[] postorder, int postorderStart, int postorderEnd) {

        if (inorderStart > inorderEnd) {
            return null;
        }
        TreeNode node = new TreeNode(postorder[postorderEnd]);
        int index = inorderMap.get(postorder[postorderEnd]);

        int range = index - inorderStart;
        node.left = build1(inorder, inorderStart, index - 1, postorder, postorderStart, postorderStart + range - 1);
        node.right = build1(inorder, index + 1, inorderEnd, postorder, postorderStart + range, postorderEnd - 1);
        return node;
    }
}
