import java.util.*;

// 할인 행사 (제출 완료)
// https://school.programmers.co.kr/learn/courses/30/lessons/131127
// 10일 연속으로 할인하는 날짜 찾기
public class Problem_20 {

    public static void main(String[] args) {
        String[] want1 = {"banana", "apple", "rice", "pork" , "pot"};
        String[] want2 = {"apple"};

        int[] number1 = {3, 2, 2, 2, 1};
        int[] number2 = {10};

        String[] discount1 = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        String[] discount2 = {"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"};

        int result1 = solution(want1, number1, discount1);
        int result2 = solution(want2, number2, discount2);

        System.out.println(result1);
        System.out.println(result2);
    }

    public static int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> count = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            count.put(want[i], number[i]);
        }

        int answer = 0;
        out: for (int i = 0; i < discount.length - 9; i++) {
            Map<String, Integer> hash = new HashMap<>(count);
            // 책에서는 Map을 생성하고 1씩 추가하며 넣어서 count.equals(hash);로 확인한다.
            for (int j = i; j < i + 10; j++) {
                if (!hash.containsKey(discount[j]) || hash.get(discount[j]) <= 0) {
                    continue out;
                }
                hash.put(discount[j], hash.get(discount[j]) - 1);
            }

            int max = hash.values().stream().mapToInt(Integer::intValue).max().getAsInt();
            if (max == 0) {
                answer++;
            }
        }
        return answer;
    }

    // 재풀이
    // label을 사용하지 않도록 재구성
    public int solution1(String[] want, int[] number, String[] discount) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }

        int answer = 0;

        for (int i = 0; i < discount.length; i++) {
            if (map.getOrDefault(discount[i], 0) > 0) {
                int day = 0;
                Map<String, Integer> hash = new HashMap<>(map);
                for (int j = i; j < discount.length; j++) {
                    if (hash.getOrDefault(discount[j], 0) > 0) {
                        hash.put(discount[j], hash.get(discount[j]) - 1);
                        day++;
                    }
                    else {
                        break;
                    }
                    if (day == 10){
                        answer++;
                        break;
                    }
                }
            }
        }

        return answer;
    }
}
