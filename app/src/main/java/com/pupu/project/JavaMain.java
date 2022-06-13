package com.pupu.project;

import com.pupu.project.search.BinarySearch;
import com.pupu.project.solutions.IntToRoman;
import com.pupu.project.sort.HeapSort;
import com.pupu.project.sort.QuicklySort;
import com.pupu.project.topk.FindKthLargest;
import com.pupu.project.topk.TopKFrequent;
import com.pupu.project.tree.Traversal;
import com.pupu.project.tree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class JavaMain {

    /**
     * .idea/gradle.xml中添加<option name="delegatedBuild" value="false" />
     *
     * @param args
     */
    public static void main(String[] args) {
        // System.out.println(Arrays.toString(test));
        // System.out.println(new BinarySearch().search(initList(),5));
        String result = listToString(new Traversal().inorderTraversal(initBinaryTree()));
        System.out.println(result);
    }

    public static String listToString(List<Integer> list) {
        if (list==null){
            return "list is empty!!!";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int item : list) {
            stringBuilder.append(item).append(',');
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static TreeNode initBinaryTree() {
        int[] elements = new int[]{9, 1, 7, 10,0, 4, 6, 5, 6, 3};
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        for (int i : elements) {
            if (i==0){
                queue.offer(null);
            }else{
                queue.offer(new TreeNode(i));
            }
        }
        TreeNode root = new TreeNode(33);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node=null;
            while (node == null){
                node=stack.pop();
            }
            if (!queue.isEmpty() && node.left == null) {
                node.left = queue.poll();
                stack.push(node.left);
            }
            if (node.right == null && !queue.isEmpty()) {
                node.right = queue.poll();
                stack.push(node.right);
            }
        }
        return root;
    }

    public static int[] initList() {
        //return new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        //return new int[]{9,1,7,10,4,6,5,6,3};
        //return new int[]{1,2,3,4,5,6,7,8};
        return new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6, 7, 7, 8, 2, 3, 1, 1, 1, 10, 11, 5, 6, 2, 4, 7, 8, 5, 6};
    }
}
