package com.example.sort;
import java.util.List;

/**
 * The common interface of most sorting algorithms
 *
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * <a href="https://github.com/TheAlgorithms/Java/blob/master/src/main/java/com/thealgorithms/sorts/SortAlgorithm.java">출처</a>
 */
public interface SortAlgorithm {
    /**
     * Main method arrays sorting algorithms
     *
     * @param unsorted - an array should be sorted
     * @return a sorted array
     */
    <T extends Comparable<T>> T[] sort(T[] unsorted);

    int[] sort(int[] array);

//    /**
//     * Auxiliary method for algorithms what wanted to work with lists from JCF
//     *
//     * @param unsorted - a list should be sorted
//     * @return a sorted list
//     */
//    @SuppressWarnings("unchecked")
//    default<T extends Comparable<T>> List<T> sort(List<T> unsorted) {
//        return Arrays.asList(sort(unsorted.toArray((T[]) new Comparable[unsorted.size()])));
//    }

    /**
     * List&lt;Integer>를 정렬하는 method
     */
    <T extends Comparable<T>> List<T> sort(List<T> array);
}