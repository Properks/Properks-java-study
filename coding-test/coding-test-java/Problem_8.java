import java.util.*;

// 올바른 괄호
// https://school.programmers.co.kr/learn/courses/30/lessons/12909
// 괄호가 쌍이 맞는지 확인하는 문제
public class Problem_8 {

    public static void main(String[] args) {
        String input1 = "()()";
        String input2 = "(())()";
        String input3 = ")()(";
        String input4 = "(()(";

        boolean result1 = solution(input1);
        boolean result2 = solution(input2);
        boolean result3 = solution(input3);
        boolean result4 = solution(input4);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);


        boolean result5 = solution1(input1);
        boolean result6 = solution1(input2);
        boolean result7 = solution1(input3);
        boolean result8 = solution1(input4);

        System.out.println(result5);
        System.out.println(result6);
        System.out.println(result7);
        System.out.println(result8);
    }

    // 내 풀이
    public static boolean solution(String s) {
        Stack<Character> stack = new Stack();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }

        // stack.size()로 하면 로직 도중 pop하면서 크기가 변경되어 로직이 중간에 끊긴다.
        for (int i = 0; i < s.length(); i++) {
            char bracket = stack.pop();

            if (bracket == '(') {
                count--;
            }

            else if (bracket == ')') {
                count++;
            }

            if (count < 0) {
                return false;
            }
        }

        return count == 0;
    }

    // 책 풀이
    // 여는 괄호만 넣고 닿는 괄호는 stack에서 여는 괄호를 빼서 삭제한다.
    public static boolean solution1(String s) {
        Stack<Character> stack = new Stack();

        for (int i = 0; i < s.length(); i++) {
            char bracket = s.charAt(i);

            if (bracket == '(') {
                stack.push(bracket);
            }

            else if (bracket == ')' && !stack.isEmpty()) {
                stack.pop();
            }

            else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
