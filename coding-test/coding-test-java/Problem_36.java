import java.util.*;

// 저자 문제
// 간단한 다익스트라 구현
public class Problem_36 {

    public static void main(String[] args) {
        int[][] graph1 = {{0,1,9}, {0,2,3},{1,0,5},{2,1,1}};
        int start1 = 0;
        int n1 = 3;

        int[][] graph2 = {{0,1,1}, {1,2,5}, {2,3,1}};
        int start2 = 0;
        int n2 = 4;

        int[] result1 = solution(graph1, start1, n1);
        int[] result2 = solution(graph2, start2, n2);

        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));
    }

    // 오답
    // 반례: start가 0이면 내부의 for문이 작동하지 않을 확률이 있다.
    public static int[] solution(int[][] graph, int start, int n) {
        int[] answer = new int[n];
        Arrays.fill(answer, Integer.MAX_VALUE);
        answer[start] = 0;

        List<Integer>[] nodes = new ArrayList[n];
        int[][] cost = new int[n][n];

        for (int[] info : graph) {
            if (nodes[info[0]] == null) {
                nodes[info[0]] = new ArrayList<>();
            }
            nodes[info[0]].add(info[1]);
            cost[info[0]][info[1]] = info[2];
        }

        for (int i = 0; i < n; i++) {
            if (nodes[i] != null) {
                for (int adj : nodes[i]) {
                    if (answer[adj] > answer[i] + cost[i][adj]) {
                        answer[adj] = answer[i] + cost[i][adj];
                    }
                }
            }
        }

        return answer;
    }

    // 책 풍리
    public static class Node {
        // 도착 node
        int destination;

        // 도착 노드까지의 최소 비용
        int cost;
        public Node(int destination, int cost) {
            this.destination = destination;
            this.cost = cost;
        }
    }

    public static int[] solution1(int[][] graph, int start, int n) {
        List<Node>[] nodes = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int[] info : graph) {
            nodes[info[0]].add(new Node(info[1], info[2]));
        }

        int[] answer = new int[n];
        Arrays.fill(answer, Integer.MAX_VALUE);
        answer[start] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        queue.add(new Node(start, 0));
        while (!queue.isEmpty()) {
            Node now = queue.poll();

            // 도찾지점의 cost가 더 낮은 경우
            if (now.cost > answer[now.destination]) {
                continue;
            }

            for (Node adj : nodes[now.destination]) {
                // 최소 비용 업데이트
                if (answer[adj.destination] > adj.cost + now.cost) {
                    answer[adj.destination] = adj.cost + now.cost;

                    // 업데이트 후 주변 노드에 대한 cost 업데이트를 위해 추가
                    // nodes 내의 Node가 아닌 새로 업데이트된 cost를 가진 Node로 추가
                    queue.add(new Node(adj.destination, answer[adj.destination]));
                }

            }
        }
        return answer;
    }
}
