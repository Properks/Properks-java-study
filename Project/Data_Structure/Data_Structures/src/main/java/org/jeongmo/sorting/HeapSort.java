package org.jeongmo.sorting;

import org.jeongmo.heap.Heap;

import java.util.Arrays;

public class HeapSort extends Sort{

    private Heap heap;

    @Override
    <T extends Comparable<T>> T[] sort(T[] list) {
        long startedTime = System.nanoTime();
        T[] sortedList = Arrays.copyOfRange(heapSort(heap.buildHeap(list)), 1, list.length + 1);
        this.time = System.nanoTime() - startedTime;
        return sortedList;
    }

    private <T extends Comparable<T>> T[] heapSort(T[] list) {
        int length = list.length - 1;
        for (int i = 1; i < length; i++) {
            swap(list, 1, length - i + 1);
            heap.topDown(list, 1, length - i);
        }
        return list;
    }
}
