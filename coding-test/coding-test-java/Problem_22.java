import util.PrintUtil;

import java.util.*;

// 베스트 앨범
// 가장 많이 실행한 곡을 장르별로 2개씩 뽑는 문제 풀이
public class Problem_22 {

    public static void main(String[] args) {

        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        int[] result1 = solution(genres, plays);

        PrintUtil.printIntegerArray(result1);
    }

    public static int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> count = new HashMap();
        for (int i = 0; i < genres.length; i++) {
            if (!count.containsKey(genres[i])) {
                count.put(genres[i], 2);
            }
        }
        Map<Integer,Integer> play = new HashMap<>();
        for (int i = 0; i < plays.length; i++) {
            play.put(i, plays[i]);
        }
        int[] result = play.entrySet().stream().sorted((k1, k2) -> Integer.compare(k2.getValue(), k1.getValue())).mapToInt(Map.Entry::getKey).toArray();

        List<Integer> answers = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            String genre = genres[result[i]];
            if (count.get(genre) > 0) {
                answers.add(result[i]);
                count.put(genre, count.get(genre) - 1);
            }
        }
        return answers.stream().mapToInt(Integer::intValue).toArray();
    }
}
