package Chapter_13.Stream;

import java.util.Arrays;

/**
 * Run
 */
public class Run {

    public static void main(String[] args) {
        
        int[] arr = new int[10];

        for (int i = 0; i < 10; i++) {
            arr[i] = i + 1;
        }

        int Addition = Arrays.stream(arr).sum();
        Arrays.stream(arr).forEach(i -> System.out.print(i + ((i == 10) ? " = " : " + ")));
        System.out.println();
        System.out.println(Addition);
    }
}