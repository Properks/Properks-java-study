package util;

import java.lang.reflect.Type;

public class PrintUtil {

    public static void printArray(int[] array) {
        int length = array.length;
        StringBuilder builder = new StringBuilder();
        builder.append("{");

        for (int i = 0; i < length; i++) {
            builder.append(array[i] + (i == length - 1 ? "}" : ","));
        }

        System.out.println(builder);
    }

    public static void printIntegerTwoDimensionalArray(int[][] array) {
        int row = array.length;
        int column = array[0].length;
        StringBuilder builder = new StringBuilder();
        builder.append("[\n");

        for (int i = 0; i < row; i++) {
            builder.append("{");
            for (int j = 0; j < column; j++) {
                builder.append(array[i][j] + (j == column - 1 ? "}\n" : ","));
            }
        }
        builder.append("]");

        System.out.println(builder);
    }
}
