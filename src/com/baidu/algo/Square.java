package com.baidu.algo;

public class Square {
    protected double square(double a, double b, int target, int n) {
        double half = (a + b) / 2.0;
        if (n == 0) {
            return half;
        }
        if (half * half > target) {
            return square(a, half, target, --n);
        } else if (half * half == target) {
            return half;
        } else {
            return square(half, b, target, --n);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Square().square(0, 10, 10, 10));
    }
}
