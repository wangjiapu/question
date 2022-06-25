package com.pupu.project.sort;

public class HeapSort2 {
    public int[] sort(int[] list) {
        buildHeap(list);
        for (int j = list.length - 1; j >= 0; j--) {
            swap(list, 0, j);
            heapfiy(list, j);
        }
        return list;
    }


    private void heapfiy(int[] list, int heapSize) {
        int temp = 0;
        int left = getLeftChild(temp);
        while (left < heapSize) {
            int swapIndex = left + 1 < heapSize && list[left + 1] > list[left] ? left + 1 : left;
            swapIndex = list[temp] < list[swapIndex] ? swapIndex : temp;
            if (swapIndex == temp) {
                break;
            }
            swap(list, temp, swapIndex);
            temp = swapIndex;
            left = getLeftChild(temp);
        }
    }

    private void buildHeap(int[] list) {
        int temp;
        for (int i = 0; i < list.length; i++) {
            temp = i;
            while (list[temp] > list[getFather(temp)]) {
                swap(list, getFather(temp), temp);
                temp = getFather(temp);
            }
        }
    }

    private void swap(int[] list, int firstIndex, int j) {
        list[firstIndex] = list[firstIndex] ^ list[j];
        list[j] = list[firstIndex] ^ list[j];
        list[firstIndex] = list[firstIndex] ^ list[j];
    }

    private int getLeftChild(int i) {
        return 2 * i + 1;
    }

    private int getRightChild(int i) {
        return 2 * i + 2;
    }

    private int getFather(int i) {
        return (i - 1)/2;
    }
}
