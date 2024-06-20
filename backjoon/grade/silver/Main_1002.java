import java.util.*;
import java.io.*;

public class Main_1002 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int caseSize = Integer.parseInt(br.readLine());

        int[][] input = new int[caseSize][6];
        for(int i = 0; i < caseSize; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0;  j < st.countTokens(); j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] result = new int[caseSize];
        for (int i = 0; i < caseSize; i++) {
        }
    }
}
