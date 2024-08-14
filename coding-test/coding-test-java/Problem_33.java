import java.util.*;

// 섬 연결하기
public class Problem_33 {

    public static void main(String[] args) {
        int n1 = 4;
        int[][] cost = {{0,1,1}, {0,2,2}, {1,2,5}, {1,3,1}, {2,3,8}};

        int result1 = solution(n1, cost);

        System.out.println(result1);
    }

    // 내 처음 풀이: MST가 완성되지 않을 가능성이 있음
//    public static int solution(int n, int[][] costs) {
//        int[][] sortedCost = Arrays.stream(costs.clone()).sorted((cost1, cost2) -> Integer.compare(cost1[2], cost2[2])).toArray(int[][]::new);
//
//        boolean[] visited = new boolean[costs.length];
//
//        int totalCost = 0;
//        visited[sortedCost[0][0]] = true;
//        for (int[] node : sortedCost) {
//            if (!visited[node[1]]) {
//                totalCost += node[2];
//                visited[node[1]] = true;
//            }
//        }
//
//        return totalCost;
//    }

    // 보완한 풀이: cost가 작은 순으로 서로 다른 집합을 만들어서 root가 다르면 union하여 구함
    private static int[] parent;
    public static int solution(int n, int[][] costs) {
        int[][] sortedCost = Arrays.stream(costs.clone()).sorted((cost1, cost2) -> Integer.compare(cost1[2], cost2[2])).toArray(int[][]::new);

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int totalCost = 0;
        for (int[] node : sortedCost) {
            if (find(node[0]) != find(node[1])) {
                union(node[0], node[1]);
                totalCost += node[2];
            }
        }


        return totalCost;
    }

    public static void union(int n1, int n2) {
        parent[find(n1)] = find(n2);
    }

    public static int find(int node) {
        int current = node;
        while (parent[current] != current) {
            current = parent[current];
        }
        // 마지막에 찾은 루트노드로 변경하여 재탐색 시 시간을 줄임
        parent[node] = current;
        return current;
    }
}
