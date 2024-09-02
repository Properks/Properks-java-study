package com.example.sort;

import java.util.List;

/**
 * <a href="https://github.com/TheAlgorithms/Java/blob/master/src/main/java/com/thealgorithms/sorts/InsertionSort.java">출처</a>
 */
public class InsertionSort implements SortAlgorithm {

    /**
     * Generic insertion sort algorithm in increasing order.
     *
     * @param array the array to be sorted.
     * @param <T>   the class of array.
     * @return sorted array.
     */
    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        return sortWithClassType(array, 0, array.length);
    }

    public <T extends Comparable<T>> T[] sortWithClassType(T[] array, int lo, int hi) {
        for (int i = lo; i < hi; i++) {
            for (int j = i; j > lo && SortUtils.less(array[j], array[j - 1]); j--) {
                SortUtils.swapWithClassType(array, j, j - 1);
            }
        }
        return array;
    }

    @Override
    public int[] sort(int[] array) {
        return sortWithBasicType(array, 0, array.length);
    }

    public int[] sortWithBasicType(int[] array, int lo, int hi) {
        for (int i = lo; i < hi; i++) {
            for (int j = i; j > lo && array[j] <  array[j - 1]; j--) {
                SortUtils.swapWithBasicType(array, j, j - 1);
            }
        }
        return array;
    }

    @Override
    public <T extends Comparable<T>> List<T> sort(List<T> array) {
        return sortWithList(array, 0, array.size());
    }

    public <T extends Comparable<T>> List<T> sortWithList(List<T> array, int lo, int hi) {
        for (int i = lo; i < hi; i++) {
            for (int j = i; j > lo && SortUtils.less(array.get(j), array.get(j - 1)); j--) {
                SortUtils.swapWithList(array, j, j - 1);
            }
        }
        return array;
    }
}