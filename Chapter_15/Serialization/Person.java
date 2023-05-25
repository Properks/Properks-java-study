package Chapter_15.Serialization;

import java.io.Serializable;

/**
 * Person
 */
public class Person implements Serializable{ // Need to mark it can use to Serialization

    String name;
    String job;

    public Person() {}

    public Person(String name) {
        this.name = name;
        this.job = "??";
    }

    public Person(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String toString() {
        return "(" + this.name + ", " + this.job + ")";
    }
}