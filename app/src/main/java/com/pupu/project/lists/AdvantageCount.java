package com.pupu.project.lists;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class AdvantageCount {
    /**
     * 870. 优势洗牌
     * @param nums1
     * @param nums2
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        for (int i = 0; i < n; i++) {
            queue.offer(new int[]{i, nums2[i]});
        }
        Arrays.sort(nums1);
        int left = 0;
        int right = n - 1;
        int[] res = new int[n];
        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            int i = pair[0];
            int maxval = pair[1];
            if (maxval < nums1[right]) {
                res[i] = nums1[right];
                right--;
            } else {
                res[i] = nums1[left];
                left++;
            }
        }
        return res;
    }
}
