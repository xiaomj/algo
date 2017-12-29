package com.baidu.algo;

import java.util.Arrays;

/**
 * 自反性、传递性、对称性
 */
public class JoinArrayToSmallestInt {
    protected void swap(int[] arr, int l, int r) {
        int d = arr[l];
        arr[l] = arr[r];
        arr[r] = d;
    }

    protected boolean compare(int a, int b) {
        return String.format("%d%d", a, b).compareTo(String.format("%d%d", b ,a)) < 0;
    }
    protected int partition(int[] arr, int l, int r) {
        int k = l;
        int pivot = arr[r];
        for (int i = l; i <= r; i++) {
            if (compare(arr[i], pivot)) {
                swap(arr, i, k++);
            }
        }
        swap(arr, r, k);
        return k;
    }

    protected void sort(int[] arr, int l, int r) {
        if (arr == null || l > r) {
            return;
        }
        int m = partition(arr, l, r);
        sort(arr, l, m - 1);
        sort(arr, m + 1, r);
    }

    protected void join(int[] arr) {
        sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = new int[] {321,3,32,4};
        new JoinArrayToSmallestInt().join(arr);
    }
}
