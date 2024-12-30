import java.util.*;

// 전력망을 둘로 나누기
public class Problem_42 {
    static int answer1 = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int n1 = 9;
        int[][] wires1 = {{1,3}, {2,3}, {3,4}, {4,5}, {4,6}, {4,7}, {7,8}, {7,9}};
        int n2 = 4;
        int[][] wires2 = {{1,2}, {2,3}, {3,4}};
        int n3 = 7;
        int[][] wires3 = {{1,2}, {2,7}, {3,7}, {3,4}, {4,5}, {6,7}};

        int result1 = solution(n1, wires1);
        int result2 = solution(n2, wires2);
        int result3 = solution(n3, wires3);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);

        System.out.println("DFS");

        int result4 = solutionWithDFS(n1, wires1);
        int result5 = solutionWithDFS(n2, wires2);
        int result6 = solutionWithDFS(n3, wires3);

        System.out.println(result4);
        System.out.println(result5);
        System.out.println(result6);

        System.out.println("DFS O(n)");

        int result7 = solutionWithDFS1(n1, wires1);
        int result8 = solutionWithDFS1(n2, wires2);
        int result9 = solutionWithDFS1(n3, wires3);

        System.out.println(result7);
        System.out.println(result8);
        System.out.println(result9);
    }

    public static int solution(int n, int[][] wires) {
        int min = Integer.MAX_VALUE;
        Set<Integer> set1;
        Set<Integer> set2;

        for (int i = 0; i < wires.length; i++) {
            set1 = new HashSet<>();
            set2 = new HashSet<>();
            for (int j = 0; j < wires.length; j++) {
                if (i == j) {
                    continue;
                }
                if (set1.contains(wires[j][0]) || set1.contains(wires[j][1]) || set1.isEmpty()) {
                    set1.add(wires[j][0]);
                    set1.add(wires[j][1]);
                }
                else if (set2.contains(wires[j][0]) || set2.contains(wires[j][1]) || set2.isEmpty()) {
                    set2.add(wires[j][0]);
                    set2.add(wires[j][1]);
                }
            }
            min = Math.min(min, Math.abs(set1.size() - set2.size()));
        }
        return min;
    }

    public static int solutionWithDFS(int n, int[][] wires) {
        List<Integer>[] nodes = new ArrayList[n + 1];
        boolean[] visited = new boolean[n + 1];
        int answer = n;
        for (int i = 0; i < n + 1; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < wires.length; i++) {
            nodes[wires[i][0]].add(wires[i][1]);
            nodes[wires[i][1]].add(wires[i][0]);
        }

        for (int i = 0; i < wires.length; i++) {
            Arrays.fill(visited, false);
            int sum = dfs(nodes, visited, 1, wires, i);
            answer = Math.min(answer, Math.abs(2 * sum - n));
        }

        return answer;
    }

    // O(n)으로 풀기
    public static int solutionWithDFS1(int n, int[][] wires) {
        List<Integer>[] nodes = new ArrayList[n + 1];
        boolean[] visited = new boolean[n + 1];
        for (int i = 0; i < n + 1; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < wires.length; i++) {
            nodes[wires[i][0]].add(wires[i][1]);
            nodes[wires[i][1]].add(wires[i][0]);
        }
        answer1 = Integer.MAX_VALUE;

        Arrays.fill(visited, false);
        dfs1(nodes, n, visited, 1);

        return answer1;
    }

    public static int dfs(List<Integer>[] nodes, boolean[] visited, int index, int[][]wires, int block) {
        visited[index] = true;
        int sum = 0;

        for (int node : nodes[index]) {
            if (visited[node] || (wires[block][0] == index && wires[block][1] == node) || (wires[block][1] == index && wires[block][0] == node)) {
                continue;
            }
            sum += dfs(nodes, visited, node, wires, block);
        }
        return sum + 1;
    }

    public static int dfs1(List<Integer>[] nodes, int n, boolean[] visited, int index) {
        visited[index] = true;
        int sum = 0;

        for (int node : nodes[index]) {
            if (visited[node]) {
                continue;
            }
            // 이렇게 하면 자식 노드가 여러 개일 때 그 여러 경우의 수를 셀 수 없음 즉, 1,2가 있을 때 1이 분리된 경우, 2가 분리된 경우를 계산해야 하는데, 2를 계산할 때 2의 자식이 1의 자식과 더해져 2개가 되어서 실패한다.
//            sum += dfs1(nodes, n, visited, node);
//            answer1 = Math.min(answer1, Math.abs(2 * sum - n));
            int child = dfs1(nodes, n, visited, node);
            answer1 = Math.min(answer1, Math.abs(2 * child - n));
            sum += child;
        }
        return sum + 1;
    }
}
