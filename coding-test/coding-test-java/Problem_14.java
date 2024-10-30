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

    // 구현 순서 분석
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
}
