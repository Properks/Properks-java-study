import util.PrintUtil;

import java.util.*;

// 저자 문제
// 간단한 BFS 실행
public class Problem_35 {

    public static void main(String[] args) {
        int[][] graph1 = {{1,2}, {1,3}, {2,4}, {2,5}, {3,6}, {3,7}, {4,8}, {5,8}, {6,9}, {7,9}};
        int start1 = 1;
        int n1 = 9;

        int[][] graph2 = {{1,3}, {3,4}, {3,5}, {5,2}};
        int start2 = 1;
        int n2 = 5;

        int[] result1 = solution(graph1, start1, n1);
        int[] result2 = solution(graph2, start2, n2);

        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));
    }

    public static int[] solution(int[][] graph, int start, int n) {

        List<Integer>[] nodes = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int[] node : graph) {
            nodes[node[0]].add(node[1]);
        }

        List<Integer> answer = new ArrayList<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];

        queue.addLast(start);
        while (!queue.isEmpty()) {
            int node = queue.pollFirst();
            if (!visited[node]) {
                answer.add(node);
                visited[node] = true;
                queue.addAll(nodes[node]);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
