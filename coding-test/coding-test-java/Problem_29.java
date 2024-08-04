import util.PrintUtil;

import java.util.*;

// 길 찾기 게임
public class Problem_29 {

    public static void main(String[] args) {
        int[][] nodeinfo = {{5,3}, {11,5}, {13,3}, {3,5}, {6,1}, {1,3}, {8,6}, {7,2}, {2,2}};

        int[][] result = solution(nodeinfo);

        Arrays.stream(result).forEach(PrintUtil::printIntegerArray);
    }

    // 내 풀이
    public static int[][] solution(int[][] nodeinfo) {
        List<List<Integer>> sortedInfo = Arrays.stream(nodeinfo)
                .map(node -> Arrays.stream(node).boxed().toList())
                .sorted((v1, v2) -> v2.get(1).compareTo(v1.get(1)) == 0 ? v1.getFirst().compareTo(v2.getFirst()) : v2.get(1).compareTo(v1.get(1)))
                .toList();

        List<Integer> valueList = Arrays.stream(nodeinfo)
                .map(node -> node[0]).toList();

        List<Integer> heightList = sortedInfo.stream()
                .map(node -> node.get(1)).distinct().sorted(Comparator.reverseOrder()).toList();

        int[] tree = makeTree(sortedInfo, valueList, heightList);

        List<Integer> pre = new ArrayList<>();
        preorder(pre, tree, 1);
        List<Integer> post = new ArrayList<>();
        postorder(post, tree, 1);

        int[][] answer = new int[2][nodeinfo.length];
        answer[0] = pre.stream().mapToInt(Integer::intValue).toArray();
        answer[1] = post.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }

    // 트리 생성
    // 로직 수정 필요
    public static int[] makeTree(List<List<Integer>> sortedInfo, List<Integer> valueList, List<Integer> heightList) {
        int[] tree = new int[(int) Math.pow(2, heightList.size() + 1)];
        Arrays.fill(tree, -1);
        for (List<Integer> node : sortedInfo) {
            int value = node.getFirst();
            int height = heightList.indexOf(node.get(1)) + 1;
            int index = (int)Math.pow(2, height - 1);
            if (index == 1) {
                tree[index] = valueList.indexOf(value) + 1;
                continue;
            }

            for (int i = 0; i < (int)Math.pow(2, height - 1); i++) {
                int parentIndex = (index + i) / 2;
                if (tree[index + i] == -1) {
                    if (index + i == parentIndex * 2 && tree[parentIndex] != -1 && valueList.indexOf(tree[parentIndex] - 1) > value) {
                        tree[index + i] = valueList.indexOf(value) + 1;
                        break;
                    }
                    else if (index + i == parentIndex * 2 + 1 && tree[parentIndex] != -1 && valueList.indexOf(tree[parentIndex] - 1) < value) {
                        tree[index + i] = valueList.indexOf(value) + 1;
                        break;
                    }
                }
            }

        }
        return tree;
    }

    public static void preorder(List<Integer> result, int[] tree, int index) {
        if (tree[index] != -1) {
            result.add(tree[index]);
            preorder(result, tree, index * 2);
            preorder(result, tree, index * 2 + 1);
        }
    }

    public static void postorder(List<Integer> result, int[] tree, int index) {
        if (tree[index] != -1) {
            postorder(result, tree, index * 2);
            postorder(result, tree, index * 2 + 1);
            result.add(tree[index]);
        }
    }
}
