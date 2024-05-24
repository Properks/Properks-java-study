package Chapter_15.Serialization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * Person
 */
public class Person implements Externalizable{ // Need to mark it can use to Serialization

    private final static long serialVersionUID = 1L; // version ID for serialization
    private String name;
    private String job; // If you wanna ignore serialization, use transient like `transient String job`

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
        // return "(" + this.name + ", " + this.job + ")";
        return this.name;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(this.name);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = in.readUTF();
    }
}