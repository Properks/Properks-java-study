import util.PrintUtil;

import java.util.*;

public class Problem_56 {

    public static void main(String[] args) {
        String input1 = "{{2}, {2, 1}, {2, 1, 3}, {2, 1, 3, 4}}";
        String input2 = "{{1, 2, 3}, {2, 1}, {1, 2, 4, 3}, {2}}";
        String input3 = "{{20, 111}, {111}}";
        String input4 = "{{123}}";
        String input5 = "{{4, 2, 3}, {3}, {2, 3, 4, 1}, {2, 3}}";

        PrintUtil.printIntegerArray(solution(input1));
        PrintUtil.printIntegerArray(solution(input2));
        PrintUtil.printIntegerArray(solution(input3));
        PrintUtil.printIntegerArray(solution(input4));
        PrintUtil.printIntegerArray(solution(input5));
    }

    public static int[] solution(String s) {
        return bookSolution(s);
    }

    public static int[] mySolution(String s) {
        String[] array = createArray(s);

        int size = array.length;
        int[] answer = new int[size];

        for (int i = 0; i < size; i++) {
            String str = array[i];
            str = str.replaceAll("\\{", "");
            str = str.replaceAll("\\}", "");
            str = str.replaceAll("\\,", "");
            for (int a: answer) {
                str = str.replace(String.valueOf(a), "");
            }
            answer[i] = Integer.parseInt(str.replaceAll(" ", ""));
        }

        return answer;
    }

    public static String[] createArray(String s) {
        String[] strs = s.substring(1, s.length() - 1).split("}, ");
        return Arrays.stream(strs).sorted((s1, s2) -> Integer.compare(s1.length(), s2.length())).toArray(String[]::new);

//        String[] strArray = s.substring(1, s.length() - 1).split(", ");
//
//        List<List<Integer>> list = new ArrayList<>();
//
//        for (String str: strArray) {
//            List<Integer> integers = new ArrayList<>();
//            String[] strs = str.substring(1, s.length() - 1).split(", ");
//            for (String str2: strs) {
//                integers.add(Integer.parseInt(str2));
//            }
//            list.add(integers);
//        }
//
//        return list;
    }

    public static int[] bookSolution(String s) {

        String[] strs = s.substring(0, s.length() - 2).replace("{", "").split("}, ");
        int[] answer = new int[strs.length];
        Set<String> set = new HashSet<>();

        Arrays.sort(strs, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        for (int i = 0; i < strs.length; i++) {
            String[] numbers = strs[i].split(", ");
            for (String number: numbers) {
                if (!set.contains(number)) {
                    answer[i] = Integer.parseInt(number);
                    set.add(number);
                }
            }
        }
        return answer;
    }
}
