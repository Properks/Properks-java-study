package com.example.sort;

import java.util.List;

/**
 * Dual Pivot Quick Sort Algorithm
 *
 * @author Debasish Biswas (https://github.com/debasishbsws) *
 * @see SortAlgorithm
 * <a href="https://github.com/TheAlgorithms/Java/blob/master/src/main/java/com/thealgorithms/sorts/DualPivotQuickSort.java">출처</a>
 */
public class DualPivotQuickSort implements SortAlgorithm {

    /**
     * This method implements the Dual pivot Quick Sort
     *
     * @param array The array to be sorted Sorts the array in increasing order
     */
    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        dualPivotQuicksortWithClassType(array, 0, array.length - 1);
        return array;
    }

    /**
     * The sorting process
     *
     * @param left  The first index of an array
     * @param right The last index of an array
     * @param array The array to be sorted
     */
    private static <T extends Comparable<T>> void dualPivotQuicksortWithClassType(T[] array, int left, int right) {
        if (left < right) {
            int[] pivots = partition(array, left, right);

            dualPivotQuicksortWithClassType(array, left, pivots[0] - 1);
            dualPivotQuicksortWithClassType(array, pivots[0] + 1, pivots[1] - 1);
            dualPivotQuicksortWithClassType(array, pivots[1] + 1, right);
        }
    }

    /**
     * This method finds the partition indices for an array
     *
     * @param array The array to be sorted
     * @param left  The first index of an array
     * @param right The last index of an array Finds the partition index of an array
     */
    private static <T extends Comparable<T>> int[] partition(T[] array, int left, int right) {
        if (array[left].compareTo(array[right]) > 0) {
            SortUtils.swapWithClassType(array, left, right);
        }

        T pivot1 = array[left];
        T pivot2 = array[right];

        int j = left + 1;
        int less = left + 1;
        int great = right - 1;

        while (less <= great) {
            // If element is less than pivot1
            if (array[less].compareTo(pivot1) < 0) {
                SortUtils.swapWithClassType(array, less, left++);
            }

            // If element is greater or equal to pivot2
            else if (array[less].compareTo(pivot2) >= 0) {
                while (less < great && array[great].compareTo(pivot2) > 0) {
                    great--;
                }

                SortUtils.swapWithClassType(array, less, great--);

                if (array[less].compareTo(pivot1) < 0) {
                    SortUtils.swapWithClassType(array, less, left++);
                }
            }

            less++;
        }
        j--;
        great++;
        // Bring the pivots to their appropriate positions
        SortUtils.swapWithClassType(array, left, j);
        SortUtils.swapWithClassType(array, right, great);

        // return the pivots' indices
        return new int[] {less, great};
    }



    @Override
    public int[] sort(int[] array) {
        dualPivotQuicksortWithBasicType(array, 0, array.length - 1);
        return array;
    }

    private static void dualPivotQuicksortWithBasicType(int[] array, int left, int right) {
        if (left < right) {
            int[] pivots = partition(array, left, right);

            dualPivotQuicksortWithBasicType(array, left, pivots[0] - 1);
            dualPivotQuicksortWithBasicType(array, pivots[0] + 1, pivots[1] - 1);
            dualPivotQuicksortWithBasicType(array, pivots[1] + 1, right);
        }
    }

    private static int[] partition(int[] array, int left, int right) {
        if (array[left] > array[right]) {
            SortUtils.swapWithBasicType(array, left, right);
        }

        int pivot1 = array[left];
        int pivot2 = array[right];

        int j = left + 1;
        int less = left + 1;
        int great = right - 1;

        while (less <= great) {
            // If element is less than pivot1
            if (array[less] < pivot1) {
                SortUtils.swapWithBasicType(array, less, left++);
            }

            // If element is greater or equal to pivot2
            else if (array[less] >= pivot2) {
                while (less < great && array[great] > pivot2) {
                    great--;
                }

                SortUtils.swapWithBasicType(array, less, great--);

                if (array[less] < pivot1) {
                    SortUtils.swapWithBasicType(array, less, left++);
                }
            }

            less++;
        }
        j--;
        great++;
        // Bring the pivots to their appropriate positions
        SortUtils.swapWithBasicType(array, left, j);
        SortUtils.swapWithBasicType(array, right, great);

        // return the pivots' indices
        return new int[] {less, great};
    }


    @Override
    public <T extends Comparable<T>> List<T> sort(List<T> array) {
        dualPivotQuicksortWithList(array, 0, array.size() - 1);
        return array;
    }

    private static <T extends Comparable<T>> void dualPivotQuicksortWithList(List<T> array, int left, int right) {
        if (left < right) {
            int[] pivots = partition(array, left, right);

            dualPivotQuicksortWithList(array, left, pivots[0] - 1);
            dualPivotQuicksortWithList(array, pivots[0] + 1, pivots[1] - 1);
            dualPivotQuicksortWithList(array, pivots[1] + 1, right);
        }
    }

    private static <T extends Comparable<T>> int[] partition(List<T> array, int left, int right) {
        if (array.get(left).compareTo(array.get(right)) > 0) {
            SortUtils.swapWithList(array, left, right);
        }

        T pivot1 = array.get(left);
        T pivot2 = array.get(right);

        int j = left + 1;
        int less = left + 1;
        int great = right - 1;

        while (less <= great) {
            // If element is less than pivot1
            if (array.get(less).compareTo(pivot1) < 0) {
                SortUtils.swapWithList(array, less, left++);
            }

            // If element is greater or equal to pivot2
            else if (array.get(less).compareTo(pivot2) >= 0) {
                while (less < great && array.get(great).compareTo(pivot2) > 0) {
                    great--;
                }

                SortUtils.swapWithList(array, less, great--);

                if (array.get(less).compareTo(pivot1) < 0) {
                    SortUtils.swapWithList(array, less, left++);
                }
            }

            less++;
        }
        j--;
        great++;
        // Bring the pivots to their appropriate positions
        SortUtils.swapWithList(array, left, j);
        SortUtils.swapWithList(array, right, great);

        // return the pivots' indices
        return new int[] {less, great};
    }

    /*
     * References: https://www.geeksforgeeks.org/dual-pivot-quicksort/
     */
}