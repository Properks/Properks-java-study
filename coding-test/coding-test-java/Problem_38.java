import java.util.*;

// 네트워크
public class Problem_38 {

    public static void main(String[] args) {
        int n1 = 3;
        int[][] computers1 = {{1,1,0}, {1,1,0}, {0,0,1}};

        int n2 = 3;
        int[][] computers2 = {{1,1,0}, {1,1,1}, {0,1,1}};

        int result1 = solution(n1, computers1);
        int result2 = solution(n2, computers2);

        System.out.println(result1);
        System.out.println(result2);

        int result3 = solution1(n1, computers1);
        int result4 = solution1(n2, computers2);

        System.out.println(result3);
        System.out.println(result4);
    }

    // 내 풀이
    // dfs 보다는 집합에 가깝게 풀이
    public static int solution(int n, int[][] computers) {
        int[] parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }


        for (int i = 0; i < n - 1; i++) {
            int parent = parents[i];
            for (int j = i + 1; j < n; j++) {
                if (computers[i][j] == 1) {
                    parents[j] = parent;
                }
            }
        }

        return (int) Arrays.stream(parents).distinct().count();
    }

    // 책 풀이
    private static boolean[] visited;
    private static int[][] computer;
    public static int solution1(int n, int[][] computers) {
        int answer = 0;
        computer = computers;
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                answer++;
            }
        }
        return answer;
    }

    public static void dfs(int now) {
        visited[now] = true;

        for (int i = 0; i < computer[now].length; i++) {
            if (computer[now][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}
