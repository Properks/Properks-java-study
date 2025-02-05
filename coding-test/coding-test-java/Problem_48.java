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

        long start;
        long time;

        start = System.nanoTime();
        int result1 = solution(n1, weak1, dist1);
        time = System.nanoTime() - start;
        System.out.println(result1);
        System.out.println("My Solution(1): " + time);

        start = System.nanoTime();
        int result2 = solution(n2, weak2, dist2);
        time = System.nanoTime() - start;
        System.out.println(result2);
        System.out.println("My Solution(2): " + time);

        start = System.nanoTime();
        int result3 = Solution.solution(n1, weak1, dist1);
        time = System.nanoTime() - start;
        System.out.println(result3);
        System.out.println("Solution in book(1): " + time);

        start = System.nanoTime();
        int result4 = solution(n2, weak2, dist2);
        time = System.nanoTime() - start;
        System.out.println(result4);
        System.out.println("Solution in book(2): " + time);

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
        if (min < count) {
            return;
        }
        if (Arrays.stream(weak).allMatch(index -> visited[index])) {
            min = Math.min(min, count);
            return;
        }

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

    private static class Solution {
        private static int length, answer;
        private static int[] Weak;
        private static boolean[] used;

        // ❶ dist 배열의 친구들로 모든 외벽이 점검 가능한지 확인
        private static boolean check(int[] dist) {
            // ❷ 점검을 시작하는 외벽을 0 부터 length 까지 전부 확인함
            for (int i = 0; i < length; i++) {
                int idx = i;
                // ❸ 각 친구가 점검 가능한 외벽을 모두 점검하며 진행
                for (int distance : dist) {
                    int position = Weak[idx++] + distance;
                    while (idx < Weak.length && Weak[idx] <= position) {
                        idx++;
                    }
                }
                // ❹ 모든 외벽을 점검 가능하면 true 반환
                if (idx - i >= length)
                    return true;
            }
            // ❺ 모든 외벽을 점검할 수 없으면 false 반환
            return false;
        }

        // ❻ n개의 숫자를 나열하는 모든 경우의 수를 구함
        private static void backtrack(int n, int[] dist, int[] org) {
            if (n == org.length) {
                // ❼ 모든 외벽이 점검 가능하면 답 저장
                if (check(dist))
                    answer = n;
                return;
            }

            // ❽ 한 번 사용한 친구는 다시 사용하지 않도록 used 배열을 활용하여 백트래킹
            for (int i = 0; i < org.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    dist[n] = org[i];
                    backtrack(n + 1, dist, org);
                    used[i] = false;
                }
            }
        }

        public static int solution(int n, int[] weak, int[] dist) {
            // ❾ 주어진 weak 지점들을 선형으로 만들어 줌
            length = weak.length;
            Weak = new int[length * 2];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < length; j++) {
                    Weak[j + (i * length)] = weak[j] + (i * n);
                }
            }

            // ➓ 오름차순으로 정렬
            Arrays.sort(dist);
            answer = -1; // 답을 -1 로 초기화
            used = new boolean[dist.length]; // used 배열 생성

            // ⓫ 가장 점검 범위가 큰 친구부터 1명 씩 늘려가며 답을 탐색
            for (int i = 1; i <= dist.length; i++) {
                int[] org = new int[i];
                System.arraycopy(dist, dist.length - i, org, 0, i);
                backtrack(0, new int[i], org);
                if (answer > 0) // 답을 찾았으면 종료해야 함
                    break;
            }

            return answer;
        }
    }
}
