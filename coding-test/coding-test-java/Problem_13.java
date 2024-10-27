import java.util.*;

// 크레인 인형뽑기 게임 (제출 완료)
// https://school.programmers.co.kr/learn/courses/30/lessons/64061
// 각 중에 인형들이 있고 이를 뽑아서 바구니에 넣을 때 연속으로 같은 인형이면 사라진다. 이후 사라진 인형의 개수
public class Problem_13 {
    public static void main(String[] args) {
        int[][] input1 = {
                {0,0,0,0,0},
                {0,0,1,0,3},
                {0,2,5,0,1},
                {4,2,4,4,2},
                {3,5,1,3,1}
        };
        int[][] input2 = {
                {0,0,0,0,0},
                {0,0,1,0,3},
                {0,2,5,0,1},
                {4,2,4,4,2},
                {3,5,1,3,1}
        };
        int[] moves1 = {1,5,3,5,1,2,1,4};

        int result1 = solution(input1, moves1);
        int result2 = solution1(input2, moves1);

        System.out.println(result1);
        System.out.println(result2);
    }

    // 내 풀이
    public static int solution(int[][] input, int[] moves) {
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < moves.length; i++) {
            int column = moves[i] - 1;
            int row = 0;
            while (row < input.length && input[row][column] == 0) {
                row++;
            }
            if (row == input.length) {
                continue;
            }
//            System.out.println("row: " + row + "Column: " + column + "value: " + input[row][column]);
            if (!stack.isEmpty() && stack.peek() == input[row][column]) {
                stack.pop();
                count += 2;
            }
            else{
                stack.push(input[row][column]);
            }
            input[row][column] = 0;
        }
        return count;
    }

    // 제출한 풀이
    class Solution {
        public int solution(int[][] board, int[] moves) {
            int answer = 0;
            Stack<Integer> stack = new Stack<>();
            A: for (int move : moves) {
                int row = 0;
                while (board[row][move - 1] == 0) {
                    row++;
                    if (row == board.length) {
                        continue A;
                    }
                }

                int doll = board[row][move - 1];
                if (stack.isEmpty() || stack.peek() != doll) {
                    stack.push(doll);

                }
                else {
                    stack.pop();
                    answer += 2;
                }
                board[row][move - 1] = 0;
            }
            return answer;
        }
    }

    // 책 풀이
    public static int solution1(int[][] input, int[] moves) {
        Stack<Integer>[] stacks = new Stack[input.length];
        for (int i = 0; i < input.length; i++) {
            stacks[i] = new Stack<>();
        }

        for (int i = input.length - 1; i >= 0; i--) {
            for (int j = 0;  j < input[i].length;j++) {
                if (input[i][j] > 0) {
                    stacks[j].push(input[i][j]);
                }
            }
        }

        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for (int move : moves) {
            if (!stacks[move - 1].isEmpty()) {
                int value = stacks[move - 1].pop();
                if (!stack.isEmpty() && stack.peek().equals(value)) {
                    stack.pop();
                    count += 2;
                }
                else {
                    stack.push(value);
                }
            }
        }

        return count;
    }
}
