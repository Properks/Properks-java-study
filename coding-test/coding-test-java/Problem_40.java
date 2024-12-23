import java.util.*;

// 배달
public class Problem_40 {

    public static void main(String[] args) {
        int n1 = 5;
        int[][] road1 = {{1,2,1}, {2,3,3}, {5,2,2}, {1,4,2}, {5,3,1}, {5,4,2}};
        int k1= 3;

        int n2 = 6;
        int[][] road2 = {{1,2,1}, {1,3,2}, {2,3,2}, {3,4,3}, {3,5,2}, {3,5,3}, {5,6,1}};
        int k2 = 4;

        int result1 = solution(n1, road1, k1);
        int result2 = solution(n2, road2, k2);

        System.out.println(result1);
        System.out.println(result2);

    }


    public static class Node {
        int destination;
        int cost;

        public Node(int destination, int cost) {
            this.destination = destination;
            this.cost = cost;
        }
    }

    public static int solution(int n, int[][] road, int k) {
        List<Node>[] nodes = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            nodes[i] = new ArrayList<>();
        }
        int[] cost = new int[n + 1];

        Arrays.fill(cost, Integer.MAX_VALUE);
        for (int[] node: road) {
            nodes[node[0]].add(new Node(node[1], node[2]));
            nodes[node[1]].add(new Node(node[0], node[2]));
        }

        cost[1] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        queue.add(new Node(1, 0));
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (now.cost > cost[now.destination]) {
                continue;
            }

            for (Node node : nodes[now.destination]) {
                if (cost[node.destination] > node.cost + now.cost) {
                    cost[node.destination] = node.cost + now.cost;
                    queue.add(new Node(node.destination, cost[node.destination]));
                }
            }
        }

        return (int) Arrays.stream(cost).filter(value -> value <= k).count();
    }
}
