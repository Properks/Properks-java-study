import java.util.*;

public class Problem_47 {
    public static void main(String[] args) {
        int n1 = 5;
        int[] info1 = {2,1,1,1,0,0,0,0,0,0,0};

        int n2 = 1;
        int[] info2 = {1,0,0,0,0,0,0,0,0,0,0};

        int n3 = 9;
        int[] info3 = {0,0,1,2,0,1,1,1,1,1,1};

        int[] result1 = solution(n1, info1);
        System.out.println(Arrays.toString(result1));

        int[] result2 = solution(n2, info2);
        System.out.println(Arrays.toString(result2));

        int[] result3 = solution(n3, info3);
        System.out.println(Arrays.toString(result3));
    }

    public static int[] solution(int n, int[] info) {
        int[] answer = new int[11];
        Arrays.fill(answer, 0);
        answer = backTrack(n, info, answer, 0);
        if (Arrays.stream(answer).allMatch(value -> value == 0)) {
            return new int[]{-1};
        }
        return answer;
    }

    public static int[] backTrack(int n, int[] info, int[] pick, int index) {
        if (n <= 0 || index >= 11) {
            return pick.clone();
        }

        int[] left = new int[11];
        int[] right;
        Arrays.fill(left, 0);
        int peachShot = info[index];
        if (n > peachShot) {
            pick[index] = peachShot + 1;
            n -= peachShot + 1;
            left = backTrack(n, info, pick, index + 1);
            pick[index] = 0;
            n += peachShot + 1;
        }

        right = backTrack(n, info, pick, index + 1);

        int leftScore = calculateScore(info, left);
        int rightScore = calculateScore(info, right);
        return leftScore > rightScore ? left : right;
    }

    public static int calculateScore(int[] info, int[] pick) {
        int peachScore = 0;
        int ryanScore = 0;
        for (int i = 0; i < 11; i++) {
            if (info[i] < pick[i]) {
                ryanScore += (10 - i);
            }
            else if (info[i] > pick[i] || (info[i] != 0 && info[i] == pick[i])) {
                peachScore += (10 - i);
            }
        }
        return ryanScore > peachScore ? ryanScore : -1;
    }
}
