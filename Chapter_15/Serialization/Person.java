package Chapter_15.Serialization;

import java.io.Serializable;

/**
 * Person
 */
public class Person implements Serializable{ // Need to mark it can use to Serialization

    private final static long serialVersionUID = 1L; // version ID for serialization
    String name;
    String job; // If you wanna ignore serialization, use transient like `transient String job`

    public Person() {}

    public Person(String name) {
        this.name = name;
        this.job = "??";
    }

    public Person(String name, String job) {
        this.name = name;
        this.job = job;
    }

    @Override
    public String toString() {
        return "(" + this.name + ", " + this.job + ")";
    }
}