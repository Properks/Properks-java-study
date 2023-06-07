package org.jeongmo;

import org.jeongmo.sorting.BubbleSort;
import org.jeongmo.sorting.MergeSort;
import org.jeongmo.sorting.QuickSort;
import org.jeongmo.sorting.SelectionSort;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.logging.Logger;

public class Main {

    private static final int MAX_SIZE = 20;
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    private static SecureRandom rand;
    static {
        try {
            rand = SecureRandom.getInstanceStrong();
        }
        catch (NoSuchAlgorithmException e ){
            logger.warning(e::toString);
        }
    }
    public static void main(String[] args) {

        SelectionSort sortAlgorithm = new SelectionSort();
        final Integer[] list = new Integer[MAX_SIZE];
        setArray(list);

        logger.info(() -> "Array : " + Arrays.toString(list));
        sortAlgorithm.sort(list);
        logger.info(() -> "Array : " + Arrays.toString(list));
    }

    private static void setArray(Integer[] list) {
        Integer temp;
        int i = 0;
        while (i < MAX_SIZE) {
            temp = rand.nextInt(100);
           boolean isIn = false;
            for (Integer element : list) {
                if (temp.equals(element)) {
                    isIn = true;
                    break;
                }
            }
            if (!isIn) {
                list[i++] = temp;
            }
        }
    }
}