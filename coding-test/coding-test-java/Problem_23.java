import util.PrintUtil;

import java.util.*;

// 신고 결과 받기
public class Problem_23 {

    public static void main(String[] args) {
        String[] id_list1 = {"muzi", "frodo", "apeach", "neo"};
        String[] report1 = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k1 = 2;

        String[] id_list2 = {"con", "ryan"};
        String[] report2 = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k2 = 3;

        int[] result1 = solution(id_list1, report1, k1);
        int[] result2 = solution(id_list2, report2, k2);

        PrintUtil.printIntegerArray(result1);
        PrintUtil.printIntegerArray(result2);

    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> count = new HashMap<>();
        Map<String, Set<String>> reported = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            count.put(id_list[i], 0);
            reported.put(id_list[i], new HashSet<>());
        }

        for (int i = 0; i < report.length; i++) {
            String[] string = report[i].split(" ");
            if (!reported.get(string[0]).contains(string[1])) {
                count.put(string[1], count.get(string[1]) + 1);
            }
            reported.get(string[0]).add(string[1]);

        }

        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            for (String person : reported.get(id_list[i])) {
                if (count.get(person) >= k) {
                    answer[i]++;
                }
            }
        }

        return answer;
    }

    // 재풀이
    public int[] solution1(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Integer> reportCount = new HashMap<>();
        Map<String, List<String>> history = new HashMap<>();

        for (String id : id_list) {
            reportCount.put(id, 0);
            history.put(id, new ArrayList<>());
        }

        for (String rep : report) {
            String[] reported = rep.split(" ");
            if (history.get(reported[0]).contains(reported[1])) {
                continue;
            }
            reportCount.put(reported[1], reportCount.get(reported[1]) + 1);
            history.get(reported[0]).add(reported[1]);
        }

        for (int i = 0; i < answer.length; i++) {
            int count = 0;
            for (String name : history.get(id_list[i])) {
                if (reportCount.get(name) >= k) {
                    count++;
                }
            }
            answer[i] = count;
        }

        return answer;
    }
}
