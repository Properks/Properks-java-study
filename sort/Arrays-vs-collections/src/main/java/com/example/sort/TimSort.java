package com.example.sort;

import java.util.List;

import static com.example.sort.SortUtils.less;

/**
 * This is simplified TimSort algorithm implementation. The original one is more complicated.
 * <p>
 * For more details @see <a href="https://en.wikipedia.org/wiki/Timsort">TimSort Algorithm</a><br>
 * <a href="https://github.com/TheAlgorithms/Java/blob/master/src/main/java/com/thealgorithms/sorts/TimSort.java">출처</a>
 */
public class TimSort implements SortAlgorithm {
    private static final int SUB_ARRAY_SIZE = 32;
    private Comparable[] aux;
    private int[] intAux;

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        final int n = array.length;

        InsertionSort insertionSort = new InsertionSort();
        for (int i = 0; i < n; i += SUB_ARRAY_SIZE) {
            insertionSort.sortWithClassType(array, i, Math.min(i + SUB_ARRAY_SIZE, n));
        }

        aux = new Comparable[n];
        for (int sz = SUB_ARRAY_SIZE; sz < n; sz = sz + sz) {
            for (int lo = 0; lo < n - sz; lo += sz + sz) {
                mergeWithClassType(array, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, n - 1));
            }
        }

        return array;
    }

    @SuppressWarnings("unchecked")
    private <T extends Comparable<T>> void mergeWithClassType(T[] a, final int lo, final int mid, final int hi) {
        int i = lo;
        int j = mid + 1;
//        System.arraycopy(a, lo, aux, lo, hi + 1 - lo);
        for (int index = lo; index <= hi; index++) {
            aux[index] = a[index];
        }

        for (int k = lo; k <= hi; k++) {
            if (j > hi) {
                a[k] = (T) aux[i++];
            } else if (i > mid) {
                a[k] = (T) aux[j++];
            } else if (less(aux[j], aux[i])) {
                a[k] = (T) aux[j++];
            } else {
                a[k] = (T) aux[i++];
            }
        }
    }

    @Override
    public int[] sort(int[] array) {
        final int n = array.length;

        InsertionSort insertionSort = new InsertionSort();
        for (int i = 0; i < n; i += SUB_ARRAY_SIZE) {
            insertionSort.sortWithBasicType(array, i, Math.min(i + SUB_ARRAY_SIZE, n));
        }

        intAux = new int[n];
        for (int sz = SUB_ARRAY_SIZE; sz < n; sz = sz + sz) {
            for (int lo = 0; lo < n - sz; lo += sz + sz) {
                mergeWithBasicType(array, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, n - 1));
            }
        }

        return array;
    }

    @SuppressWarnings("unchecked")
    private <T extends Comparable<T>> void mergeWithBasicType(int[] a, final int lo, final int mid, final int hi) {
        int i = lo;
        int j = mid + 1;
//        System.arraycopy(a, lo, intAux, lo, hi + 1 - lo);
        for (int index = lo; index <= hi; index++) {
            intAux[index] = a[index];
        }

        for (int k = lo; k <= hi; k++) {
            if (j > hi) {
                a[k] = intAux[i++];
            } else if (i > mid) {
                a[k] = intAux[j++];
            } else if (less(intAux[j], intAux[i])) {
                a[k] = intAux[j++];
            } else {
                a[k] = intAux[i++];
            }
        }
    }

    @Override
    public <T extends Comparable<T>> List<T> sort(List<T> array) {
        final int n = array.size();

        InsertionSort insertionSort = new InsertionSort();
        for (int i = 0; i < n; i += SUB_ARRAY_SIZE) {
            insertionSort.sortWithList(array, i, Math.min(i + SUB_ARRAY_SIZE, n));
        }

        aux = new Comparable[n];
        for (int sz = SUB_ARRAY_SIZE; sz < n; sz = sz + sz) {
            for (int lo = 0; lo < n - sz; lo += sz + sz) {
                mergeWithList(array, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, n - 1));
            }
        }

        return array;
    }

    @SuppressWarnings("unchecked")
    private <T extends Comparable<T>> void mergeWithList(List<T> a, final int lo, final int mid, final int hi) {
        int i = lo;
        int j = mid + 1;
//        System.arraycopy(a.toArray(), lo, aux, lo, hi + 1 - lo);
        for (int index = lo; index <= hi; index++) {
            aux[index] = a.get(index);
        }

        for (int k = lo; k <= hi; k++) {
            if (j > hi) {
                a.set(k, (T) aux[i++]);
            } else if (i > mid) {
                a.set(k, (T) aux[j++]);
            } else if (less(aux[j], aux[i])) {
                a.set(k, (T) aux[j++]);
            } else {
                a.set(k, (T) aux[i++]);
            }
        }
    }
}