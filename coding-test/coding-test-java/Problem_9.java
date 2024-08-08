import java.util.*;

// 저자 문제
// 10진수를 2진수로 변형하는 과정
public class Problem_9 {

    public static void main(String[] args) {
        int input1 = 10;
        int input2 = 27;
        int input3 = 12345;

        String result1 = solution(input1);
        String result2 = solution(input2);
        String result3 = solution(input3);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }

    public static String solution(int input) {
        Stack<Integer> stack = new Stack();

        int i = 2;
        // 책에서는 조건은 input > 0 형태로 함
        while (input != 0){
            stack.push(input % i);
            input /= i;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

}
