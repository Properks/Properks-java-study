import util.PrintUtil;

import java.util.*;

// 저자 문제
// 간단한 DFS 실행
public class Problem_34 {

    public static void main(String[] args) {

        int[][] graphs1 = {{1,2}, {2,3}, {3,4}, {4,5}};
        int[][] graphs2 = {{1,2}, {1,3}, {2,4}, {2,5}, {3,6}, {5,6}};

        int start1 = 1;
        int start2 = 1;

        int n1 = 5;
        int n2 = 6;

        PrintUtil.printIntegerArray(solution(graphs1, start1, n1));

        PrintUtil.printIntegerArray(solution(graphs2, start2, n2));

    }

    private static List<Integer> answer;
    private static boolean[] visited;
    public static int[] solution(int[][] graphs, int start, int n) {
        answer = new ArrayList<>();
        visited = new boolean[n + 1];
        // 책 풀이
        // ArrayList<Integer>[] nodes = new ArrayList[n + 1];
        Map<Integer, List<Integer>> nodes = new HashMap<>();

        for (int i = 0; i < n; i++) {
            nodes.put(i + 1, new ArrayList<>());
        }

        for (int[] node: graphs) {
            nodes.get(node[0]).add(node[1]);
        }

        dfs(nodes, start);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void dfs(Map<Integer, List<Integer>> nodes, int start) {
        List<Integer> children = nodes.get(start);
        answer.add(start);
        visited[start] = true;
//        if (children != null) { new ArrayList로 초기화하므로 의미 없다.
        for (int child : children) {
            if (!visited[child]) {
                dfs(nodes, child);
            }
        }
//        }
    }
}
