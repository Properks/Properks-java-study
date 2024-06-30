import java.io.*;
import java.util.*;

/// Solved
public class Main_1003 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        int[] input = new int[size];
        for (int i = 0; i < size; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < size; i++) {
            int resultSize = input[i] + 1;
            int[][] result = new int[2][resultSize];
            // 0
            result[0][0] = 1;
            result[1][0] = 0;

            if (resultSize > 1) {
                //1
                result[0][1] = 0;
                result[1][1] = 1;

                for (int j = 2; j < resultSize; j++) {
                    result[0][j] = result[0][j - 1] + result[0][j - 2];
                    result[1][j] = result[1][j - 1] + result[1][j - 2];
                }

            }
            System.out.println(result[0][input[i]]+ " " + result[1][input[i]]);
        }
    }
}
