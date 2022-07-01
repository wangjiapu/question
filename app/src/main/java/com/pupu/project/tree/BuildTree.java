package com.pupu.project.tree;

import java.util.HashMap;
import java.util.Map;

public class BuildTree {
    Map<Integer, Integer> inorderMap;

    /**
     * 105. 从前序与中序遍历序列构造二叉树
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
}
