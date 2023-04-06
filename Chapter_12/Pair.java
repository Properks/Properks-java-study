package Chapter_12;

/**
 * Pair
 */
public class Pair<T, E> {

    protected T key;
    protected E value;

    public Pair(T key, E value) {
        this.key = key;
        this.value = value;
    }

    public void set(T key, E value) {
        this.key = key;
        this.value = value;
    }

    public E getValue() {
        return value;
    }
}