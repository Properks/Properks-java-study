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
            int j = i - 1;
            while (j > 0 && list[j].compareTo(value) > 0) {
                list[j + 1] = list[j];
                j--;
            }
            list[j] = value;
        }
    }

}
