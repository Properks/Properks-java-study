import java.util.*;

// 표 편집 (컴파일 에러)
// 데이터 행을 이동 삭제 복구 작업
public class Problem_14 {

    public static void main(String[] args) {
        int row1 = 8;
        int index1 = 2;
        String[] board = {
                "무지",
                "콘",
                "어피치",
                "제이지",
                "프로도",
                "네오",
                "튜브",
                "라이언"
        };
        String[] input1 = {
                "D 2",
                "C",
                "U 3",
                "C",
                "D 4",
                "C",
                "U 2",
                "Z",
                "Z"
        };
        String[] input2 = {
                "D 2",
                "C",
                "U 3",
                "C",
                "D 4",
                "C",
                "U 2",
                "Z",
                "Z",
                "U 1",
                "C"
        };

        String result1 = solution(board, row1, index1, input1);
        String result2 = solution(board, row1, index1, input2);

        System.out.println(result1);
        System.out.println(result2);

    }

    // 구현 순서 분석 (실패, 문제 이해를 잘못함)
    // 1. input을 보고 명령어 대로 clone 배열과 removed 스택에 처리하기
    // 1-1. 삭제, 되돌리기, 이동
    // 2. 원래 배열인 String[] 과 List<String>을 인덱스를 사용하여 비교
    public static String solution(String[] board, int n, int k, String[] cmd) {
        List<String> clone = new ArrayList<>(Arrays.stream(board).toList());
        Stack<List<Object>> removed = new Stack<>();
        for (String input: cmd) {
            if (input.startsWith("D")) {
                int value = Integer.parseInt(input.substring(2));
                if (k + value < n - 1) {
                    k += value;
                }
            }
            else if (input.startsWith("U")) {
                int value = Integer.parseInt(input.substring(2));
                if (k - value >= 0) {
                    k -= value;
                }
            }
            else if (input.equals("C")) {
                removed.push(List.of(k, clone.remove(k)));
            }
            else if (input.equals("Z") && !removed.isEmpty()) {
                List<Object> value = removed.pop();
                clone.add((int) value.get(0), String.valueOf(value.get(1)));
            }
        }

        int cloneIndex = 0;
        StringBuilder sb = new StringBuilder();
        for (String value : board) {
            if (clone.get(cloneIndex).equals(value)) {
                sb.append("O");
                cloneIndex++;
            }
            else {
                sb.append("X");
            }
        }
        return sb.toString();
    }

    // 제출해본 다른 풀이
    // true, false로 놓고 비교하는 방식, while문으로 다음 커서를 찾을 때 한번 순회하는 부분에서 시간초과가 발생
    public String solution1(int n, int k, String[] cmd) {
        boolean[] isUnRemoved = new boolean[n];
        Stack<Integer> removed = new Stack<>();

        for (int i = 0; i < n; i++) {
            isUnRemoved[i] = true;
        }

        for (String input : cmd) {
            if (input.startsWith("D")) {
                int value = Integer.parseInt(input.split(" ")[1]);

                int index = k;
                while (value > 0) {
                    if (isUnRemoved[index + 1]) {
                        value--;
                    }
                    index++;
                }
                k = index;
            }
            else if (input.startsWith("U")) {
                int value = Integer.parseInt(input.split(" ")[1]);

                int index = k;
                while (value > 0) {
                    if (isUnRemoved[index - 1]) {
                        value--;
                    }
                    index--;
                }
                k = index;
            }
            else if (input.startsWith("C")) {
                removed.push(k);
                isUnRemoved[k] = false;
                int prevK = k;
                while ((k <= n - 1) && !isUnRemoved[k]) {
                    k++;
                }
                if (k == n) {
                    k = prevK - 1;
                }
            }
            else if (input.startsWith("Z") && !removed.isEmpty()) {
                isUnRemoved[removed.pop()] = true;
            }
        }

        String answer = "";
        StringBuilder sb = new StringBuilder();
        for (boolean value : isUnRemoved) {
            if (value) {
                sb.append("O");
            }
            else {
                sb.append("X");
            }
        }
        answer = sb.toString();

        return answer;
    }

    // up, down 집합 사용 풀이 (실패)
    // if 문 때문인지 시간 복잡도에서 실패
    public String solution2(int n, int k, String[] cmd) {
        int[] up = new int[n];
        int[] down = new int[n];
        Stack<Integer> removed = new Stack<>();

        for (int i = 0; i < n; i++) {
            up[i] = i - 1;
            down[i] = i + 1;
        }

        for (String input : cmd) {
            if (input.startsWith("D")) {
                int value = Integer.parseInt(input.split(" ")[1]);
                for (int i = 0; i < value; i++) {
                    k = down[k];
                }
            }
            else if (input.startsWith("U")) {
                int value = Integer.parseInt(input.split(" ")[1]);
                for (int i = 0; i < value; i++) {
                    k = up[k];
                }
            }
            else if (input.startsWith("C")) {
                removed.push(k);
                if (up[k] == -1) {
                    up[down[k]] = up[k];
                    k = down[k];
                }
                else if (down[k] == n) {
                    down[up[k]] = down[k];
                    k = up[k];
                }
                else {
                    up[down[k]] = up[k];
                    down[up[k]] = down[k];
                    k = down[k];
                }
            }
            else if (input.startsWith("Z") && !removed.isEmpty()) {
                int value = removed.pop();
                if (up[value] == -1) {
                    up[down[value]] = value;
                }
                else if (down[value] == n) {
                    down[up[value]] = value;
                }
                else {
                    down[up[value]] = value;
                    up[down[value]] = value;
                }
            }
        }

        String answer = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (removed.contains(i)) {
                sb.append("X");
            }
            else {
                sb.append("O");
            }
        }
        answer = sb.toString();

        return answer;
    }
}
