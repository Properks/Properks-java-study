import java.util.*;

public class Problem_46 {
    public static void main(String[] args) {
        int n = 4;
        int result = solution(n);
        System.out.println(result);

        int result2 = solution1(n);
        System.out.println(result2);
    }

    public static int solution(int n) {
        return dfs(n, new ArrayList<>(), 0) / factorial(n);
    }

    // 백트래킹 적용, 대각선을 배열로 생각하기
    public static int solution1(int n) {
        int answer = 0;
        boolean[] columns = new boolean[n];
        boolean[] diagonal1 = new boolean[n * 2];
        boolean[] diagonal2 = new boolean[n * 2];
        answer = backTrack(n, columns, diagonal1, diagonal2, 0);
        return answer;
    }

    public static int backTrack(int n, boolean[] columns, boolean[] diagonal1, boolean[] diagonal2, int count) {
        int answer = 0;
        if (n == count) {
            return answer + 1;
        }

        for (int i = 0; i < n; i++) {
            if (!columns[i] && !diagonal1[i + count] && !diagonal2[(n - 1) + count - i]) {
                columns[i] = diagonal1[i + count] = diagonal2[(n - 1) + count - i] = true;
                answer += backTrack(n, columns, diagonal1, diagonal2, count + 1);
                columns[i] = diagonal1[i + count] = diagonal2[(n - 1) + count - i] = false;
            }
        }

        return answer;
    }

    // 백트래킹이 아닌 완전 탐색임... 조합인데 순열로 되어서 factorial로 나누어 주어야함...
    public static int dfs(int n, List<Block> blocks, int count) {
        int answer = 0;

        if (count == n) {
            return 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isValid(blocks, new Block(i, j))) {
                    List<Block> clone = new ArrayList<>(blocks);
                    clone.add(new Block(i, j));
                    answer += dfs(n, clone, count + 1);
                }
            }
        }
        return answer;
    }

    public static boolean isValid(List<Block> blocks, Block check) {
        for (Block block : blocks) {
            int x = block.x - check.x;
            int y = block.y - check.y;
            // 직선
            if (x == 0 || y == 0) {
                return false;
            }
            // 대각선
            if (Math.abs(x) - Math.abs(y) == 0) {
                return false;
            }
        }
        return true;
    }

    public static class Block {
        int x,y;
        public Block(int x, int y) {
            this.x = x;
            this.y= y;
        }
    }

    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }
}
