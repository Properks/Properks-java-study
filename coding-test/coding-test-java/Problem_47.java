import java.util.*;

public class Problem_47 {
    static int max = 0;
    static int[] answer = {-1};
    public static void main(String[] args) {
        int n1 = 5;
        int[] info1 = {2,1,1,1,0,0,0,0,0,0,0};

        int n2 = 1;
        int[] info2 = {1,0,0,0,0,0,0,0,0,0,0};

        int n3 = 9;
        int[] info3 = {0,0,1,2,0,1,1,1,1,1,1};

        int[] result1 = solution1(n1, info1);
        System.out.println(Arrays.toString(result1));

        int[] result2 = solution1(n2, info2);
        System.out.println(Arrays.toString(result2));

        int[] result3 = solution1(n3, info3);
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

    public static int[] solution1(int n, int[] info) {
        answer = new int[]{-1};
        backTrack1(n, info, new int[11], 0);
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

    // TODO: for문 섞어서 해보자 2개의 분기 이외의 상황
    public static void backTrack1(int n, int[] info, int[] pick, int index) {
        if (n <= 0 || index >= 11) {
            calculateScore1(info, pick);
            return;
        }


        for (int i = index; i < 11; i++ ) {
            int count = Math.min(n, info[i] + 1);
            pick[i] = count;
            backTrack1(n - count, info, pick, i + 1);
            pick[i] = 0;
        }
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

    public static void calculateScore1(int[] info, int[] pick) {
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
        if (ryanScore > peachScore) {
            if (ryanScore > max) {
                answer = pick.clone();
                max = ryanScore;
            }
        }
    }
}
