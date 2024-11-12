import java.util.*;

// 저자 문제
// 배열 내의 두 수를 더한 값이 target이 되는지 확인하기
public class Problem_18 {

    public static void main(String[] args) {
        int[] input1 = {1, 2, 3, 4, 8};
        int[] input2 = {2, 3, 5, 9};

        int target1 = 6;
        int target2 = 10;

        boolean result1 = solution(input1, target1);
        boolean result2 = solution(input2, target2);

        System.out.println(result1);
        System.out.println(result2);
    }

    // 해쉬로 접근하는 방식: 값을 다 넣은 상태에서 해당 값이 있는지만을 찾을 때
    public static boolean solution(int[] input, int target) {
        // O(n^2)
        // n + k = target을 찾는 방식
//        for (int i = 0; i < input.length - 1; i++) {
//            for (int j = i + 1; j < input.length; j++) {
//                if (input[i] + input[j] == target) {
//                    return true;
//                }
//            }
//        }
//        return false;
        // O(n + k)

        // target - n = k를 찾는 방식
        Set<Integer> hash = new HashSet<>();
        for (int i = 0; i < input.length; i++) {
            hash.add(input[i]);
        }

        for (int value : input) {
            if (hash.contains(target - value) && target - value != value) {
                return true;
            }
        }

        return false;
    }
}
