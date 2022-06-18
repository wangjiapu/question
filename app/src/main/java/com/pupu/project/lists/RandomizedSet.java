package com.pupu.project.lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 380. O(1) 时间插入、删除和获取随机元素
 */
public class RandomizedSet {
    private List<Integer> nums;
    private Map<Integer, Integer> val2Index;

    public RandomizedSet() {
        nums = new ArrayList<>();
        val2Index = new HashMap<>();
    }

    public boolean insert(int val) {
        if (val2Index.containsKey(val)) {
            return false;
        }
        val2Index.put(val, nums.size());
        nums.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!val2Index.containsKey(val)) {
            return false;
        }
        int index = val2Index.get(val);
        val2Index.remove(val);
        int a = nums.remove(nums.size()-1);
        if (a!=val){
            nums.set(index,a);
            val2Index.put(a,index);
        }
        return true;
    }

    public int getRandom() {
        return nums.get((int) (Math.random() * nums.size()));
    }

//    private void swap(int a, int b) {
//        a = a ^ b;
//        b = a ^ b;
//        a = a ^ b;
//    }
}
