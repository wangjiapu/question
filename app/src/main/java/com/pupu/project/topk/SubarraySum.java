package com.pupu.project.topk;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int res = 0;
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int sum2 = sum - k;
            if (map.containsKey(sum2)) {
                res += map.get(sum2);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

    public int subarraySum1(int[] nums, int k) {
        int len = nums.length;
        int[] preNums = new int[len + 1];
        preNums[0] = 0;
        for (int i = 0; i < len; i++) {
            preNums[i + 1] = nums[i] + preNums[i];
        }
        int res = 0;

        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <i; j++) {
                if (preNums[i] - preNums[j] == k) {
                    res++;
                }
            }
        }

        return res;
    }
}
