package com.baidu.algo;

import java.util.Arrays;

/**
 * Created by baidu on 17/5/4.
 */
public class MergeSort {
//    protected void merge(int[] arr, int[] tmp, int l, int m, int r) {
//        int i = l;
//        int j = m + 1;
//        int k = 0;
//        while (i <= m && j <= r) {
//            if (arr[i] < arr[j]) {
//                tmp[k++] = arr[i++];
//            } else {
//                tmp[k++] = arr[j++];
//            }
//        }
//        while (i <= m) {
//            tmp[k++] = arr[i++];
//        }
//        while (j <= r) {
//            tmp[k++] = arr[j++];
//        }
//        System.arraycopy(tmp, 0, arr, l, k);
//    }
//
//    int[] tmp = new int[100];
//
//    public void mergeSort(int[] arr, int l, int r) {
//        if (l >= r) {
//            return;
//        }
//        int m = (l + r) / 2;
//        mergeSort(arr, l, m);
//        mergeSort(arr, m + 1, r);
//        merge(arr, tmp, l, m ,r);
//    }

    protected void merge(int[] arr, int[] tmp, int l, int r, int a, int b) {
        int i = 0;
        int j = l;
        int k = a;
        while (j <= r && k <= b) {
            if (arr[j] < arr[k]) {
                tmp[i++] = arr[j++];
            } else {
                tmp[i++] = arr[k++];
            }
        }
        while (j <= r) {
            tmp[i++] = arr[j++];
        }
        while (k <= b) {
            tmp[i++] = arr[k++];
        }
        System.arraycopy(tmp, 0, arr, l, i);
    }

    int[] tmp = new int[100];

    protected void mergeSort(int[] arr,int l, int r) {
        if (l >= r) {
            return;
        }
        int m = (l + r) / 2;
        mergeSort(arr, l, m);
        mergeSort(arr, m+1, r);
        merge(arr, tmp, l, m, m+1, r);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{
                3,
                2,
                1
        };
        new MergeSort().mergeSort(arr, 0, 2);
        System.out.println(Arrays.toString(arr));
    }
}
