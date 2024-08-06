import util.PrintUtil;

import java.util.*;

// 실패율 (제출 완료)
// https://school.programmers.co.kr/learn/courses/30/lessons/42889
// 스테이지의 실패율을 계산하는 문제
public class Problem_6 {
    public static void main(String[] args) {
//        int n1 = 5;
//        int[] arr1 = {2, 1, 2, 6, 2, 4, 3, 3};

        int n1 = 8;
        int[] arr1 = {1,1,1,1,2,2,4,2};

        int n2 = 4;
        int[] arr2 = {4, 4, 4, 4, 4};

        int[] result1 = solution(n1, arr1);
        int[] result2 = solution(n2, arr2);

        PrintUtil.printIntegerArray(result1);
        PrintUtil.printIntegerArray(result2);

        int[] result3 = solution1(n1, arr1);
        int[] result4 = solution1(n2, arr2);

        PrintUtil.printIntegerArray(result3);
        PrintUtil.printIntegerArray(result4);
    }

    // 내 풀이
    // 오답 수정
    public static int[] solution(int N, int[] stages) {
        List<Double> failure = new ArrayList<>();
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            int target = i + 1;
            long fail = Arrays.stream(stages).filter(value -> value == target).count();
            long total = Arrays.stream(stages).filter(value -> value >= target).count();
            // total이 0인 경우 오류가 생겨 오답이 된다.
            failure.add(total != 0 ? (double) fail / (double) total : 0.0);
        }

        for (int i = 0; i < N; i++) {
            double max = failure.stream().max(Double::compareTo).get();
            int index = failure.indexOf(max);
            result[i] = index + 1;
            failure.set(index, -100.0);
        }

        return result;
    }

    // 책 풀이
    public static int[] solution1(int N, int[] stages) {
        int[] challenger = new int[N + 2];
        for (int i = 0; i < stages.length; i++) {
            challenger[stages[i]] += 1;
        }

        Map<Integer, Double> fails = new HashMap<>();
        double total = stages.length;

        for (int i = 1; i <= N; i++) {
            if (challenger[i] == 0) {
                fails.put(i, 0.0);
            }
            else {
                fails.put(i, challenger[i] / total);
                total -= challenger[i];
            }
        }

        // Sort에서 비교 함수를 람다식으로 구현 후 mapToInt로 IntStream으로 변경해주는데 그 값을 map의 키 값으로 변경
        return fails.entrySet().stream().sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue())).mapToInt(Map.Entry::getKey).toArray();
    }
}
