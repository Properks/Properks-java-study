import java.util.*;

// 완주하지 못한 선 (제출 완료)
// https://school.programmers.co.kr/learn/courses/30/lessons/42576
// 마라톤 완주 못한 사람 찾기
public class Problem_19 {
    public static void main(String[] args) {
        String[] input1 = {"leo", "kiki", "eden"};
        String[] completed1 = {"eden", "kiki"};
        String[] input2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completed2 = {"josipa", "filipa", "marina", "nikola"};
        String[] input3 = {"mislav", "stanko", "mislav", "ana"};
        String[] completed3 = {"stanko", "ana", "mislav"};


        String result1 = solution1(input1, completed1);
        String result2 = solution1(input2, completed2);
        String result3 = solution1(input3, completed3);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }

    // completed를 이용한 hash를 하나 만들고 input 값들 중 hash에 없는 값을 찾기
    // 이름이 같은 경우 Set에 안들어가기 때문에 예외 발생
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

    public static String solution1(String[] input, String[] completed) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < completed.length; i++) {
            map.put(completed[i], map.getOrDefault(completed[i], 0) + 1);
            // map의 값들을 1로 설정하고 중복 이름에 대해서는 찾아서 1 더하기
        }

        int a= 0;
        for (String value: input) {
            if (map.getOrDefault(value, 0) == 0) {
                return value;
            }
            map.put(value, map.get(value) - 1);
        }
        return null;
    }

    public String solution2(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        for (String name : participant) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        for (String name : completion) {
            map.put(name, map.get(name) - 1);
        }

        for (String name : participant) {
            if (map.get(name) != 0) {
                return name;
            }
        }

        return null;
    }
}
