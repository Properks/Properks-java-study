package org.jeongmo.heap;

import org.jeongmo.sorting.Sort;

import java.lang.reflect.Array;


public class Heap {


    private <T extends Comparable<T>>void bottomUp(T[] list, int index) {
        if (index == 1) {
            return;
        }

        if (list[index].compareTo(list[index / 2]) > 0) {
            Sort.swap(list, index, index / 2);
            bottomUp(list, index / 2);
        }
    }

    private <T extends Comparable<T>> void topDown(T[] list, int index) {
        int leftChild = 2 * index;
        int rightChild = 2 * index + 1;
        int max = index;
        if (leftChild <= list.length && list[max].compareTo(list[leftChild]) < 0) {
            max = leftChild;
        }
        else if (rightChild <= list.length && list[max].compareTo(list[rightChild]) < 0) {
            max =  rightChild;
        }
        if (max != index) {
            Sort.swap(list, index, max);
            topDown(list, max);
        }
    }

    public <T extends Comparable<T>> T[] buildHeap(T[] list) {
        T[] heap = (T[]) Array.newInstance(list.getClass().getComponentType(), list.length + 1);
        int index = 1;
        for (T element:list) {
            heap[index++] = element;
        }

        int length = list.length;
        for (int i = length / 2; i >= 1; i--) {
            topDown(heap, i);
        }
        return heap;
    }

//    public void addElement(T[] list, T element) {
//        data[++count] = element;
//        bottomUp(count);
//    }
//
//    public Integer pop() {
//        Integer temp = data[1];
//        data[1] = data[count];
//        topDown(1);
//        return temp;
//    }

}
