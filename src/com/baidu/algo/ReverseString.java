package com.baidu.algo;

import java.util.Arrays;

public class ReverseString {
    protected void swap(char[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        char ch = arr[i];
        arr[i] = arr[j];
        arr[j] = ch;
    }

    protected void reverseCore(char[] arr, int l, int r) {
        while (l < r) {
            swap(arr, l, r);
            l++;
            r--;
        }
    }

//    protected void reverse(char[] arr, int l, int r) {
//        if (arr == null || arr.length == 0 || l >= r) {
//            return;
//        }
//        int s = l;
//        int e = r;
//        while (arr[s] == ' ' && s < r) {
//            s++;
//        }
//        if (s == r) {
//            return;
//        }
//        e = s;
//        while (arr[e] != ' ' && e < r) {
//            e++;
//        }
//        if (arr[e] == ' ') {
//            e--;
//        }
//        reverseCore(arr, s, e);
//        reverse(arr, e + 1, r);
//    }

    protected void reverse(char[] arr) {

    }

    public static void main(String[] args) {
        char[] arr = "abc def acd".toCharArray();
//        new ReverseString().reverse(arr, 0, arr.length - 1);
        Integer.valueOf("1");
        System.out.println(Arrays.toString(arr));
    }
}
