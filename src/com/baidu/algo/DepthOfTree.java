package com.baidu.algo;

public class DepthOfTree {
    static class Node {
        Node left;
        Node right;
        Object data;
    }

    protected int depthOfTree(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(depthOfTree(root.left), depthOfTree(root.right));
    }

    public static void main(String[] args) {

    }

}
