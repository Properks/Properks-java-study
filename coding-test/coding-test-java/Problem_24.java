import util.PrintUtil;

import java.util.*;

// 메뉴 리뉴얼
public class Problem_24 {
    public static void main(String[] args) {
        String[] orders1 = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course1 = {2, 3, 4};

        String[] orders2 = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course2 = {2, 3, 5};

        String[] orders3 = {"XYZ", "XWY", "WXA"};
        int[] course3 = {2, 3, 4};

        String[] result1 = solution1(orders1, course1);
        String[] result2 = solution(orders2, course2);
        String[] result3 = solution(orders3, course3);

        PrintUtil.printStringArray(result1);
        PrintUtil.printStringArray(result2);
        PrintUtil.printStringArray(result3);
    }

    // 조합을 사용하여 가능한 조합들을 구하고 이 조합이 나온 횟수를 기록하기
    public static String[] solution(String[] orders, int[] course) {
        Map<Integer, Map<String, Integer>> map = new HashMap<>();

        for (int i : course) {
             map.put(i, new HashMap<>());
        }

        for (String order : orders) {
            for (int i : course) {
                List<String> results = new ArrayList<>();
                boolean[] visited = new boolean[order.length()];
                char[] charArray = order.toCharArray();
                Arrays.sort(charArray);
                combination(results, charArray, visited, 0, i);
                for (String result : results) {
                    Map<String, Integer> count = map.get(i);
                    count.put(result, count.getOrDefault(result, 0) + 1);
                }
            }
        }

        List<String> result = new ArrayList<>();

        for (int i : course) {
            Map<String, Integer> count = map.get(i);
            count.values().stream().max(Comparator.comparingInt(Integer::intValue)).ifPresent(cnt ->
                    count.entrySet().stream().filter(value -> value.getValue().equals(cnt) && cnt > 1).forEach(entry -> result.add(entry.getKey())));
        }

        Collections.sort(result);

        return result.stream().toArray(String[]::new);
    }

    // 조합 구하기 nCr
    // visited를 설정하여 visited의 값이 true인 값으로 하나의 string을 만드는 방식
    public static void combination(List<String> result, char[] array, boolean[] visited, int start, int r) {
        if (r == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    sb.append(array[i]);
                }
            }
            result.add(sb.toString());
        }
        else {
            for (int i = start; i < array.length; i++) {
                visited[i] = true;
                combination(result, array, visited, i + 1, r - 1);
                visited[i] = false;
            }
        }
    }

    // 재풀이 (실패)
    // 정답을 추출하는 부분의 Stream 다시 한번 생각해보기
    public static String[] solution1(String[] orders, int[] course) {
        Map<String, Integer> count = new HashMap<>();
        boolean[] visited;

        for (String order : orders) {
            for (int index : course) {
                if (order.length() < index) {
                    continue;
                }
                visited = new boolean[order.length()];
                combination(count, visited, order, 0, index);
            }
        }

        List<String> answer = new ArrayList<>();

        for (int index : course) {
            count.entrySet().stream().filter(o -> o.getKey().length() == index).max((o1, o2) -> o1.getValue().compareTo(o2.getValue())).ifPresent(max -> count.entrySet().stream().filter(o -> o.getValue().equals(max.getValue()) && max.getValue() > 1).forEach(o -> answer.add(o.getKey())));
        }

        return answer.stream().sorted().toArray(String[]::new);
    }

    public static void combination(Map<String, Integer> count,
                                   boolean[] visited,
                                   String order,
                                   int start,
                                   int index) {
        if (index == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    sb.append(order.toCharArray()[i]);
                }
            }
            count.put(sb.toString(), count.getOrDefault(sb.toString(), 0) + 1);
        }
        else {
            for (int i = start; i < order.length(); i++) {
                visited[i] = true;
                combination(count, visited, order, i + 1, index - 1);
                visited[i] = false;
            }
        }
    }
}
