package com.pupu.project.sort;

public class HeapSort {

    public int[] sort(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp = i;
            while (nums[temp] > nums[fatherIndex(temp)]) {
                swap(nums, temp, fatherIndex(temp));
                temp = fatherIndex(temp);
            }
        }

        for (int j = nums.length - 1; j >= 0; j--) {
            temp = 0;
            swap(nums, j, temp);
            int leftChild = leftChildIndex(temp);//有孩子
            while (leftChild < j) {//不能相等
                int swapIndex = leftChild + 1 < j && nums[leftChild + 1] > nums[leftChild] ? leftChild + 1 : leftChild;
                swapIndex = nums[swapIndex] > nums[temp] ? swapIndex : temp;
                if (swapIndex == temp) {
                    break;
                }
                swap(nums, swapIndex, temp);
                temp = swapIndex;
                leftChild = leftChildIndex(temp);
            }
        }

        return nums;
    }

    private int leftChildIndex(int fatherIndex) {
        return fatherIndex * 2 + 1;
    }

    private int rightChildIndex(int fatherIndex) {
        return fatherIndex * 2 + 2;
    }

    private int fatherIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
