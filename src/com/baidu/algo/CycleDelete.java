package com.baidu.algo;

import java.util.ArrayList;
import java.util.List;

public class CycleDelete {
    protected int delete(List<Integer> arr, int m) {
        int i = 0;
        int count = 0;

        while (count < m) {
            i = (i + 1) % arr.size();
            count++;
        }
        return arr.remove(i);
    }

    protected int cycleDelete(List<Integer> arr, int m) {
        if (arr == null || arr.size() == 0) {
            return -1;
        }
        while (arr.size() > 1) {
            delete(arr, m - 1);
        }
        return arr.get(0);
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
//        arr.add(1);
//        arr.add(2);
//        arr.add(5);
//        arr.add(9);
        System.out.println(new CycleDelete().cycleDelete(arr, 3));
    }
}
