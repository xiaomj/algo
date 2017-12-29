package com.baidu.algo;

public class MergeTwoList {
    static class Node {
        Node next;
        int data;
    }

    protected Node merge(Node a, Node b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        if (a.data < b.data) {
            Node subHead = merge(a.next, b);
            a.next = subHead;
            return a;
        }
        Node subHead = merge(b.next, a);
        b.next = subHead;
        return b;
    }

    public static void main(String[] args) {
        Node head = new Node();
        head.data = 1;
        Node a = new Node();
        a.data = 2;
        head.next = a;

        Node head2 = new Node();
        head2.data = 3;
        Node a2 = new Node();
        a2.data = 4;
        head2.next = a2;

        Node newHead = new MergeTwoList().merge(head, head2);
        while (newHead.next != null) {
            System.out.println(newHead.data);
            newHead = newHead.next;
        }
        System.out.println(newHead.data);
    }
}
