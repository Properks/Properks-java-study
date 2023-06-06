package org.jeongmo.sorting;

public class QuickSort implements SortAlgorithm{

    @Override
    public <T extends Comparable<T>> T[] sort(T[] list) {
        doSort(list, 0, list.length - 1);
        return list;
    }

    private <T extends Comparable<T>> void doSort(T[] list, int left, int right) {

        if (left > right) {
            return;
        }
        int mid = quickSort(list, left, right);
        doSort(list, mid + 1, right);
        doSort(list, left, mid - 1);
    }

    private <T extends Comparable<T>> int quickSort(T[] list, int start, int end) {
        T pivot = list[start];
        int left = start + 1;
        int right = end;

        while (left <= right) {
            while ((list[right].compareTo(pivot) > 0 ) && (left <= right))
                right--;

            while ((list[left].compareTo(pivot) < 0 ) && (left <= right))
                left++;

            if(left <= right) {
                UtilForSort.swap(list, left, right);
            }
        }
        UtilForSort.swap(list, start, right);
        return right;
    }
}
