import java.io.*;
import java.util.*;

// 풍선 터트리기 (성공)
// Deque 문제
public class Main_2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] inputs = new int[n];
        for (int i = 0; i < n; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }
        String a;

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            deque.addLast(i + 1);
        }
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            if (!deque.isEmpty()) {
                int value = deque.pollFirst();
                answer[i] = value;
                int input = inputs[value - 1];
                if (input < 0) {
                    input = -1 * input;
                    for (int j = 0; j < input; j++) {
                        if (!deque.isEmpty()) {
                            deque.addFirst(deque.pollLast());
                        }
                    }
                }
                else if (input >= 0) {
                    for (int j = 0; j < input - 1; j++) {
                        if (!deque.isEmpty()) {
                            deque.addLast(deque.pollFirst());
                        }
                    }
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append(answer[i]);
            if (i < n - 1) {
                stringBuilder.append(" ");
            }
        }
        System.out.println(stringBuilder);
    }
}
