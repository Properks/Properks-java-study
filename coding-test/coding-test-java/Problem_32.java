import util.PrintUtil;

import java.util.*;

// 영어 끝말잇기
public class Problem_32 {

    public static void main(String[] args) {
        int n1 = 3;
        int n2 = 5;
        int n3 = 2;

        String[] words1 = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        String[] words2 = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
        String[] words3 = {"hello", "one", "even", "never", "now", "world", "draw"};

        int[] result1 = solution(n1, words1);
        int[] result2 = solution(n2, words2);
        int[] result3 = solution(n3, words3);

        PrintUtil.printIntegerArray(result1);
        PrintUtil.printIntegerArray(result2);
        PrintUtil.printIntegerArray(result3);
    }

    public static int[] solution(int n, String[] words) {

        int[] answer = new int[2];
        Set<String> set = new HashSet<>();
        char now = words[0].charAt(0);
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (!set.contains(word) && now == word.charAt(0)) {
                set.add(word);
                now = word.charAt(word.length() - 1);
            }
            else {
                // 내 풀이
//                answer[0] = (i + 1) % n;
//                if (answer[0] == 0) {
//                    answer[0] = n;
//                    answer[1] = (i + 1) / n;
//                }
//                else {
//                    answer[1] = (i + 1) / n + 1;
//                }
                // 책 풀이
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
        }
        return answer;
    }
}
