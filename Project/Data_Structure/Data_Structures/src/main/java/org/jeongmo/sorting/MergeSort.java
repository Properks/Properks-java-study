package org.jeongmo.sorting;

import java.util.Arrays;

public class MergeSort extends Sort{

    @Override
    public <T extends Comparable<T>> T[] sort(T[] list) {
        doSort(list, 0, list.length - 1);
        return list;
    }

    private <T extends Comparable<T>> void doSort(T[] list, int start, int end) {
        if (start == end) {
            return;
        }

        int mid = (start + end) / 2;
        doSort(list, start, mid);
        doSort(list, mid + 1, end);
        merge(list, start, mid, mid + 1, end);
    }

    private <T extends Comparable<T>>void merge(T[] list, int leftStart, int leftEnd, int rightStart, int rightEnd) {
        T[] leftList = Arrays.copyOfRange(list, leftStart, leftEnd + 1);
        T[] rightList= Arrays.copyOfRange(list, rightStart, rightEnd + 1);
        int leftIndex = 0;
        int rightIndex = 0;
        int listIndex = leftStart;

        while (leftIndex < leftList.length && rightIndex < rightList.length) {
            if (leftList[leftIndex].compareTo(rightList[rightIndex]) > 0) {
                list[listIndex++] = rightList[rightIndex++];
            }
            else {
                list[listIndex++] = leftList[leftIndex++];
            }
        }

        while (listIndex <= rightEnd) {
            if (leftList.length > leftIndex) {
                list[listIndex++] = leftList[leftIndex++];
            }
            else if (rightList.length > rightIndex) {
                list[listIndex++] = rightList[rightIndex++];
            }
        }
    }
}
