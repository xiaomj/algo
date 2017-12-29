package com.baidu.algo;

public class SqueezeSpaceInString {
    protected void squeeze(String str) {
        int k = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ' && i != k) {
                // 用C语言
//                str.charAt(k) = str.charAt(i);
                k++;
            }
        }
    }
}
