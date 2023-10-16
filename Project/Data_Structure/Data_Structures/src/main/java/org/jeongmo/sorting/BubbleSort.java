package org.jeongmo.sorting;

public class BubbleSort extends Sort{
    @Override
    public <T extends Comparable<T>> T[] sort(T[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = list.length - 1; j > i; j--) {
                if (list[j].compareTo(list[j - 1]) < 0) {
                    swap(list, j, j - 1);
                }
            }
        }
        return list;
    }
}
