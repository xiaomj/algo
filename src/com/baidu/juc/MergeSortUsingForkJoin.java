package com.baidu.juc;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class MergeSortUsingForkJoin {
    static class MergeSortTask extends RecursiveAction {
        private int[] arr;
        private int l;
        private int r;

        public MergeSortTask(int[] arr, int l, int r) {
            this.arr = arr;
            this.l = l;
            this.r = r;
        }

        protected void merge(int[] arr, int l, int m, int r) {
            int i = l;
            int j = m + 1;
            int[] tmp = new int[r - l + 1];
            int k = 0;
            while (i <= m && j <= r) {
                if (arr[i] < arr[j]) {
                    tmp[k++] = arr[i++];
                } else {
                    tmp[k++] = arr[j++];
                }
            }
            while (i <= m) {
                tmp[k++] = arr[i++];
            }
            while (j <= r) {
                tmp[k++] = arr[j++];
            }
            System.arraycopy(tmp, 0, arr, l, r - l + 1);
        }

        public void compute() {
            if (l >= r) {
                return;
            }
            int mid = (l + r) / 2;
            MergeSortTask left = new MergeSortTask(arr, l, mid);
            MergeSortTask right = new MergeSortTask(arr, mid + 1, r);
            left.fork();
            right.fork();
            left.join();
            right.join();
            merge(arr, l, mid, r);
        }
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        int[] arr = new int[]{10, 1, 2, 1, 3, 10, 110, 12, 1212, 1212};
        pool.invoke(new MergeSortTask(arr, 0, arr.length - 1));
        System.out.println(Arrays.toString(arr));
        ConcurrentHashMap
    }
}
