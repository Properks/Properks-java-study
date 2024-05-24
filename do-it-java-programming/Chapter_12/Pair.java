package Chapter_12;

/**
 * Pair
 */
public class Pair<T, E> {

    protected T key;
    protected E value;

    public Pair() { // Constructor.
        this.key = null;
        this.value = null;
    }

    public Pair(T key, E value) { // Constructor with Key and Value
        this.key = key;
        this.value = value;
    }

    public void set(T key, E value) { // Set Key and Value
        this.key = key;
        this.value = value;
    }

    public E getValue() { // return Value in order to find Key in map
        return value;
    }
}