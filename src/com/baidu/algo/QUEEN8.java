package com.baidu.algo;

import java.util.Arrays;

public class QUEEN8 {
    protected void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        int d = arr[i];
        arr[i] = arr[j];
        arr[j] = d;
    }

    // o(n*n)
    boolean check(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] - arr[j] == i - j || arr[i] - arr[j] == j - i) {
                    return false;
                }
            }
        }
        return true;
    }

    protected void list(int[] arr, int depth) {
        if (depth == arr.length - 1) {
            if (check(arr)) {
                System.out.println(Arrays.toString(arr));
            }
            return;
        }
        for (int i = depth; i < arr.length; i++) {
            swap(arr, depth, i);
            if (depth < arr.length - 1) {
                list(arr, depth + 1);
            }
            swap(arr, depth, i);
        }
    }

    public static void main(String[] args) {
        new QUEEN8().list(new int[] {1,2,3,4,5,6,7,8}, 0);
    }
}
