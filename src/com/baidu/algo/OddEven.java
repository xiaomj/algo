package com.baidu.algo;

import java.util.Arrays;

public class OddEven {
    protected void swap(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int d = arr[l];
        arr[l] = arr[r];
        arr[r] = d;
    }
    protected void moveOdd(int[] arr) {
        int l = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 1) {
                swap(arr, i, l++);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        new OddEven().moveOdd(arr);
        System.out.println(Arrays.toString(arr));
    }
}
