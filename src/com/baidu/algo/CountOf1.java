package com.baidu.algo;

public class CountOf1 {
    // n位数
    protected int count(int n) {
        if (n == 1) {
            return 1;
        }
        return count(n - 1) * 9 + (int) Math.pow(10, n - 1);
    }

//    protected int countUntil(int m) {
//
//    }
}
