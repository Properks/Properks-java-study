import util.PrintUtil;

import java.util.*;

// 기능 개발 순서에 맞게 배포하기
public class Problem_16 {
    public static void main(String[] args) {
        int[] input1 = {93, 30, 50};
        int[] input2 = {95, 90, 99, 99, 80, 99};

        int[] speed1 = {1, 30, 5};
        int[] speed2 = {1, 1, 1, 1, 1, 1};

        int[] result1 = solution(input1, speed1);
        int[] result2 = solution(input2, speed2);

        PrintUtil.printArray(result1);
        PrintUtil.printArray(result2);

    }

    // 어떤 것을 큐의 값으로 설정할지가 중요. 여기서는 큐를 대기열로 사용
    // 1. 필요한 시간의 값들을 queue에 저장하기
    // 2. 필요한 시간이 앞의 작업이 높으면 count만 추가하고 아니라면 count를 list에 넣고 count 값을 초기화
    public static int[] solution(int[] inputs, int[] speeds) {
        int n = inputs.length;
        ArrayDeque<Integer> queue = new ArrayDeque();
        for (int i = 0; i < n; i++) {
            int value = (100 - inputs[i]) / speeds[i];
            if (((100 - inputs[i]) % speeds[i]) == 0) {
                value++;
            }
//            int value1 = (int) Math.ceil((100.0 - inputs[i]) / speeds[i]);
            queue.addLast(value);
        }

        List<Integer> result = new ArrayList<>();
        int currentValue = queue.pollFirst();
        int count = 1;
        while (!queue.isEmpty()) {
            int value = queue.pollFirst();
            if (currentValue >= value) {
                count++;
            }
            else {
                result.add(count);
                count = 1;
            }
        }
        result.add(count);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
