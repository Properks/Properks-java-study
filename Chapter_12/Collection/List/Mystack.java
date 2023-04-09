package Chapter_12.Collection.List;

import java.util.ArrayList;

/**
 * Mystack
 */
public class Mystack<T> {

    ArrayList<T> stack;

    public Mystack() {
        stack = new ArrayList<>();
    }

    public void pop() {
        if (stack.isEmpty()) {
            System.err.println("Stack is empty");
        }
        else {
            stack.remove(stack.size() - 1);
        }
    }

    public T top() {
        if (stack.isEmpty()) {
            System.err.println("Stack is empty");
            return null;
        }
        else {
            return stack.get(stack.size() - 1);
        }
    }

    public void push(T x) {
        stack.add(x);
    }

    public void showInfo() {
        System.out.println(stack);
    }
}