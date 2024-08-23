import java.util.*;

// 게임 맵 최단 거리
public class Problem_37 {

    public static void main(String[] args) {
        int[][] maps1 = {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,1}, {0,0,0,0,1}};
        int[][] maps2 = {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,0}, {0,0,0,0,1}};

        int result1 = solution(maps1);
        int result2 = solution(maps2);

        System.out.println(result1);
        System.out.println(result2);
    }

    public static class Node {
        int x;
        int y;
        int cost;
        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    // 내 풀이
    public static int solution(int[][] maps) {
        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int[][] cost = new int[maps.length][maps[0].length];
        for (int[] part : cost) {
            Arrays.fill(part, Integer.MAX_VALUE);
        }

        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0,0, 1));
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for (int[] direction : directions) {
                int newX = now.x + direction[0];
                int newY = now.y + direction[1];
                if (newX < 0 || newX >= 5 || newY < 0 || newY >= 5) {
                    continue;
                }
                if (maps[newY][newX] == 1 && cost[newY][newX] > now.cost + 1) {
                    cost[newY][newX] = now.cost + 1;
                    queue.add(new Node(newX, newY, now.cost + 1));
                }
            }
        }

        return cost[maps.length - 1][maps[0].length - 1] == Integer.MAX_VALUE ? -1 : cost[maps.length - 1][maps[0].length - 1];
    }
}
