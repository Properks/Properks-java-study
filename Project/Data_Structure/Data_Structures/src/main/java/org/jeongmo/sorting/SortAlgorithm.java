package org.jeongmo.sorting;

public interface SortAlgorithm {
    <T extends Comparable<T>> T[] sort(T[] list);
}