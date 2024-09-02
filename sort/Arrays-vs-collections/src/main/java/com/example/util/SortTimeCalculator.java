package com.example.util;

import com.example.sort.SortAlgorithm;
import com.example.sort.SortUtils;

import java.util.List;

public class SortTimeCalculator {

    private SortTimeCalculator() {}

    /**
     * Basic type으로 이루어진 정수형 배열을 정렬하고 정렬하는 데 걸리는 시간 계산
     * @param sortAlgorithm 정렬 알고리즘
     * @param array 정렬할 배열
     * @return 정렬하는 데 걸리는 시간, 정렬되지 않으면 -1.0
     */
    public static double calculateTimeWithBasicTypeArray(SortAlgorithm sortAlgorithm, int[] array) {
        long start = System.currentTimeMillis();
        sortAlgorithm.sort(array);
        double end = (System.currentTimeMillis() - start) / 1000.0;
        return SortUtils.isSorted(array) ? end : -1.0;
    }

    /**
     * Integer type으로 이루어진 정수형 배열을 정렬하고 정렬하는 데 걸리는 시간 계산
     * @param sortAlgorithm 정렬 알고리즘
     * @param array 정렬할 배열
     * @return 정렬하는 데 걸리는 시간, 정렬되지 않으면 -1.0
     */
    public static double calculateTimeWithClassTypeArray(SortAlgorithm sortAlgorithm, Integer[] array) {
        long start = System.currentTimeMillis();
        sortAlgorithm.sort(array);
        double end = (System.currentTimeMillis() - start) / 1000.0;
        return SortUtils.isSorted(array) ? end : -1.0;
    }

    /**
     * List로 이루어진 정수형 리스트를 정렬하고 정렬하는 데 걸리는 시간 계산
     * @param sortAlgorithm 정렬 알고리즘
     * @param array 정렬할 리스트
     * @return 정렬하는 데 걸리는 시간, 정렬되지 않으면 -1.0
     */
    public static double calculateTimeWithList(SortAlgorithm sortAlgorithm, List<Integer> array) {
        long start = System.currentTimeMillis();
        sortAlgorithm.sort(array);
        double end = (System.currentTimeMillis() - start) / 1000.0;
        return SortUtils.isSorted(array) ? end : -1.0;
    }
}
