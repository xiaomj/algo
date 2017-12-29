package com.baidu.algo;

import java.io.File;
import java.util.Arrays;

/**
 * Created by baidu on 17/5/5.
 */
public class QuickSort {
//    protected void swap(int[] arr, int i, int j) {
//        int t = arr[i];
//        arr[i] = arr[j];
//        arr[j] = t;
//    }
//
//    protected int partition(int[] arr, int l, int r) {
//        int i = l;
//        int pivot = arr[r];
//        int k = l;
//        for (i = l; i < r; i++) {
//            if (arr[i] < pivot) {
//                swap(arr, i, k);
//                k++;
//            }
//        }
//        swap(arr, k, r);
//        return k;
//    }
//
//    protected void sort(int[] arr, int l, int r) {
//        if (l >= r) {
//            return;
//        }
//        int m = partition(arr, l, r);
//        sort(arr, l, m - 1);
//        sort(arr, m + 1, r);
//    }

    public static void main(String[] args) {
        int[] arr = new int[] {2,3,1,2,4,5};
        new QuickSort().sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    protected void swap(int[] arr, int l, int r) {
        int d = arr[l];
        arr[l] = arr[r];
        arr[r] = d;
    }

    protected int partition(int[] arr, int l, int r) {
        int pivot = arr[r];
        int i = l;
        int k = l;
        for (i = l; i < r; i++) {
            if (arr[i] < pivot) {
                swap(arr, i, k++);
            }
        }
        swap(arr, k, r);
        return k;
    }

    protected void sort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int m = partition(arr, l, r);
        sort(arr, l, m - 1);
        sort(arr, m + 1, r);
    }
}
