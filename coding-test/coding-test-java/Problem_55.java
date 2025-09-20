import java.lang.reflect.Array;
import java.util.*;

// 가장 큰 수
public class Problem_55 {

    public static void main(String[] args) {
        int[] input1 = {6, 10, 2};
        int[] input2 = {3, 30, 34, 5, 9};

        int result1 = solution(input1);
        int result2 = solution(input2);

        System.out.println(result1);
        System.out.println(result2);

    }

    public static int solution(int[] numbers) {
        return bookSolution(numbers);
    }

    public static int mySolution(int[] numbers) {

        List<Integer> clone = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            clone.add((numbers[i]));
        }

        clone.sort((x, y) -> {
            String stringOfX = String.valueOf(x);
            String stringOfY = String.valueOf(y);

            int i = 0;
            while (stringOfY.length() > i && stringOfX.length() > i) {
                if (stringOfY.charAt(i) != stringOfX.charAt(i)) {
                    return (int) (stringOfY.charAt(i) - stringOfX.charAt(i));
                }
                i++;
            }

            if (stringOfY.length() == i) {
                // ...
            }
            else if (stringOfX.length() == i) {
                // ...
            }

            return (int) y - (int) x;
        });


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < clone.size(); i++) {
            sb.append(String.valueOf(clone.get(i)));
        }

        return Integer.parseInt(sb.toString());
    }

    public static int bookSolution(int [] numbers) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            list.add(String.valueOf(numbers[i]));
        }

        list.sort((x, y) -> Integer.parseInt(y + x) - Integer.parseInt(x + y));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }

        return Integer.parseInt(sb.toString());
    }

}
