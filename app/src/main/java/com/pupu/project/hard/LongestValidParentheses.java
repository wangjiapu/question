package com.pupu.project.hard;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int maxValue=0;
        int leftNum=0;
        int rightNum=0;
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='('){
                leftNum++;
            }else{
                rightNum++;
            }
            if (rightNum==leftNum){
                maxValue=Math.max(rightNum*2,maxValue);
            }
            if (rightNum>leftNum){
                leftNum=rightNum=0;
            }
        }
        leftNum=rightNum=0;
        for (int i=s.length()-1;i>=0;i--){
            if (s.charAt(i)=='('){
                leftNum++;
            }else{
                rightNum++;
            }
            if (rightNum==leftNum){
                maxValue=Math.max(rightNum*2,maxValue);
            }
            if (leftNum>rightNum){
                leftNum=rightNum=0;
            }
        }
        return maxValue;
    }
}
