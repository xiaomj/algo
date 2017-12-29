package com.baidu.algo;

public class UglyNumber {
    protected int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    protected void print(int total) {
        int[] arr = new int[total];
        arr[0] = 2;
        arr[1] = 3;
        arr[2] = 5;

        int iTwo = 0;
        int iThree = 1;
        int iFive = 2;

        int i = 3;
        while (i < total) {
            arr[i] = min(arr[iTwo] * 2, arr[iThree] * 3, arr[iFive] * 5);
            while (arr[iTwo] * 2 <= arr[i]) {
                iTwo++;
            }
            while (arr[iThree] * 3 <= arr[i]) {
                iThree++;
            }
            while (arr[iFive] * 5 <= arr[i]) {
                iFive++;
            }
            i++;
        }
        System.out.println(arr[total - 1]);
    }

    public static void main(String[] args) {
        new UglyNumber().print(1500);
    }
}
