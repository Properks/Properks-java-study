import java.util.*;

// 카드 뭉치 (제출 완료)
// 목표 문장으로 단어 배열하기
public class Problem_17 {
    public static void main(String[] args) {
        String[] card1 = {"i", "drink","water"};
        String[] card2 = {"want", "to"};
        String[] card3 = {"i", "water", "drink"};
        String[] goals = {"i", "want", "to","drink", "water"};

        String result1 = solution(card1, card2, goals);
        String result2 = solution(card1, card3, goals);

        System.out.println(result1);
        System.out.println(result2);

    }

    public static String solution(String[] card1, String[] card2, String[] goals) {
//        ArrayDeque<String> queue1 = new ArrayDeque<>();
//        ArrayDeque<String> queue2 = new ArrayDeque<>();
//
//        for (String card1 : cards1) {
//            queue1.addLast(card1);
//        }
//        for (String card2 : cards2) {
//            queue2.addLast(card2);
//        }
        //책 풀이
        // List로 만들어서 생성
        ArrayDeque<String> queue1 = new ArrayDeque<>(Arrays.asList(card1));
        ArrayDeque<String> queue2 = new ArrayDeque<>(Arrays.asList(card2));


//        String word1 = queue1.pollFirst();
//        String word2 = queue2.pollFirst();
        for (String goal : goals) {
            // 책 풀이 else if 까지 peek 을 사용해서 코드 줄이기
            if (!queue1.isEmpty() && queue1.peekFirst().equals(goal)) {
                queue1.pollFirst();
            }
            else if (!queue1.isEmpty() && queue1.peek().equals(goal)) {
                queue2.pollFirst();
            }
//            if (goal.equals(word1)) {
//                if (!queue1.isEmpty()) {
//                    word1 = queue1.pollFirst();
//                }
//            }
//            else if (goal.equals(word2)) {
//                if (!queue2.isEmpty()) {
//                    word2 = queue2.pollFirst();
//                }
//            }
            else {
                return "No";
            }
        }
        return "Yes";
    }

    // 아래의 코드와 동일하게 재풀이
    public static String solutionWithoutComment(String[] card1, String[] card2, String[] goals) {
        ArrayDeque<String> queue1 = new ArrayDeque<>(Arrays.asList(card1));
        ArrayDeque<String> queue2 = new ArrayDeque<>(Arrays.asList(card2));

        for (String goal : goals) {
            if (!queue1.isEmpty() && queue1.peekFirst().equals(goal)) {
                queue1.pollFirst();
            }
            else if (!queue1.isEmpty() && queue1.peek().equals(goal)) {
                queue2.pollFirst();
            }
            else {
                return "No";
            }
        }
        return "Yes";
    }
}
