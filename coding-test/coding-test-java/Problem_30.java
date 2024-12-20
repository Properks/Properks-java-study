import java.util.*;

public class Problem_30 {

    public static void main(String[] args) {
        int k1 = 3;
        int[][] operations1 = {{0,0,1}, {0,1,2}, {1,1,2}};

        int k2 = 4;
        int[][] operations2 = {{0,0,1}, {1,1,2}, {0,1,2}, {1,0,2}};

        Boolean[] result1 =  solution(k1, operations1);
        Boolean[] result2 =  solution(k2, operations2);

        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));
    }

    public static Boolean[] solution(int k, int[][] operations) {
        int[] parent = new int[k];

        for (int i = 0; i < k; i++) {
            parent[i] = i;
        }

        List<Boolean> answer = new ArrayList<>();
        for (int[] operation : operations) {
            if (operation[0] == 0) {
                union(parent, operation[1], operation[2]);
            }
            else {
                answer.add(isSameParent(parent, operation[1], operation[2]));
            }
        }

        return answer.toArray(new Boolean[0]);
    }

    public static void union(int[] parent, int node1, int node2) {
        int node1Parent = find1(parent, node1);
        int node2Parent = find1(parent, node2);
        parent[node2] = node1;
    }

    public static int find(int[] parent, int node) {
        int parentNode = node;
        while (parentNode != parent[parentNode]) {
            parentNode = parent[parentNode];
        }
        return parentNode;
    }

    public static int find1(int[] parent, int node) {
        int parentNode = node;
        while (parentNode != parent[parentNode]) {
            parentNode = parent[parentNode];
        }
        parent[node] = parentNode;
        return parentNode;
    }

    public static boolean isSameParent(int[] parent, int node1, int node2) {
        return find1(parent, node1) == find1(parent, node2);
    }

}
