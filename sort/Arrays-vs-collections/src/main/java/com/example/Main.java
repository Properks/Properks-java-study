package com.example;

import com.example.sort.DualPivotQuickSort;
import com.example.sort.SortAlgorithm;
import com.example.sort.TimSort;
import com.example.util.RandomArrayGenerator;
import com.example.util.SortTimeCalculator;

import java.util.*;

public class Main {

    // 결과 정리 및 설명: https://github.com/Properks/Properks-study/blob/main/java/sort/Arrays-vs-Collections.md
    public static void main(String[] args) {

        System.out.println("Dual-pivot Quick Sort");
        compareAverageTime(new DualPivotQuickSort(), 100, 10000000);
        System.out.println();

        System.out.println("Tim Sort");
        compareAverageTime(new TimSort(), 100, 10000000);

    }

    /**
     * 평균 정렬 시간 비교
     * @param sortAlgorithm 정렬 알고리즘
     * @param n 비교하기 위해 정렬할 횟수
     * @param size 배열의 크기
     */
    public static void compareAverageTime(SortAlgorithm sortAlgorithm, int n, int size) {
        double basicType = 0.0;
        double classType = 0.0;
        double listType = 0.0;

        for (int i = 0; i < n; i++) {
            int[] basicArray = RandomArrayGenerator.generateIntArray(size);
            Integer[] classArray = Arrays.stream(basicArray.clone()).boxed().toArray(Integer[]::new);
            List<Integer> list = new ArrayList<>(Arrays.stream(classArray).toList());

            basicType += SortTimeCalculator.calculateTimeWithBasicTypeArray(sortAlgorithm, basicArray);
            classType += SortTimeCalculator.calculateTimeWithClassTypeArray(sortAlgorithm, classArray);
            listType += SortTimeCalculator.calculateTimeWithList(sortAlgorithm, list);
        }

        printBasicType(basicType / n);
        printClassType(classType / n);
        printList(listType / n);
    }


    public static void printBasicType(double time) {
        System.out.println("int[]: " + time + "s");
    }

    public static void printClassType(double time) {
        System.out.println("Integer[]: " + time + "s");
    }

    public static void printList(double time) {
        System.out.println("List: " + time + "s");
    }

}