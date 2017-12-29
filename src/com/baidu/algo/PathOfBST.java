package com.baidu.algo;

import java.util.ArrayList;
import java.util.List;

public class PathOfBST {
    static class Node {
        Node left;
        Node right;
        int data;
    }

    protected boolean findPath(Node root, int sum, List<Node> path) {
        if (root == null) {
            return false;
        }

        if (sum == root.data) {
            path.add(root);
            return true;
        } else if (sum < root.data) {
            return false;
        }

        path.add(root);
        if (findPath(root.left, sum - root.data, path)
            || findPath(root.right, sum - root.data, path)) {
            return true;
        }
        path.remove(root);
        return false;
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

        List<Node> path = new ArrayList<>();
        new PathOfBST().findPath(root, 34, path);
        for (Node node: path) {
            System.out.println(node.data);
        }
    }
}
