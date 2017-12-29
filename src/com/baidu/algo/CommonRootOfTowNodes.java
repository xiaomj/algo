package com.baidu.algo;

import java.util.ArrayList;
import java.util.List;

public class CommonRootOfTowNodes {
    static class Node {
        int data;
        Node left;
        Node right;
    }

    protected Node commonRootOfBST(Node root, int a, int b) {
        if (root == null) {
            return null;
        }
        if (a < root.data && b < root.data) {
            return commonRootOfBST(root.left, a, b);
        }
        if (a > root.data && b > root.data) {
            return commonRootOfBST(root.right, a, b);
        }
        return root;
    }

    protected boolean findPathOfNode(Node root, Node node, List<Node> path) {
        if (root == null) {
            return false;
        }
        if (root.equals(node)) {
            path.add(root);
            return true;
        }
        path.add(root);
        if (findPathOfNode(root.left, node, path) || findPathOfNode(root.right, node, path)) {
            return true;
        }
        path.remove(root);
        return false;
    }

    protected Node commonRootInNormalTree(Node root, Node a, Node b) {
        List<Node> pathOfA = new ArrayList<>();
        List<Node> pathOfB = new ArrayList<>();

        findPathOfNode(root, a, pathOfA);
        findPathOfNode(root, b, pathOfB);

        int i = 0;
        while (i < pathOfA.size() && i < pathOfB.size()
                && pathOfA.get(i).equals(pathOfB.get(i))) {
            i++;
        }
        return pathOfA.get(i);
    }
}
