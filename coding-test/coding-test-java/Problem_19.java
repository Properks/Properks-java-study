import java.util.*;

// 마라톤 완주 못한 사람 찾기
public class Problem_19 {
    public static void main(String[] args) {
        String[] input1 = {"leo", "kiki", "eden"};
        String[] completed1 = {"eden", "kiki"};
        String[] input2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completed2 = {"josipa", "filipa", "marina", "nikola"};
        String[] input3 = {"mislav", "stanko", "mislav", "ana"};
        String[] completed3 = {"stanko", "ana", "mislav"};


        String result1 = solution(input1, completed1);
        String result2 = solution(input2, completed2);
        String result3 = solution(input3, completed3);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }

    // completed를 이용한 hash를 하나 만들고 input 값들 중 hash에 없는 값을 찾기
    public static String solution(String[] input, String[] completed) {
        Set<String> hash = new HashSet<>();

        for (int i = 0; i < completed.length; i++) {
            hash.add(completed[i]);
        }

        for (String value : input) {
            if (!hash.contains(value)) {
                return value;
            }
            // 중복값을 제거하는 방법
            hash.remove(value);
        }
        return null;
    }
}
