import java.util.*;

// 외벽 점검
public class Problem_48 {
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int n1 = 12;
        int[] weak1 = {1,5,6,10};
        int[] dist1 = {1,2,3,4};

        int n2 = 12;
        int[] weak2 = {1,3,4,9,10};
        int[] dist2 = {3,5,7};

        int result1 = solution(n1, weak1, dist1);
        System.out.println(result1);

        int result2 = solution(n2, weak2, dist2);
        System.out.println(result2);
    }

    public static int solution(int n, int[] weak, int[] dist) {
        boolean[] visited = new boolean[n];
        boolean[] pick = new boolean[dist.length];
        Arrays.fill(visited, false);
        Arrays.fill(pick, false);
        backTrack(n, weak, dist, visited, pick, 0);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void backTrack(int n, int[] weak, int[] dist, boolean[] visited, boolean[] pick, int count) {
        if (Arrays.stream(weak).allMatch(index -> visited[index])) {
            min = Math.min(min, count);
            return;
        }

//        boolean isEnd = true;
//        for (int i = 0; i < pick.length; i++) {
//            if (!pick[i]) {
//                isEnd = false;
//                break;
//            }
//        }
//        if (isEnd) {return;}

        for (int i = 0; i < dist.length; i++) {
            if (pick[i]) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                int distance = dist[i];
                if (isValid(visited, n, j, distance)) {
                    fillBoolean(visited, n, j, j + distance, true);
                    pick[i] = true;
                    backTrack(n, weak, dist, visited, pick, count + 1);
                    fillBoolean(visited, n, j, j + distance, false);
                    pick[i] = false;
                }
            }
        }
    }

    public static boolean isValid(boolean[] visited, int n, int from, int length) {
        for (int i = 0; i <= length; i++) {
            if (visited[(from + i) % n]) {
                return false;
            }
        }
        return true;
    }

    public static void fillBoolean(boolean[] visited,int n, int from, int to, boolean bool) {
        for (int i = from; i <= to; i++) {
            visited[i % n] = bool;
        }
    }
}
