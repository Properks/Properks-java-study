import java.util.*;

// 연속 두번 입력된 문자를 계속 없애며 다 없어지는지
public class Problem_11 {
    public static void main(String[] args) {
        String input1 = "baabaa";
        String input2 = "cdcd";

        int result1 = solution(input1);
        int result2 = solution(input2);

        System.out.println(result1);
        System.out.println(result2);

    }

    public static int solution(String input) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(input.charAt(i));
                continue;
            }
            else if (stack.peek().equals(input.charAt(i))) {
                stack.pop();
            }
            else {
                stack.push(input.charAt(i));
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
