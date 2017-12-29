package com.baidu.algo;

import java.util.HashMap;
import java.util.Map;

public class Permutation {
    protected void swap(char[] str, int i, int j) {
        if (i == j) {
            return;
        }
        char d = str[i];
        str[i] = str[j];
        str[j] = d;
    }

    protected void print(char[] src, int i) {
        if (i == src.length - 1) {
            System.out.println(src);
            return;
        }
        // 去重了
        Map<Character, Boolean> swapped = new HashMap<>();
        for (int j = i; j < src.length; j++) {
            if (!swapped.containsKey(src[j])) {
                swapped.put(src[j], true);
                swap(src, i, j);
                print(src, i + 1);
                swap(src, i, j);
            }
        }
    }

    public static void main(String[] args) {
        new Permutation().print("abcdcd".toCharArray(), 0);
    }
}
