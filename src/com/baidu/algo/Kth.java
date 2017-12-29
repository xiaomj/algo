package com.baidu.algo;

import java.util.Arrays;

public class Kth {
    protected int kth(int[] arr, int k) {
//        if (l > r) {
//            return ;
//        }
//        if (arr == null) {
//            return ;
//        }
//        int m = partition(arr, l, r);
//        if (m == k) {
//            return;
//        }
//        if (m < k) {
//            kth(arr, k - m, m + 1, r);
//        }
//        kth(arr, k, l, m - 1);
        if (arr.length == 0 || arr == null) {
            return -1;
        }

        if (k >= arr.length) {
            return -1;
        }

        int m = 0;
        int l = 0;
        int r = arr.length - 1;

        k = k - 1;
        while (m != k) {
            m = partition(arr, l, r);
            if (m > k) {
                r = m - 1;
            } else if (m < k) {
                l = m + 1;
            }
        }
        return arr[m];
    }

    protected void swap(int[] arr, int l, int r) {
        int d = arr[l];
        arr[l] = arr[r];
        arr[r] = d;
    }

    protected int partition(int[] arr, int l, int r) {
        int i = l;
        int k = l;
        int pivot = arr[r];

        for (i = l; i <= r; i++) {
            if (arr[i] < pivot) {
                swap(arr, i, k++);
            }
        }
        swap(arr, k, r);
        return k;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10,8,3,1,5,12,7};
        System.out.println(new Kth().kth( arr,4));
    }
}
