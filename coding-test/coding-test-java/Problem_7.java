import java.util.*;

// 방문 길이 (제출 완료)
// https://school.programmers.co.kr/learn/courses/30/lessons/49994
// 좌표평면에서 사용자가 처음 걸은 거리
public class Problem_7 {
    public static void main(String[] args) {
        String input1 = "ULURRDLLU";
        String input2 = "LULLLLLLU";
        String input3 = "UDURRDLLU"; // 반례: solution은 반대 방향도 센다.

        int result1 = solution(input1);
        int result2 = solution(input2);
        int result3 = solution(input3);

        int result4 = solution1(input1);
        int result5 = solution1(input2);
        int result6 = solution1(input3);

        System.out.println("내 풀이");
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println("책 풀이");
        System.out.println(result4);
        System.out.println(result5);
        System.out.println(result6);
    }

    // 내 풀이
    // 오답 방문 했던 길이 제외하지 않음
    public static int solution(String input) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int[] xy = new int[2];
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            int direction = 0;
            List<Integer> integers = new ArrayList<>(List.of(xy[0], xy[1]));
            if (input.charAt(i) == 'R') {
                direction = 1;
            }
            else if (input.charAt(i) == 'D') {
                direction = 2;
            }
            else if (input.charAt(i) == 'L'){
                direction = 3;
            }
            int newX = xy[0] + dx[direction];
            int newY = xy[1] + dy[direction];

            if (Math.abs(newX) > 5 || Math.abs(newY) > 5) {
                 continue;
            }

            xy[0] = newX;
            xy[1] = newY;

            integers.add(xy[0]);
            integers.add(xy[1]);

            set.add(integers);
        }

        return set.size();
    }

    // 책 풀이
    public static int solution1(String input) {

        Map<Character, int[]> vectors = new HashMap<>(
                Map.of(
                        'U', new int[]{0, 1},
                        'R', new int[]{1, 0},
                        'D', new int[]{0, -1},
                        'L', new int[]{-1, 0}
                )
        );
        // 응용
        List<int[]> vectors_1 = new ArrayList<>(
                List.of(
                        new int[]{0,1},
                        new int[]{1,0},
                        new int[]{0,-1},
                        new int[]{-1,0}
                )
        );
        int[][] vectors_2 = {
                {0,1},
                {1,0},
                {0,-1},
                {-1,0}
        };

        int[] xy = new int[2];

        //책에서의 선언
        Set<String> set = new HashSet<>();
//        Set<int[]> set = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            int[] vector = vectors.get(input.charAt(i));
            int newX = xy[0] + vector[0];
            int newY = xy[1] + vector[1];
            if (Math.abs(newX) > 5 || Math.abs(newY) > 5) {
                continue;
            }

            //책에서의 추가
            set.add(xy[0] + " " + newX + " " + xy[1] + " " + newY);
            set.add(xy[1] + " " + newY + " " + xy[0] + " " + newX); // 방향성이 없어 반대로 움직인 것도 같은 것으로 봄
            // 밑의 방식은 값이 같아도 해쉬값이 달라 다른 객체로 인식하여 중복된다.
//            set.add(new int[]{xy[0], xy[1], newX, newY});

            xy[0] = newX;
            xy[1] = newY;
        }

        return set.size() / 2;
    }
}
