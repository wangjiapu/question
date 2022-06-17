package com.pupu.project.hard;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MinWindow {

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
                    window.put(d,window.get(d)-1);
                }

            }

        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start+len);
    }
}
