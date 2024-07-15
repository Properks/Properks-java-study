import java.util.*;

// 첫 번째 괄호를 여러번 뒤로 옮겼을 때 올바른지 판단
public class Problem_10 {
    public static void main(String[] args) {
        String input1 = "[](){}";
        String input2 = "}]()[{";

        int result1 = solution(input1);
        int result2 = solution(input2);

        System.out.println(result1);
        System.out.println(result2);

        int result3 = solution(input1);
        int result4 = solution(input2);

        System.out.println(result3);
        System.out.println(result4);
    }

    // 내 풀이
    // 짝지어 진 것들을 Map으로 푸는 것이 중요
    public static int solution(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            char[] chars = new char[input.length()];
            for (int j = 0; j < input.length(); j++) {
                chars[j] = input.charAt((i + j) % input.length());
            }

            Stack<Character> stacks = new Stack<>();
            boolean isSuccess = true;
            for (int j = 0; j < input.length(); j++) {
                isSuccess = true;
                if (chars[j] == '(' || chars[j] == '{' || chars[j] == '[') {
                    stacks.push(chars[j]);
                }

                // 짝지어진 것은 Map으로 처리하기
                else if (!stacks.isEmpty() && ((chars[j] == ')' && stacks.peek() == '(') || (chars[j] == '}' && stacks.peek() == '{') || (chars[j] == ']' && stacks.peek() == '['))) {
                    if (stacks.isEmpty()) {
                        isSuccess = false;
                        break;
                    }
                    stacks.pop();
                }

                else {
                    isSuccess = false;
                    break;
                }
            }
            if (isSuccess) {
                count++;
            }
        }
        return count;
    }

    // 책 풀이
    public static int solution1(String input) {
        Map<Character, Character> map = Map.of(
                ')','(',
                '}','{',
                ']','['
        );
        input += input;
        int answer = 0;
        A:for (int i = 0; i < input.length(); i++) {
            ArrayDeque<Character> stack = new ArrayDeque<>();
            for (int j = i; j < i + input.length(); j++) {
                char c = input.charAt(j);
                if (!map.containsKey(c)) {
                    stack.push(c);
                }
                else if (!stack.isEmpty() && stack.pop().equals(map.get(c))) {
                    stack.pop();
                }
                else {
                    continue A;
                }
            }
            if (stack.isEmpty()) {
                answer++;
            }
        }
        return answer;
    }
}
