package com.baidu.algo;

import java.util.Arrays;

public class Prime {
    protected void printBetter(int max) {
        int[] prime = new int[max + 1];
        int total = 0;
        int[] map = new int[max +1 ];
        map[2] = 0;
        for (int i = 2; i < max; i++) {
            if (map[i] == 0) {
                prime[total++] = i;
            }
            for (int j = 0; j < total && prime[j] * i < max; j++) {
                map[prime[j] * i] = 1;
                if (i % prime[j] == 0) {
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(prime));
    }

    protected void print(int max) {
        // 0表示质数，1表示合数
        int[] map = new int[max + 1];
        map[0] = 1;
        map[1] = 1;
        map[2] = 0;
        for (int i = 2; i < max; i++) {
            if (map[i] == 0)  {
                for (int j = i; i * j < max; j++) {
                    map[i * j] = 1;
                }
            }
        }
        for (int i = 2; i < max; i++) {
            if (map[i] == 0) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        new Prime().printBetter(1000);
    }
}
