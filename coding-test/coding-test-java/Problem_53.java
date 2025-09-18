import java.util.*;

// 정수 내림차순으로 배치하기
public class Problem_53 {

    public static void main(String[] args) {

        int n1 = 118372;
        int result1 = solution(n1);
        System.out.println(result1);
    }

    public static int solution(int n) {
        return bookSolution(n);
    }

    public static int mySolution(int n) {
        List<Integer> digits = new ArrayList<>();

        while (n > 0) {
            digits.add(n % 10);
            n /= 10;
        }

        digits.sort((x, y) -> Integer.compare(y, x));

        int answer = 0;
        while (!digits.isEmpty()) {
            answer *= 10;
            answer += digits.get(0);
            digits.remove(0);
        }
        return answer;
    }

    public static int bookSolution(int n) {
        String[] digits = String.valueOf(n).split("");

        String[] sorted = Arrays.stream(digits).sorted(Comparator.reverseOrder()).toArray(String[]::new);

        StringBuilder sb = new StringBuilder();
        for (String digit: sorted) {
            sb.append(digit);
        }
        return Integer.parseInt(sb.toString());
    }
}
