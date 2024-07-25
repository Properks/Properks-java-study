import java.util.*;

// 두 개 뽑아서 더하기 (제출 완료)
// https://school.programmers.co.kr/learn/courses/30/lessons/68644
// 배열에서 두 수를 뽑아 더해서 오름차순으로 정렬
public class Problem_3 {
    public static void main(String[] args) {
        int[] input1 = {2, 1, 3, 4, 1};
        int[] input2 = {5, 0, 2, 7};

        //내 풀이
        System.out.println("내 풀이");
        Set<Integer> result1 = solution(input1);
        Set<Integer> result2 = solution(input2);

        System.out.println(result1);
        System.out.println(result2);

        //책 풀이
        System.out.println("책 풀이");
        int[] result3 = solution1(input1);
        int[] result4 = solution1(input2);

        System.out.println(result3);
        System.out.println(result4);
    }

    // 내 풀이
    public static Set<Integer> solution(int[] input) {
        Set<Integer> set = new TreeSet<>(); // 역순이면 new TreeSet<>(Comparator.reversedOrder());

        for (int i = 0; i < input.length - 1; i++) {
            for (int j = i + 1; j < input.length; j++) {
                set.add(input[i] + input[j]);
            }
        }

        return set;
    }

    // 책 풀이
    public static int[] solution1(int[] input) {
        Set<Integer> set = new HashSet();

        for (int i = 0; i < input.length - 1; i++) {
            for (int j = i + 1; j < input.length; j++) {
                set.add(input[i] + input[j]);
            }
        }
        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}
