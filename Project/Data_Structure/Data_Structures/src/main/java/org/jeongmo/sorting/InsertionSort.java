package org.jeongmo.sorting;

public class InsertionSort  extends Sort{

    @Override
    <T extends Comparable<T>> T[] sort(T[] list) {
        long startedTime = System.nanoTime();
        insertionSort(list);
        this.time = System.nanoTime() - startedTime;
        return list;
    }

    public <T extends Comparable<T>> void insertionSort(T[] list) {
        for (int i = 1; i < list.length; i++) {
            T value = list[i];
            for (int j = 0; j < i; j++) {
                if (list[j].compareTo(list[i]) > 0) {
                    for (int k = i; k > j; k--) {
                        list[k] = list[k-1];
                    }
                    list[j] = value;
                    break;
                }
            }
        }
    }

}
