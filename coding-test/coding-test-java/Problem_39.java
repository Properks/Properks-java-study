import java.util.*;

// 미로 탍출
public class Problem_39 {

    public static void main(String[] args) {
        String[] maps1 = {"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"};
        String[] maps2 = {"LOOXS", "OOOOX", "OOOOO", "OOOOO", "EOOOO"};

        int result1 = solution(maps1);
        int result2 = solution(maps2);

        System.out.println(result1);
        System.out.println(result2);
    }

    public static int solution(String[] maps) {
        char[][] map = new char[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++) {
            map[i] = maps[i].toCharArray();
        }
        int x = 0;
        int y = 0;
        for (int i = 0; i < maps.length; i++) {
            if (maps[i].contains("S")) {
                x = maps[i].indexOf("S");
                y = i;
            }
        }

        Node leverCost = bfs(map, x, y, 'L');
        if (leverCost == null) {
            return -1;
        }
        Node endCost = bfs(map, leverCost.x, leverCost.y, 'E');
        if (endCost == null) {
            return -1;
        }
        return leverCost.cost + endCost.cost;
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

    public static Node bfs(char[][] map, int x, int y, char end) {
        int[][] directions = {{0, 1}, {1,0}, {0,-1}, {-1,0}};
        boolean[][] visited = new boolean[map.length][map[0].length];

        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.addLast(new Node(x, y, 0));

        while(!queue.isEmpty()) {
            Node now = queue.pollFirst();
            visited[now.y][now.x] = true;
            for (int[] direction : directions) {
                if (map[now.y][now.x] == end) {
                    return now;
                }

                int newX = now.x + direction[0];
                int newY = now.y + direction[1];
                if (newX < 0 || newX >= map.length || newY < 0 || newY >= map[0].length || map[newY][newX] == 'X' || visited[newY][newX]) {
                    continue;
                }
                queue.addLast(new Node(newX, newY, now.cost + 1));
            }
        }
        return null;
    }
}
