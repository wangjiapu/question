package com.pupu.project.solutions;


import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class SubString {

    public int lengthOfLongestSubstring(String s) {
//
//        //窗口的最大长度
//        int maxLength = 0;
//        //窗口集合
//        Set<Character> window = new HashSet<>();
//        int left = 0;// 窗口的左边界
//        int right = 0;// 窗口的右边界
//        while (right < s.length()) {
//            // 如果窗口中包含当前元素，说明出现了重复，
//            // 把窗口最左端的给移除掉，直到窗口不包含当前元素即可
//            while (window.contains(s.charAt(right)))
//                window.remove(s.charAt(left++));
//            //把当前元素添加到窗口中
//            window.add(s.charAt(right++));
//            //更新窗口的长度
//            maxLength = Math.max(maxLength, right - left);
//        }
//        return maxLength;


        int[] m = new int[128];
        int max = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            left = Math.max(m[s.charAt(right)], left);
            m[s.charAt(right)] = right + 1;
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    /**
     * 3. 无重复字符的最长子串
     * @param s
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public int lengthOfLongestSubstring2(String s) {
        int res = 0;
        Map<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char ch = s.charAt(right);
            right++;
            window.put(ch, window.getOrDefault(ch, 0) + 1);

            while (window.get(ch) > 1) {
                char d = s.charAt(left);
                left++;
                window.put(d, window.getOrDefault(d, 0) - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;
    }

}
