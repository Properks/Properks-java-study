import java.util.*;

// 양과 늑대
// 양의 최대 개수를 찾는 고난이도 문제 (Tree 형태의 BFS 문제, BFS를 한 번 실행하는 것이 아닌 여러번 하여 최적의 해를 찾는 문제)
public class Problem_28 {
    public static void main(String[] args) {
        int[] info1 = {0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1};
        int[][] edges1 = {{0,1}, {1,2}, {1,4}, {0,8}, {8,7}, {9,10}, {9,11}, {4,3}, {6,5}, {4,6}, {8,9}};

        int[] info2 = {0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0};
        int[][] edges2 = {{0,1}, {0,2}, {1,3}, {1,4}, {2,5}, {2,6}, {3,7}, {4,8}, {6,9}, {9,10}};

        int result1 = solution(info1, edges1);
        int result2 = solution(info2, edges2);

        System.out.println(result1);
        System.out.println(result2);
    }

    public static int solution(int[] info, int[][] edges) {
        Map<Integer, List<Integer>> tree = new HashMap<>();
        for (int i = 0; i < info.length; i++) {
            tree.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
        }

        ArrayDeque<Info> queue = new ArrayDeque<>();
        queue.addLast(new Info(0, 1, 0, new HashSet<>()));
        Set<Integer> notVisited = new HashSet<>();

        int max = 0;
        while(!queue.isEmpty()) {
            Info current = queue.pollFirst();
            max = Math.max(max, current.sheep);

            current.visited.addAll(tree.get(current.node));

            for (int next : current.visited) {

                Set<Integer> newSet = new HashSet<>(current.visited);
                newSet.remove(next);

                if (info[next] == 0) {
                    queue.addLast(new Info(next, current.sheep + 1, current.wolf, newSet));
                    notVisited.remove(next);
                }
                else {
                    if (current.sheep != current.wolf + 1) {
                        queue.addLast(new Info(next, current.sheep, current.wolf + 1, newSet));
                        notVisited.remove(next);
                    }
                    else {
                        notVisited.add(next);
                    }
                }
            }

        }

        return max;
    }

    public static class Info {
        int node;
        int sheep;
        int wolf;
        // 각 노드별로 방문한 것을 저장해놓고 있지 않으면 모든 경우의 수를 확인할 수 없다.
        // BFS로 풀지만 한 번만 보는 것이 아닌 각 케이스별로 최대값을 구해야하므로 방문했다고 끝이 아니다.
        // 각각의 BFS로 탐색한 tree에서 인접한 노드만큼의 케이스가 추가되고 각 케이스 별로 최적의 해를 찾아야하기 때문에
        Set<Integer> visited;

        public Info(int node, int sheep, int wolf, Set<Integer> visited) {
            this.node = node;
            this.sheep = sheep;
            this.wolf = wolf;
            this.visited = visited;
        }
    }

}
