package org.jeongmo.sorting;

import java.util.Arrays;

public class MergeSort extends Sort{

    @Override
    public <T extends Comparable<T>> T[] sort(T[] list) {
        long startedTime = System.nanoTime();
        mergeSort(list, 0, list.length - 1);
        this.time = System.nanoTime() - startedTime;
        return list;
    }

    private <T extends Comparable<T>> void mergeSort(T[] list, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(list, left, mid);
            mergeSort(list, mid + 1, right);
            merge(list, left, mid, right);
        }
    }

    private <T extends Comparable<T>> void merge(T[] list, int left, int mid, int right) {
        T[] newList = Arrays.copyOfRange(list, left, right);
        int leftIndex = 0;
        int rightIndex = mid - left + 1;
        while (left <= right) {
            while (left <= mid && rightIndex > right) {
                list[left++] = newList[leftIndex++];
            }
            while (left > mid && rightIndex <= right) {
                list[left++] = newList[rightIndex++];
            }
            list[left++] = (newList[leftIndex].compareTo(newList[rightIndex]) <= 0) ?
                    newList[leftIndex++] : newList[rightIndex];
        }
    }
}
