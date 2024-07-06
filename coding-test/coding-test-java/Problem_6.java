import util.PrintUtil;

import java.util.*;
import java.util.function.IntFunction;

// 스테이지의 실패율을 계산하는 문제
public class Problem_6 {
    public static void main(String[] args) {
        int n1 = 5;
        int[] arr1 = {2, 1, 2, 6, 2, 4, 3, 3};

        int n2 = 4;
        int[] arr2 = {4, 4, 4, 4, 4};

        int[] result1 = solution(n1, arr1);
        int[] result2 = solution(n2, arr2);

        PrintUtil.printArray(result1);
        PrintUtil.printArray(result2);

        int[] result3 = solution1(n1, arr1);
        int[] result4 = solution1(n2, arr2);

        PrintUtil.printArray(result3);
        PrintUtil.printArray(result4);
    }

    // 내 풀이
    public static int[] solution(int count, int[] arr) {
        List<Double> failure = new ArrayList<>();
        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            int target = i + 1;
            long fail = Arrays.stream(arr).filter((value) -> value == target).count();
            long total = Arrays.stream(arr).filter((value) -> value >= target).count();
            failure.add((double) fail / (double) total);
        }

        for (int i = 0; i < count; i++) {
            double max = failure.stream().mapToDouble(Double::doubleValue).max().getAsDouble();
            int index = failure.indexOf(max);
            result[i] = index + 1;
            failure.set(index, -100.0);
        }

        return result;
    }

    // 책 풀이
    public static int[] solution1(int count, int[] arr) {
        int[] challenger = new int[count + 2];
        for (int i = 0; i < arr.length; i++) {
            challenger[arr[i]] += 1;
        }

        Map<Integer, Double> fails = new HashMap<>();
        double total = arr.length;

        for (int i = 1; i <= count; i++) {
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
