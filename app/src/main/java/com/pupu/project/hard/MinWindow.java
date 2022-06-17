package com.pupu.project.hard;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MinWindow {


    /**
     * 76. 最小覆盖子串
     *
     * @param s
     * @param t
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public String minWindow1(String s, String t) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for (char ct : t.toCharArray()) {
            need.put(ct, need.getOrDefault(ct, 0) + 1);
        }

        int count = 0;

        int left = 0;
        int right = 0;

        int start = 0;
        int len = Integer.MAX_VALUE;

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (Objects.equals(window.get(c), need.get(c))) {
                    count++;
                }
            }

            while (count == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (Objects.equals(window.get(d), need.get(d))) {
                        count--;
                    }
                    window.put(d, window.get(d) - 1);
                }

            }

        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    /**
     * 567. 字符串的排列
     *
     * @param s1
     * @param s2
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> target = new HashMap<>();
        for (char c : s1.toCharArray()) {
            target.put(c, target.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int count = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            if (target.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (Objects.equals(window.get(c), target.get(c))) {
                    count++;
                }
            }
            while (right - left >= s1.length()) {
                if (count == target.size()) {
                    return true;
                }
                char d = s2.charAt(left);
                left++;
                if (target.containsKey(d)) {
                    if (Objects.equals(window.get(d), target.get(d))) {
                        count--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return false;
    }

    /**
     * 438. 找到字符串中所有字母异位词
     * @param s
     * @param p
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> target = new HashMap<>();
        for (char c : p.toCharArray()) {
            target.put(c, target.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int count = 0;
        while (right < s.length()) {
            char ch = s.charAt(right);
            right++;
            if (target.containsKey(ch)) {
                window.put(ch, window.getOrDefault(ch, 0) + 1);
                if (Objects.equals(window.get(ch), target.get(ch))) {
                    count++;
                }
            }
            while (right - left >= p.length()) {
                if (count == target.size()) {
                    res.add(left);
                }
                char d = s.charAt(left);
                left++;
                if (target.containsKey(d)) {
                    if (Objects.equals(window.get(d), target.get(d))) {
                        count--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return res;
    }

}
