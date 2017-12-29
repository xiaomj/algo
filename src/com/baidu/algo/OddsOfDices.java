package com.baidu.algo;

import java.util.HashMap;
import java.util.Map;

public class OddsOfDices {
    protected void calcOdds(int num) {
        Map<Integer, Integer> count = new HashMap<>();
        count.put(1, 1);
        count.put(2, 1);
        count.put(3, 1);
        count.put(4, 1);
        count.put(5, 1);
        count.put(6, 1);
        // 每一轮迭代
        for (int i = 1; i < num; i++) {
            Map<Integer, Integer> newCount = new HashMap<>();
            // 骰子每一面的可能点数
            for (int j = 1; j <= 6; j++) {
                // 上一轮的点数所有可能次数
                for (Integer key : count.keySet()) {
                    Integer newKey = key + j;
                    if (newCount.containsKey(newKey)) {
                        newCount.put(newKey, newCount.get(newKey) + count.get(key));
                    } else {
                        newCount.put(newKey, count.get(key));
                    }
                }
            }
            count.clear();
            count.putAll(newCount);
        }
        for (Integer key: count.keySet()) {
            System.out.println(key + " " + count.get(key));
        }
    }

    public static void main(String[] args) {
        new OddsOfDices().calcOdds(2);
    }
}
