import java.util.*;

// 경주로 건설
public class Problem_41 {
    public static void main(String[] args) {
        int[][] input1 = {{0,0,0}, {0,0,0}, {0,0,0}};
        int[][] input2 = {{0,0,0,0,0,0,0,1}, {0,0,0,0,0,0,0,0}, {0,0,0,0,0,1,0,0}, {0,0,0,0,1,0,0,0}, {0,0,0,1,0,0,0,1}, {0,0,1,0,0,0,1,0}, {0,1,0,0,0,1,0,0}, {1,0,0,0,0,0,0,0}};

        int result1 = solution(input1);
        int result2 = solution(input2);

        System.out.println(result1);
        System.out.println(result2);
    }

    public static class Location {
        int x, y, cost, prevDirection;
        Set<Location> visited;

        public Location(int x, int y, int cost, int prevDirection, Set<Location> visited) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.prevDirection = prevDirection;
            this.visited = visited;
        }

        public boolean equals(Object o) {
            return this.x == ((Location)o).x && this.y == ((Location)o).y;
        }
        public int hashCode() {
            return x * 100 + y;
        }
    }

    public static int solution(int[][] board) {
        int cost = Integer.MAX_VALUE;
        int n = board.length;
        int[][] directions = {{0,1}, {1,0}, {0, -1}, {-1, 0}};

        ArrayDeque<Location> queue = new ArrayDeque<>();
        queue.addLast(new Location(0,0, 0, 0, new HashSet<>()));

        while (!queue.isEmpty()) {
            Location now = queue.pollFirst();
            if (now.x == n - 1 && now.y == n - 1) {
                cost = Math.min(now.cost, cost);
            }
            for (int i = 0; i < 4; i++) {
                int newX = now.x + directions[i][0];
                int newY = now.y + directions[i][1];
                if (!isValid(newX, newY, n) || board[newX][newY] == 1) {
                    continue;
                }

                int newCost = 100;
                if (now.cost != 0) {
                    newCost = i % 2 == now.prevDirection ? now.cost + 100 : now.cost + 500 + 100; // 코너돌때 500 추가
                }
                Set<Location> newSet = new HashSet<>(now.visited);
                newSet.add(now);
                Location newLocation = new Location(newX, newY, newCost, i % 2, newSet);
                if (now.visited.contains(newLocation)) {
                    continue;
                }
                queue.addLast(newLocation);
            }
        }

        return cost;
    }

    public static boolean isValid(int x, int y, int n) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
