package com.baidu.algo;

import java.util.Arrays;

public class ThreeEqualOfCube {
    // 0 1 2 3 = 4 5 6 7
    // 1 3 5 7 = 0 2 4 6
    // 1 2 6 7 = 0 1 4 5
    protected boolean check(int[] arr) {
        if (arr[0] + arr[1] + arr[2] + arr[3] == arr[4] + arr[5] + arr[6] + arr[7]
                && arr[1] + arr[3] + arr[5] + arr[7] == arr[0] + arr[2] + arr[4] + arr[6]
                && arr[1] + arr[2] + arr[6] + arr[7] == arr[0] + arr[1] + arr[4] + arr[5]) {
            return true;
        }

        return false;
    }

    protected void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        int d = arr[i];
        arr[i] = arr[j];
        arr[j] = d;
    }

    protected void find(int[] arr, int depth) {
        if (arr.length - 1 == depth) {
            if (check(arr)) {
                System.out.println(Arrays.toString(arr));
            }
            return;
        }
        for (int i = depth; i < arr.length - 1; i++) {
            swap(arr, i, depth);
            find(arr, depth + 1);
            swap(arr, i, depth);
        }
    }

    public static void main(String[] args) {
        new ThreeEqualOfCube().find(new int[] {1, 2, 3, 4, 5, 6, 7, 8}, 0);
    }
}
