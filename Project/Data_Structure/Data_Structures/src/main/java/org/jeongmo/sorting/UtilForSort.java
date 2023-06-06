package org.jeongmo.sorting;

public class UtilForSort {

    private UtilForSort() {}

    public static <T> void swap(T[] array, int first, int second) {
        T temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}
