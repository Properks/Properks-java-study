import java.util.*;

// 저자 문제
// 반복적으로 k번째의 사람을 제외하면서 마지막에 남는 사람의 번호를 출력하는 문제
public class Problem_15 {
    public static void main(String[] args) {
        int n1 = 5;
        int k1 = 2;

        int result1 = solution(n1, k1);
        int result2 = solution1(n1, k1);

        System.out.println(result1);
        System.out.println(result2);
    }

    // 내 풀이
    // queue 방식이 생각나지 않아 리스트로 푼 것
    public static int solution(int n, int k) {
        List<Integer> list = new ArrayList();
        for (int i = 0; i < n; i++) {
            list.add(i+1);
        }

        int index = 0;
        while (!list.get(index).equals(list.get((index + k - 1) % list.size()))) {
            index = (index + k - 1) % list.size();
            list.remove(index);
            if (index == list.size()) {
                 index = 0;
            }
        }
        return list.get(0);
    }

    // 책 풀이
    // 배열을 고정시키고 인덱스를 이동시키는 것이 아닌 현재 선택중인 인덱스를 원형 큐처럼 이동한다고 생각할 것
    // 줄을 세워놓고 해당하지 않는 사람은 뒤로 이동시키는 방식과 비슷
    public static int solution1(int n, int k) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            queue.addLast(i + 1);
        }

        int value = 0;
        while (!queue.isEmpty()) {
            for (int j = 0; j < k - 1; j++) {
                queue.addLast(queue.pollFirst());
            }
            value = queue.pollFirst();
        }
        return value;
    }
}
