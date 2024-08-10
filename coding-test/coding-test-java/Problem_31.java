import java.util.*;

// 폰켓몬
// n/2 중 가장 많은 폰켓몬 고르기
public class Problem_31 {

    public static void main(String[] args) {
        int[] input1 = {3,1,2,3};
        int[] input2 = {3,3,3,2,2,4};
        int[] input3 = {3,3,3,2,2,2};

        int result1 = solution(input1);
        int result2 = solution(input2);
        int result3 = solution(input3);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }

    public static int solution(int[] nums) {
        Set<Integer> set = new HashSet(Arrays.stream(nums).boxed().toList());

        // 책에서의 Set 크기 구하기
        // Arrays.stream(nums).distinct().count()
        return Math.min(set.size(), nums.length / 2);
    }
}
