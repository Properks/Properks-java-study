import java.util.*;

// 저자 문제
// 정수형 배열 정렬하기
public class Problem_1 {

    public static void main(String[] args) {

        int[] input = new int[100000];
//        int[] result = solution(input);
//        System.out.println(result.toString());

        long start = System.currentTimeMillis();
        int[] bubble = bubbleSort(input);
        long end = System.currentTimeMillis();
        System.out.println((end - start) / 1000d + "초"); // O(n^2) 알고리즘은 대략 1초 (n:1,000,000 -> 0.005초)

        start = System.currentTimeMillis();
        int[] solution = solution2(input);
        end = System.currentTimeMillis();
        System.out.println((end - start) / 1000d + "초"); // O(nlogn) 알고리즘은 대략 0.001초 (n:1,000,000 -> 89초)

    }

    /**
     * 기본 배열을 정렬해서 반환, 반환값을 void로 놓고 함수 실행만 해서 구현해도 원래 배열이 정렬됨
     * @param array 정렬할 배열
     * @return 정렬된 배열
     */
    public static int[] solution(int[] array) {
        Arrays.sort(array); // Arrays.sort()는 원본 배열을 정렬해서 원본 배열에 반영
        return array;
    }

    /**
     * 입력된 배열은 그대로 두고 새로운 정렬된 배열 반환
     * @param array 정렬할 배열
     * @return 정렬된 배열
     */
    public static int[] solution2(int[] array) {
        int[] clone = array.clone();
        Arrays.sort(clone); // O(nlogn): Dual pivot quick sort
        return clone;
    }

    public static int[] bubbleSort(int[] array) {
        int[] clone = array.clone();
        for (int i = 0; i < clone.length; i++) {
            for (int j = 0; j < clone.length - i - 1; j++) {
                if (clone[j + 1] < clone[j]) {
                    int temp = clone[j + 1];
                    clone[j + 1] = clone[j];
                    clone[j] = temp;
                }
            }
        }
        return clone;
    }
}
