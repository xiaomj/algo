package com.baidu.algo;

public class ValueOf {
    protected int valueOf(String str) {
        int sum = 0;
        int minus = 1;
        int i = 0;

        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }

        if (str.charAt(i) == '+') {
            i++;
        }
        if (str.charAt(i) == '-') {
            i++;
            minus = -1;
        }
        while (i < str.length()) {
            if (str.charAt(i) <= '9' && str.charAt(i) >= '0') {
                sum = sum * 10 + str.charAt(i) - '0';
                if (sum < 0) {
                    throw new Error("Overflow");
                }
            } else {
                break;
            }
            i++;
        }
        return sum * minus;
    }

    public static void main(String[] args) {
        System.out.println(new ValueOf().valueOf("-10BC2"));
        System.out.println(new ValueOf().valueOf("-101111"));
        System.out.println(new ValueOf().valueOf("111111111111111111111111111111111111111"));
        System.out.println(new ValueOf().valueOf("-10BC2"));
    }
}
