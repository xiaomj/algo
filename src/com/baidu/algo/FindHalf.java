package com.baidu.algo;

public class FindHalf {
//    protected int findLeft(int[] arr, int l, int r, int target) {
//        if (l > r) {
//            return -1;
//        }
//        int mid = (l + r) / 2;
//        if (arr[mid] > arr[mid - 1]) {
//            return mid;
//        }
//        if (arr[mid] < target) {
//            return findLeft(arr, mid + 1, r, target);
//        } else {
//            return findLeft(arr, l, mid - 1, target);
//        }
//    }
//
//    protected int findRight(int[] arr, int l, int r, int target) {
//        if (l > r) {
//            return -1;
//        }
//        int mid = (l + r) / 2;
//        if (arr[mid] < arr[mid + 1]) {
//            return mid;
//        }
//        if (arr[mid] > target) {
//            return findRight(arr, l, mid - 1, target);
//        } else {
//            return findRight(arr, mid + 1, r, target);
//        }
//    }

    protected void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        int d = arr[i];
        arr[i] = arr[j];
        arr[j] = d;
    }

    protected int partition(int[] arr, int l, int r) {
        int k = l;
        int pivot = arr[r];
        for (int i = l; i < r; i++) {
            if (arr[i] < pivot) {
                swap(arr, i, k++);
            }
        }
        swap(arr, k, r);
        return k;
    }

    /**
     * 快速排序找第half数
     * @param arr
     * @return
     */
    protected int findHalfUsingQuickSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int m = 0;
        int l = 0;
        int r = arr.length - 1;
        int half = (arr.length - 1) / 2;

        while (m != half) {
            m = partition(arr, l, r);
            if (m < half) {
                l = m + 1;
            }
            if (m > half) {
                r = m - 1;
            }
        }
        return arr[m];
    }

    /**
     * 消除法找数组中超过一半的值
     * 维护一个全局计数器和全局值
     * @param arr
     * @return
     */
    protected int findHalfUsingDelete(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int count = 0;
        int majority = -1;

        for (int i = 0; i < arr.length; i++) {
            if (count == 0) {
                majority = arr[i];
                count = 1;
            } else if (arr[i] != majority) {
                count--;
            } else {
                count++;
            }
        }
        return majority;
    }

    public static void main(String[] args) {
        System.out.println(new FindHalf().findHalfUsingDelete(new int[]{2,2,1,1,1}));
    }
}
