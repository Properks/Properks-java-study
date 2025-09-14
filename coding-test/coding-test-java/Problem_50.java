import java.util.*;

//저자 문제
public class Problem_50 {

    public static void main(String[] arge) {
        String input1 = "hello";
        String input2 = "algorithm";

        String result1 = solution(input1);
        String result2 = solution(input2);

        System.out.println(result1);
        System.out.println(result2);
    }

    public static String solution(String s) {
        return mySolution(s);
    }

    private static String mySolution(String s) {
        int n = 26;
        int[] count = new int[n];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < count[i]; j++) {
                sb.append((char)(i + 'a'));
            }
        }
        return sb.toString();
    }
}


