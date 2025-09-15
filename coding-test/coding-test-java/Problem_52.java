import util.PrintUtil;

import java.util.*;

// 문자열 내 마음대로 정렬하
public class Problem_52 {

    public static void main(String[] args) {
        String[] input1 = {"sun", "bed", "car"};
        int n1 = 1;

        String[] input2 = {"abce", "abcd", "cdx"};
        int n2 = 2;

        String[] result1 = solution(input1, n1);
        String[] result2 = solution(input2, n2);

        PrintUtil.printStringArray(result1);
        PrintUtil.printStringArray(result2);
    }

    public static String[] solution(String[] strings, int n) {
        return mySolution(strings, n);
    }

    public static String[] mySolution(String[] strings, int n) {
        return Arrays.stream(strings).sorted((s1, s2) -> s1.charAt(n) == s2.charAt(n) ? s1.compareTo(s2) : s1.charAt(n) - s2.charAt(n)).toArray(String[]::new);
    }

    public static String[] bookSolution(String[] strings, int n) {
        return Arrays.stream(strings).sorted((s1, s2) -> s1.charAt(n) == s2.charAt(n) ? s1.compareTo(s2) : Character.compare(s1.charAt(n), s2.charAt(n))).toArray(String[]::new);
    }
}
