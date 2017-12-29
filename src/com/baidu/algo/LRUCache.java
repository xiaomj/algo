package com.baidu.algo;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Created by baidu on 17/5/7.
 */
public class LRUCache {
    static class Node {
        public Integer id;
        public Integer value;
        public Node next;
        public Node pre;

        public Node(Integer id, Integer value) {
            this.id = id;
            this.value = value;
        }
    };

    static class DoubleLinkedList {
        Node end;
        Node first;
        int sum = 0;
        int capacity = 10;

        public DoubleLinkedList(int c) {
            capacity = c;
        }

        public void takeToFirst(Node node) {
            unlink(node);
            addAtFirst(node);
        }

        public void unlink(Node node) {
            if (node.next != null) {
                node.next.pre = node.pre;
            }
            if (node.pre != null) {
                node.pre.next = node.next;
            }
            if (first == node) {
                first = node.next;
            } else if (first == end) {
                end = node.pre;
            }
            sum--;
        }

        public void addAtFirst(Node node) {
            if (first == null) {
                end = node;
                first = node;
            } else {
                node.next = first;
                first.pre = node;
                first = node;
            }
            sum++;
        }

        public void addToFirst(Node node) {
            if (sum == capacity) {
                unlink(end);
            }
            addAtFirst(node);
        }

        public void print() {
            Node node = first;
            while (node.next != null) {
                System.out.println(node.id + "");
            }
        }
    }

    protected HashMap<Integer, Node> m;
    protected DoubleLinkedList list;

    public void put(int key, int value) {
        if (m.containsKey(key)) {
            Node node = m.get(key);
            list.takeToFirst(node);
        } else {
            Node node = new Node(key, value);
            m.put(key, node);
            list.addToFirst(node);
        }
        list.print();
    }

    public int get(int key) {
        if (m.containsKey(key)) {
            Node node = m.get(key);
            list.takeToFirst(node);
            list.print();
            return node.value;
        } else {
            list.print();
            return -1;
        }

    }

    public LRUCache(int capacity) {
        list = new DoubleLinkedList(capacity);
        m = new HashMap<>();
    }

    public static void main(String[] args) {
//        LRUCache cache = new LRUCache( 2 /* capacity */ );
//
//        cache.put(1, 1);
//        cache.put(2, 2);
//        System.out.println(cache.get(1));       // returns 1
//        cache.put(3, 3);    // evicts key 2
//        System.out.println(cache.get(2));       // returns -1 (not found)
//        cache.put(4, 4);    // evicts key 1
//        System.out.println(cache.get(1));       // returns -1 (not found)
//        System.out.println(cache.get(3));       // returns 3
//        System.out.println(cache.get(4));       // returns 4

        LinkedHashSet map = new LinkedHashSet();
        map.add("1");
        LinkedHashMap map1 = new LinkedHashMap();

        System.out.println(map.contains("1"));
    }
}
