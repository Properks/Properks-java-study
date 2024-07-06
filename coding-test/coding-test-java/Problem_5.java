import util.PrintUtil;

import java.util.*;

// 두 행렬의 곱셈
public class Problem_5 {
    public static void main(String[] args) {
        int[][] arr1 = {
                {1, 4},
                {3, 2},
                {4, 1}
        };

        int[][] arr2 = {
                {3, 3},
                {3, 3}
        };

        int[][] arr3 = {
                {2, 3, 2},
                {4, 2, 4},
                {3, 1, 4}
        };

        int[][] arr4 = {
                {5, 4, 3},
                {2, 4, 1},
                {3, 1, 1}
        };

        int[][] result1 = solution(arr1, arr2);
        int[][] result2 = solution(arr3, arr4);

        PrintUtil.printIntegerTwoDimensionalArray(result1);
        PrintUtil.printIntegerTwoDimensionalArray(result2);
    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int row1 = arr1.length;
        int column1 = arr1[0].length;

        int column2 = arr2.length;

        int[][] result = new int[row1][column2];

        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < column1; j++) {
                for ( int k = 0; k < column2; k++) {
                    result[i][k] += arr1[i][j] * arr2[j][k];
                    // [m1 X n1] X [m2 x n2] = [m1 x n2] 인데 인덱스로 생각해도 동일하다.
                }
            }

        }

        return result;
    }

    public static void printMatrix(int[][] arr) {
        int row = arr.length;
        int column = arr[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(arr[i][j] + (j == column - 1 ? "\n" : ","));
            }
        }
    }
}
