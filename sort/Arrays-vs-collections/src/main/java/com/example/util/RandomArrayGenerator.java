package com.example.util;

import java.util.Random;

public class RandomArrayGenerator {

    private static final Random randomInteger = new Random(Integer.MAX_VALUE / 2);
    private RandomArrayGenerator() {}

    /**
     * 원소 n개로 이루어진 배열 생성
     * @param n 배열의 원소 개수
     * @return 무작위로 생성한 정렬되지 않은 배열
     */
    public static int[] generateIntArray(int n) {
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = randomInteger.nextInt();
        }
        return array;
    }

}
