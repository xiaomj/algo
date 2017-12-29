package com.baidu.algo;

public class FindMaxOfLessInTree {
    static class Node {
        Node left;
        Node right;
        int data;
    }

    protected int find(Node root, int target) {
        if (root == null) {
            return -1;
        }
        if (root.data >= target) {
            return find(root.left, target);
        }
        return Math.max(root.data, find(root.right, target));
    }
    
    public static void main(String[] args) {
        Node root = new Node();
        root.data = 10;

        Node left = new Node();
        left.data = 9;
        Node left1 = new Node();
        left1.data = 8;
        root.left = left;
        left.left = left1;

        Node right = new Node();
        right.data = 11;
        Node right1 = new Node();
        right1.data = 12;
        right.right = right1;
        root.right = right;

        System.out.println(new FindMaxOfLessInTree().find(root, 11));
    }
}
