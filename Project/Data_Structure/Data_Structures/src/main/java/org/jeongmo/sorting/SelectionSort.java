package org.jeongmo.sorting;

public class SelectionSort implements SortAlgorithm{

    @Override
    public <T extends Comparable<T>> T[] sort(T[] list) {
        for (int i = 0; i < list.length; i++) {
            for (int j = i; j < list.length; j++) {
                if (list[j].compareTo(list[i]) < 0) {
                    UtilForSort.swap(list, i, j);
                }
            }
        }
        return list;
    }
}
