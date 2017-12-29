package com.baidu.algo;

public class BinarySearch {
    protected int search(int[] arr, int target) {
        if (arr == null) {
            return -1;
        }
        int s = 0;
        int e = arr.length - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (target < arr[mid]) {
                e = mid - 1;
            } else if (target == arr[mid]) {
                return mid;
            } else {
                s = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new BinarySearch().search(new int[]{1, 2, 3, 6, 8}, 1));
    }
}
