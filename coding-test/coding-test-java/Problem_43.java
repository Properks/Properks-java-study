import java.util.*;

// 1부터 N까지 숫자 중 합이 10이 되는 조합 구하기
public class Problem_43 {
    static List<List<Integer>> answer = new ArrayList<>();
    public static void main(String[] args) {
        int n1 = 5;
        int n2 = 2;
        int n3 = 7;

        int[][] result1 = solution(n1);
        int[][] result2 = solution(n2);
        int[][] result3 = solution(n3);

        Arrays.stream(result1).forEach(a -> System.out.println(Arrays.toString(a)));
        Arrays.stream(result2).forEach(a -> System.out.println(Arrays.toString(a)));
        Arrays.stream(result3).forEach(a -> System.out.println(Arrays.toString(a)));
    }

    public static int[][] solution(int n) {
        answer = new ArrayList<>();
        backTracking(new ArrayList<>(), n, 0, 1);

        return answer.stream().map(list -> list.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
    }

    public static void backTracking(List<Integer> selected, int n, int sum, int start) {
        if (sum == 10) {
            answer.add(selected);
            return;
        }
        for (int i = start; i < n + 1; i++) {
            if (sum + i <= 10) {
                List<Integer> list = new ArrayList<>(selected);
                list.add(i);
                backTracking(list, n, sum + i, i + 1);
            }
        }
    }
}
