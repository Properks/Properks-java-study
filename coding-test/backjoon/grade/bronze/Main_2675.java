import java.util.*;
import java.io.*;

public class Main_2675 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int caseSize = Integer.parseInt(br.readLine());
        int[] count = new int[caseSize];
        String[] str = new String[caseSize];
        for (int i = 0; i < caseSize; i++) {
            st = new StringTokenizer(br.readLine());
            count[i] = Integer.parseInt(st.nextToken());
            str[i] = st.nextToken();
        }

        for (int i = 0; i < caseSize; i++) {
            for (int j = 0; j < str[i].length(); j++) {
                for (int k = 0; k < count[i]; k++) {
                    System.out.print(str[i].charAt(j));
                }
            }
            System.out.println();
        }
    }
}
