package org.jeongmo.sorting;

public abstract class Sort {

    protected long time;

    public Sort(){
        this.time = 0L;
    }

    abstract <T extends Comparable<T>> T[] sort(T[] list);

    public static <T> void swap(T[] array, int first, int second) {
        T temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public long getTime() {
        return time;
    }
}
