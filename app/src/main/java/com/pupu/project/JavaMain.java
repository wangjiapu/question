package com.pupu.project;

import com.pupu.project.solutions.IntToRoman;
import com.pupu.project.sort.HeapSort;
import com.pupu.project.sort.QuicklySort;
import com.pupu.project.topk.TopKFrequent;

import java.util.Arrays;

public class JavaMain {

    /**
     * .idea/gradle.xml中添加<option name="delegatedBuild" value="false" />
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] list = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] test = {3,1};
        int[] test2 = {3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6};
        System.out.println(Arrays.toString(new QuicklySort().sort(test2)));
    }

    public static String listToString(int[] list) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int item : list) {
            stringBuilder.append(item).append(',');
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
