package com.pupu.project.solutions;

public class LongestPalindrome {
    public String longestPalindrome(String s) {

        if (s == null || s.length() < 2) {
            return s;
        }
        int len = s.length();
        int maxLen = 1;
        int startIndex = 0;

        boolean[][] resultArr = new boolean[len][len];
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                //                if (s.charAt(i)!=s.charAt(j)){
                //                    resultArr[i][j] = false;
                //                }else {
                //                    if (j-i<3){
                //                        resultArr[i][j]=true;
                //                    }else{
                //                        resultArr[i][j]=resultArr[i+1][j-1];
                //                    }
                //                }
                resultArr[i][j] = s.charAt(i) == s.charAt(j) &&
                        (j - i < 3 || resultArr[i + 1][j - 1]);
                if (resultArr[i][j] && maxLen < (j - i + 1)) {
                    maxLen = j - i + 1;
                    startIndex = i;
                }
            }
        }

        return s.substring(startIndex, startIndex + maxLen);
    }

    public boolean isPalindrome(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean isPalindrome(char[] chars, int start, int end) {

        while (start < end) {
            if (chars[start] != chars[end])
                return false;
            start++;
            end--;
        }
        return true;
    }

    public boolean isPalindrome(int x) {
        if (x<0){
            return false;
        }
        int y = 0;
        int s = x;
        while (x != 0) {
            y = y * 10 + x % 10;
            x = x / 10;
        }
        return y == s;
    }
}
