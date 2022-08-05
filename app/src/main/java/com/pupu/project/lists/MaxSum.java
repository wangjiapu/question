package com.pupu.project.lists;

public class MaxSum {
    public int findMaxPrice(int[] arr) {
        int maxValue = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        while (rightIndex < arr.length) {
            if (arr[rightIndex] - arr[leftIndex] > maxValue) {
                maxValue = arr[rightIndex] - arr[leftIndex];
            }
            if (arr[rightIndex] < arr[leftIndex]) {
                leftIndex = rightIndex;
            }
            rightIndex++;
        }
        return maxValue;
    }
}
