import java.util.*;

// 저자 문제
// 정수형 배열 내림차순으로 정렬하고 중복 제거하기
public class Problem_2 {
    public static void main(String[] args) {
        int[] input1 = generateArrayWithDuplicates(100000);
        int[] input2 = generateArrayWithDuplicates(100000);

        List<Integer> result1 = new ArrayList<>(Arrays.stream(input1).boxed().toList());
        List<Integer> result2 = new ArrayList<>(Arrays.stream(input2).boxed().toList());


        long start = System.currentTimeMillis();
        Collections.sort(result1);
        Collections.sort(result2);

        result1 = solution(result1);
        result2 = solution(result2);

//        System.out.println(result1);
//        System.out.println(result2);
        long end = System.currentTimeMillis();
        System.out.println("First algorithm: " + ((end - start) / 1000d) + "초"); // 대략 0.3초


        // 풀이
        start = System.currentTimeMillis();
        List<Integer> result3 = new ArrayList(Arrays.stream(input1).boxed().distinct().toList());
        // boxed(): int -> Integer로 변환
        // distinct(): 중복값 삭제

        result3.sort(Collections.reverseOrder()); // reversedOrder(): 내림차순 정렬을 위한 Comparator
//        System.out.println(result3);

        List<Integer> result4 = new ArrayList(Arrays.stream(input2).boxed().distinct().toList());
        result4.sort(Collections.reverseOrder());
//        System.out.println(result4);
        end = System.currentTimeMillis();
        System.out.println("Second algorithm: " + ((end - start) / 1000d) + "초"); // 대략 0.1초

    }

    public static List<Integer> solution(List<Integer> list) {
        List<Integer> clone = new ArrayList<>(list);
        int i = 0;
        int n = list.size();
        while (i < n) {
            if (i != clone.size() - 1 && clone.get(i).equals(clone.get(i + 1))) {
                clone.remove(i + 1);
                n = clone.size();
                continue;
            }
            i++;
        }
        return clone;
    }

    // input 생성
    private static int[] generateArrayWithDuplicates(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(200001) - 100000; // -100,000부터 100,000 사이의 랜덤 값
        }
        return array;
    }
}
