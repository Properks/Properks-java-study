import util.PrintUtil;

import java.util.*;

// 주식가격이 떨어지지 않은 시간 계산
public class Problem_12 {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 2, 3};

        int[] result1 = solution(input);
        int[] result2 = solution1(input);

        PrintUtil.printArray(result1);
        PrintUtil.printArray(result2);
    }

    // 내 풀이
    // index만 있다면 input을 로직에서 변경하지 않는 이상 다시 값을 가져올 수 있다는 것을 인지할 필요가 있다(index로 값을 가져올 수 있다.). int[] -> Integer
    // 한번 떨어진 경우 해당 값보다 작은 값이 나올 때까지 pop하는 과정 없음 -> 오답
    public static int[] solution(int[] input) {
        Stack<int[]> stack = new Stack<>();
        int[] result = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            if (!stack.isEmpty() && stack.peek()[1] > input[i]){
                int[] value = stack.pop();
                result[value[0]] = i - value[0];
            }
            int[] value = {i, input[i]};
            stack.push(value);
        }
        while (!stack.isEmpty()) {
            int[] value = stack.pop();
            result[value[0]] = input.length - value[0] - 1;
        }
        return result;
    }

    // 책 풀이
    public static int[] solution1(int[] input) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            while (!stack.isEmpty() && input[stack.peek()] > input[i]){
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int index = stack.pop();
            result[index] = input.length - index - 1;
        }
        return result;
    }

}
