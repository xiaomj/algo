package com.baidu.algo;

import java.util.ArrayList;
import java.util.List;

public class MHashMap {
    static class Node {
        Node next;
        Object data;
    }

    static final int SIZE = 11;
    List<List<Node>> elements = new ArrayList<>();

    public void put(String key, Object object) {
        if (key == null || object == null) {
            return;
        }
        int hash = key.hashCode() % SIZE;
        int i = 0;
        List<Node> nodes = elements.get(hash);
        if (nodes == null) {
            nodes = new ArrayList<>();
        }
        for (i = 0; i < nodes.size(); i++) {

        }
    }

}
