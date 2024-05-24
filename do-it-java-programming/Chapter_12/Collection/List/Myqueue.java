package Chapter_12.Collection.List;

import java.util.ArrayList;

/**
 * Myqueue
 */
public class Myqueue<T> {

    ArrayList<T> queue;

    public Myqueue() {
        queue = new ArrayList<>();
    }

    public void push(T x) {
        queue.add(x);
    }

    public T pop() {
        if (queue.isEmpty()) {
            System.err.println("Stack is empty");
            return null;
        }
        else {
            T temp = queue.get(0);
            queue.remove(0);
            return temp;
        }
    }

    public void showInfo() {
        System.out.println(queue);
    }

    public boolean isEmpty() {
        if (queue.isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }

    public int size() {
        return queue.size();
    }
}