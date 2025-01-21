import java.util.*;

// 피로도
public class Problem_45 {

    static int max;
    public static void main(String[] args) {
        int k1 = 80;
        int[][] dungeons1 = {{80, 20}, {50, 40}, {30, 10}};

        int result1 = solution(k1, dungeons1);
        System.out.println(result1);
    }

    public static int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        Arrays.fill(visited, false);

        dfs(k, dungeons, visited, 0);

        return max;
    }

    public static void dfs(int k, int[][] dungeons, boolean[] visited, int count) {

        // 종료 조건 확인
        boolean end = true;
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                end = false;
                break;
            }
        }
        if (end) {
            // 종료 시 행동
            max = Math.max(max, count);
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                if (dungeons[i][0] <= k) {
                    // 진행
                    k -= dungeons[i][1];
                    visited[i] = true;
                    // 아래로 dfs처럼 진행
                    dfs(k, dungeons, visited, count + 1);
                    // 진행 취소
                    k += dungeons[i][1];
                    visited[i] = false;
                }
                else {
                    // 종료 시 행동
                    max = Math.max(max, count);
                }
            }
        }
    }
}
