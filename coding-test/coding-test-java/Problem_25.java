import util.PrintUtil;

import java.util.*;

// 저자 문제
// preorder, inorder, postorder 구현
public class Problem_25 {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6, 7};

        String[] result = solution(input);

        PrintUtil.printStringArray(result);
    }

    // 내 풀이
    // heap 처럼 구현한 경우 index 0 은 비워두고 1부터 시작할 것
    public static String[] solution(int[] nodes) {
        int[] clone = new int[nodes.length + 1];
        for (int i = 1; i < clone.length; i++) {
            clone[i] = nodes[i - 1];
        }
        String[] answer = new String[3];

        List<Integer> result = new ArrayList<>();
        preorder(result, clone, 1);
        answer[0] = makeString(result);

        result = new ArrayList<>();
        inorder(result, clone, 1);
        answer[1] = makeString(result);

        result = new ArrayList<>();
        postorder(result, clone, 1);
        answer[2] = makeString(result);

        return answer;
    }

    public static void preorder(List<Integer> result, int[] nodes, int index) {
        if (index < nodes.length) {
            result.add(nodes[index]);
            preorder(result, nodes, 2 * index);
            preorder(result, nodes, 2 * index + 1);
            // 책에서의 방식
            // String을 return 하도록 하고 뒤에 .trim()을 붙여 공백 제거
//            return nodes[index] + preorder(nodes, 2 * index) + preorder(nodex, 2 * index + 1);
        }
    }

    public static void inorder(List<Integer> result, int[] nodes, int index) {
        if (index < nodes.length) {
            inorder(result, nodes, 2 * index);
            result.add(nodes[index]);
            inorder(result, nodes, 2 * index + 1);
        }
    }

    public static void postorder(List<Integer> result, int[] nodes, int index) {
        if (index < nodes.length) {
            postorder(result, nodes, 2 * index);
            postorder(result, nodes, 2 * index + 1);
            result.add(nodes[index]);
        }
    }

    public static String makeString(List<Integer> nodes) {
        return nodes.stream().map(String::valueOf).reduce((value1, value2) -> value1 + " " + value2).orElse(null);
    }
}
