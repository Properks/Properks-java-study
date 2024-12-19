import java.util.*;

// 예상 토너먼트 (제출 완료)
// https://school.programmers.co.kr/learn/courses/30/lessons/12985
// 토너먼트에서 a번 참가자 A와 b번 참가자 B가 만날 라운드 구하기
public class Problem_26 {
    public static void main(String[] args) {
        int n = 8;
        int a = 4;
        int b = 7;

        int result1 = solution(n, a, b);
        int result2 = solution1(n, a, b);

        System.out.println(result1);
        System.out.println(result2);
    }

    // 내 풀이
    // 실제 인덱스를 구한 이후 해당 인덱스의 부모가 같을 때까지 감소하도록
    public static int solution(int n, int a, int b) {
        int h = (int) (Math.log(n) / Math.log(2));
        int indexA = (int) Math.pow(2, h) + a - 1;
        int indexB = (int) Math.pow(2, h) + b - 1;

        int stage = 1;
        while (stage <= h) {
            if (indexA / 2 == indexB / 2) {
                break;
            }
            indexA /= 2;
            indexB /= 2;
            stage++;
        }
        return stage;
    }

    // 책 풀이
    // a와 b의 번호를 leafnode의 번호로 생각하고 이긴 경우 올라간 다음 라운드에서의 index만 구함
    // 내 풀이와의 차이: 나는 트리 전체를 생각하고 index를 구했고 책 풀이는 각 스테이지에서의 인덱스 변화만을 생각
    public static int solution1(int n, int a, int b) {
        int answer;
        for (answer = 0; a != b; answer++) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
        }
        return answer;
    }

    // 재풀이
    // b보다 a가 큰 경우를 방지하고 tree 의 height으로만 계산
    public int solution2(int n, int a, int b) {
        int low; // b보다 a가 큰 경우 제외
        int high;
        int answer = 1;
        if (a <= b) {
            low = a;
            high = b;
        }
        else {
            low = b;
            high = a;
        }

        while (n / 2 != 0) {
            if ((low + 1 == high) && (high % 2 == 0)) {
                break;
            }
            low = (low + 1) / 2;
            high = (high + 1) / 2;
            answer++;
            n /= 2;
        }

        return answer;
    }
}
