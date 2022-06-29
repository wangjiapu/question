package com.pupu.project.tree;

public class Connect {
    /**
     * 116. 填充每个节点的下一个右侧节点指针
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root==null){
            return null;
        }
        traverse(root.left,root.right);
        return root;
    }

    private void traverse(Node node1,Node node2){
        if (node1==null||node2==null){
            return;
        }
        node1.next=node2;
        traverse(node1.left,node1.right);
        traverse(node2.left,node2.right);
        traverse(node1.right,node2.left);
    }
}
