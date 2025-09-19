import util.PrintUtil;

import java.util.*;

public class Problem_54 {

    public static void main(String[] args) {

        int[] input1 = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands1 = {{2,5,3}, {4,4,1}, {1,7,3}};

        int[] result1 = solution(input1, commands1);
        PrintUtil.printIntegerArray(result1);

    }

    public static int[] solution(int[] array, int[][] commands) {
        return bookSolution(array, commands);
    }

    public static int[] mySolution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int[] command = commands[i];
            int[] sortedArray= array.clone();
            Arrays.sort(sortedArray, command[0] - 1, command[1]);
            answer[i] = sortedArray[command[0] + command[2] - 2];
        }

        return answer;
    }

    public static int[] bookSolution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] command = commands[i];
            int[] copy = Arrays.copyOfRange(array, command[0] - 1, command[1]);
            Arrays.sort(copy);

            answer[i] = copy[command[2] - 1];

        }
        return answer;
    }
}
