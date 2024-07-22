import java.util.*;

// 3명이 일정하게 답을 찍은 경우 가장 많이 맞은 사람을 배열로 반환
public class Problem_4 {

    public static void main(String[] args) {

        int[][] pattern = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int[] answer1 = {1, 2, 3, 4, 5, 3, 3, 2, 1, 4};
        int[] answer2 = {1, 3, 2, 4, 2, 5, 3, 2, 2, 1, 3, 4, 2};

        int[] result1 = solution(answer1, pattern);
        int[] result2 = solution(answer2, pattern);

        System.out.println(Arrays.stream(result1).boxed().toList());
        System.out.println(Arrays.stream(result2).boxed().toList());
    }

    public static int[] solution(int[] answers, int[][] pattern) {

        int[] corrected = new int[3];
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < pattern.length; j++) {
                if (pattern[j][i % pattern[j].length] == answers[i]) {
                    corrected[j]++;
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        int max = Math.max(corrected[0], Math.max(corrected[1], corrected[2]));

        // 책에서 최대를 구하는 방식
        max = Arrays.stream(corrected).max().getAsInt(); // max() in Stream -> stream().reduce(Math:max)

        // List<Integer> 형태일 때 최대를 구하는 방법
//        max = Collections.max(Arrays.stream(corrected).boxed().toList());

        for (int i = 0; i < 3; i++) {
            if (max == corrected[i]) {
                result.add(i + 1);
            }
        }
        return result.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}
