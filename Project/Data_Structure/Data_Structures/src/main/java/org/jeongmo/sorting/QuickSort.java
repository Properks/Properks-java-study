package org.jeongmo.sorting;

public class QuickSort extends Sort{

    @Override
    <T extends Comparable<T>> T[] sort(T[] list) {
        long startedTime = System.nanoTime();
        quickSort(list, 0, list.length - 1);
        time = System.nanoTime() - startedTime;
        return list;
    }

    /**
     * QuickSort with recursive
     *
     * @param <T> The class extends comparable
     * @param list The list(Array form) to be sorted
     * @param left The first index of list
     * @param right The last index of list
     */
    private <T extends Comparable<T>> void quickSort(T[] list, int left, int right) {
        if (left < right) {
            int pivot = partition(list, left, right);
            quickSort(list, left, pivot - 1);
            quickSort(list, pivot + 1, right);
        }
    }

    /**
     * Divide and conquer, return pivot. pivot: most left element
     *
     * @param list The sublist of list(Array form) to be sorted
     * @param left The first index of sublist
     * @param right The last index of sublist
     *
     * @return Return index of pivot
     */
    private <T extends Comparable<T>> int partition(T[] list, int left, int right) {
        int pivotIndex = left;
        T pivot = list[left++];

        while (left <= right) {
            while (left <= right && pivot.compareTo(list[left]) >= 0) {
                left++;
            }
            while (left <= right && pivot.compareTo(list[right]) <= 0) {
                right--;
            }
            if (left <= right) {
                swap(list, left, right);
            }
        }
        swap(list, pivotIndex, right);
        return right;
    }
}
