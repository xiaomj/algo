package com.baidu.algo;

import java.util.Map;

/**
 * Created by baidu on 17/5/5.
 */
public class EditDistance {
//    protected int min(int a, int b, int c) {
//        return Math.min(a, Math.min(b, c));
//    }
//    protected int editDist(String a, String b) {
//        int[][] dist = new int[a.length() + 1][b.length() + 1];
//        for (int i = 0; i < a.length(); i++) {
//            dist[i][0] = i;
//        }
//        for (int j = 0; j < b.length(); j++) {
//            dist[0][j] = j;
//        }
//        for (int i = 1; i < a.length(); i++) {
//            for (int j = 1; j < b.length(); j++) {
//                if (a.charAt(i) == b.charAt(j)) {
//                    dist[i][j] = dist[i-1][j-1];
//                } else {
//                    dist[i][j] = min(dist[i-1][j-1] + 1, dist[i-1][j] + 1, dist[i][j-1] + 1);
//                }
//            }
//        }
//        return dist[a.length()-1][b.length()-1];
//    }

    protected int min(int a, int b, int c) {
        return Math.min(a, Math.min(b,c));
    }
    protected int editDist(String src, String dst) {
        int a[][] = new int[src.length()][dst.length()];
        for (int i = 0; i < src.length(); i++) {
            a[i][0] = i;
        }
        for (int j = 0; j < dst.length(); j++) {
            a[0][j] = j;
        }
        for (int i = 1; i < src.length(); i++) {
            for (int j = 1; j < dst.length(); j++) {
                if (src.charAt(i) == dst.charAt(j)) {
                    a[i][j] = a[i-1][j-1];
                } else {
                    a[i][j] = min(a[i-1][j-1] + 1,a[i-1][j] + 1, a[i][j-1]+1);
                }
            }
        }
        return a[src.length()-1][dst.length()-1];
    }

    public static void main(String[] args) {
        int dist = new EditDistance().editDist("wwxaca", "wabc");
        System.out.println(dist);
    }
}
