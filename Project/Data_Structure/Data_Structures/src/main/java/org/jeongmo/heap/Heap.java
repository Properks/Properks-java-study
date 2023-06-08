package org.jeongmo.heap;

import org.jeongmo.sorting.UtilForSort;

public class Heap {

    Integer[] data;
    int count;

    public Heap(int size) {
        data = new Integer[size + 1];
        count = 1;
    }

    private void bottomUp(int index) {
        if (index == 1) {
            return;
        }

        if (data[index] > data[index / 2] ) {
            UtilForSort.swap(data, index, index / 2);
            bottomUp(index / 2);
        }
    }

    private void topDown(int index) {
        if (2 * index > count) {
            return;
        }
        else if (2 * index == count && data[index] < data[2 * index]) {
            UtilForSort.swap(data, index, 2 * index);
            return;
        }

        if (data[2 * index] > data[2 * index + 1] && data[2 * index] > data[index]) {
            UtilForSort.swap(data, index, 2 * index);
            topDown(2 * index);
        }
        else if (data[2 * index] < data[2 * index + 1] && data[2 * index + 1] > data[index]) {
            UtilForSort.swap(data, index, 2 * index + 1);
            topDown(2 * index + 1);
        }
    }
}
