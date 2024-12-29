import util.PrintUtil;

import java.util.*;

// 길 찾기 게임 (제출 완료)
// https://school.programmers.co.kr/learn/courses/30/lessons/42892
public class Problem_29 {

    public static void main(String[] args) {
        int[][] nodeinfo = {{5,3}, {11,5}, {13,3}, {3,5}, {6,1}, {1,3}, {8,6}, {7,2}, {2,2}};

        int[][] result1 = solution(nodeinfo);
        int[][] result2 = solution1(nodeinfo);

        Arrays.stream(result1).forEach(PrintUtil::printIntegerArray);
        Arrays.stream(result2).forEach(PrintUtil::printIntegerArray);
    }

    // 내 풀이
    public static int[][] solution(int[][] nodeinfo) {
        List<List<Integer>> sortedInfo = Arrays.stream(nodeinfo)
                .map(node -> Arrays.stream(node).boxed().toList())
                .sorted((v1, v2) -> v2.get(1).compareTo(v1.get(1)) == 0 ? v1.get(0).compareTo(v2.get(0)) : v2.get(1).compareTo(v1.get(1)))
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
            int value = node.get(0);
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

    // 책 풀이
    public static class Node {
        int x;
        int y;
        int index;
        Node left;
        Node right;

        public Node(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
            this.left = null;
            this.right = null;
        }
    }

    public static int[][] solution1(int[][] nodeinfo) {
        Node root = makeTree1(nodeinfo);

        int[][] answer = new int[2][nodeinfo.length];

        List<Integer> preorder = new ArrayList<>();
        preorder1(preorder, root);
        answer[0] = preorder.stream().mapToInt(Integer::intValue).toArray();

        List<Integer> postorder = new ArrayList<>();
        postorder1(postorder, root);
        answer[1] = postorder.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }

    public static Node makeTree1(int[][] nodeInfo) {
        Node[] tree = new Node[nodeInfo.length];
        for (int i = 0; i < nodeInfo.length; i++) {
            tree[i] = new Node(nodeInfo[i][0], nodeInfo[i][1], i + 1);
        }
        Arrays.sort(tree, (node1, node2) -> {
            if (node1.y == node2.y) {
                return Integer.compare(node1.x, node2.x);
            }
            return Integer.compare(node2.y, node1.y);
        });

        for (int i = 1; i < tree.length; i++) {
            Node parent = tree[0];
            Node node = tree[i];
            while (true) {
                if (node.x < parent.x) {
                    if (parent.left == null) {
                        parent.left = node;
                        break;
                    }
                    else {
                        parent = parent.left;
                    }
                }
                else {
                    if (parent.right == null) {
                        parent.right = node;
                        break;
                    }
                    else {
                        parent = parent.right;
                    }
                }
            }
        }
        return tree[0];
    }

    public static void preorder1(List<Integer> result, Node node) {
        if (node != null) {
            result.add(node.index);
            preorder1(result, node.left);
            preorder1(result, node.right);
        }
    }

    public static void postorder1(List<Integer> result, Node node) {
        if (node != null) {
            postorder1(result, node.left);
            postorder1(result, node.right);
            result.add(node.index);
        }
    }

    // 재풀이 (재풀이 성공)
    // int[][] 를 index로 채워야하는데 해당 부분 오류
    // node 변경 및 로직 변경
    class Solution {
        public int[][] solution(int[][] nodeinfo) {

            Node[] nodes = new Node[nodeinfo.length];
            for (int i = 0; i < nodeinfo.length; i++) {
                nodes[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i+1);
            }

            Node[] sorted = Arrays.stream(nodes).sorted((n1, n2) -> Integer.compare(n1.x, n2.x)).sorted((n1, n2) -> Integer.compare(n2.y, n1.y)).toArray(Node[]::new);

            Node root = makeNode(sorted);
            List<Integer> preorder = new ArrayList<>();
            List<Integer> postorder = new ArrayList<>();

            preorder(preorder, root);
            postorder(postorder, root);

            int[][] answer = {preorder.stream().mapToInt(Integer::intValue).toArray(),
                    postorder.stream().mapToInt(Integer::intValue).toArray()};
            return answer;
        }

        public Node makeNode(Node[] sorted) {
            Node root = sorted[0];
            for (int i = 1; i < sorted.length; i++) {
                Node parent = root;
                Node node = sorted[i];
                while (true) {
                    if (parent.x > node.x) {
                        if (parent.left == null) {
                            parent.left = node;
                            break;
                        }
                        else {
                            parent = parent.left;
                        }
                    }
                    else {
                        if (parent.right == null) {
                            parent.right = node;
                            break;
                        }
                        else {
                            parent = parent.right;
                        }
                    }
                }
            }
            return root;
        }

        public void preorder(List<Integer> result, Node root) {
            if (root != null) {
                result.add(root.index);
                preorder(result, root.left);
                preorder(result, root.right);
            }
        }

        public void postorder(List<Integer> result, Node root) {
            if (root != null) {
                postorder(result, root.left);
                postorder(result, root.right);
                result.add(root.index);
            }
        }

        class Node {
            Node left;
            Node right;
            int x;
            int y;
            int index;

            public Node(int x, int y, int index) {
                this.x = x;
                this.y = y;
                this.index = index;
            }
        }
    }
}
