package com.baidu.algo;

public class MaxSumOfArray {
    protected int max(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[] sum = new int[arr.length];
        sum[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (sum[i - 1] > 0) {
                sum[i] = sum[i - 1] + arr[i];
            } else {
                sum[i] = arr[i];
            }
        }
        return sum[arr.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new MaxSumOfArray().max(new int[]{1, 2, -4, 3}));
    }
}
