import java.util.*;

// 저자 문제
public class Problem_51 {
    public static void main(String[] args) {

        int[] arr1 = {1,3,5};
        int[] arr2 = {2,4,6};

        int[] arr3 = {1,2,3};
        int[] arr4 = {4,5,6};

        int[] result1 = solution(arr1, arr2);
        int[] result2 = solution(arr3, arr4);

        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));
    }

    public static int[] solution(int[]arr1, int[] arr2) {
        return mySolution(arr1, arr2);
    }

    public static int[] mySolution(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;

        int i = 0;
        int j = 0;

        int[] newArray = new int[n + m];
        int newArrayIndex = 0;
        while (i < n || j < m) {
            int left = Integer.MAX_VALUE;
            int right = Integer.MAX_VALUE;

            if (i < n) {
                left = arr1[i];
            }
            if (j < m) {
                right = arr2[j];
            }

            if (left > right) {
                newArray[newArrayIndex++] = right;
                j++;
            }
            else {
                newArray[newArrayIndex++] = left;
                i++;
            }
        }
        return newArray;
    }
}

