package com.baidu.algo;

import java.util.HashSet;

public class TwoSum {
    protected void twoSum(int[] arr, int sum) {
        HashSet<Integer> set = new HashSet<>();
        for (int ele: arr) {
            set.add(ele);
        }
        for (int ele: arr) {
            if (set.contains(sum - ele)) {
                set.remove(ele);
                set.remove(sum - ele);
                System.out.println(String.valueOf(ele) + " " + String.valueOf(sum - ele));
            }
        }
    }

    protected void twoSumUsingSort(int[] arr, int sum) {

    }

    public static void main(String[] args) {
        int[] arr = new int[]{
                1,2,3,4,4,10
        };
        new TwoSum().twoSum(arr, 7);
    }
}
