import java.util.*;

public class Problem_42 {
    public static void main(String[] args) {
        int n1 = 9;
        int[][] wires1 = {{1,3}, {2,3}, {3,4}, {4,5}, {4,6}, {4,7}, {7,8}, {7,9}};
        int n2 = 4;
        int[][] wires2 = {{1,2}, {2,3}, {3,4}};
        int n3 = 7;
        int[][] wires3 = {{1,2}, {2,7}, {3,7}, {3,4}, {4,5}, {6,7}};

        int result1 = solution(n1, wires1);
        int result2 = solution(n2, wires2);
        int result3 = solution(n3, wires3);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }

    public static int solution(int n, int[][] wires) {
        int min = Integer.MAX_VALUE;
        Set<Integer> set1;
        Set<Integer> set2;

        for (int i = 0; i < wires.length; i++) {
            set1 = new HashSet<>();
            set2 = new HashSet<>();
            for (int j = 0; j < wires.length; j++) {
                if (i == j) {
                    continue;
                }
                if (set1.contains(wires[j][0]) || set1.contains(wires[j][1]) || set1.isEmpty()) {
                    set1.add(wires[j][0]);
                    set1.add(wires[j][1]);
                }
                else if (set2.contains(wires[j][0]) || set2.contains(wires[j][1]) || set2.isEmpty()) {
                    set2.add(wires[j][0]);
                    set2.add(wires[j][1]);
                }
            }
            min = Math.min(min, Math.abs(set1.size() - set2.size()));
        }
        return min;
    }
}
