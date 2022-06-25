package com.pupu.project.hard;

import java.util.HashMap;
import java.util.Map;

public class PickSolution {
    Map<Integer, Integer> mapping = new HashMap<>();
    int size;

    public PickSolution(int n, int[] blacklist) {
        for (int b : blacklist) {
            mapping.put(b, -1);
        }
        size = n - blacklist.length;
        int last = n - 1;
        for (int b : blacklist) {
            if (b >= size) {
                continue;
            }
            while (mapping.containsKey(last)) {
                last--;
            }
            mapping.put(b, last);
            last--;
        }
    }

    public int pick() {
        int rand = (int) (Math.random() * size);
        if (mapping.containsKey(rand)) {
            return mapping.get(rand);
        }
        return rand;
    }
}
