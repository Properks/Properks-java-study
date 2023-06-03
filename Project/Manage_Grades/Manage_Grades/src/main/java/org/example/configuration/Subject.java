package org.example.configuration;

import java.util.Objects;

/**
 * Subject
 */
public class Subject implements Comparable<Subject> {// Separate Grade from subject

    private String name; // Subject's name
    private int credit; // 1 ~ 3
    private String type;


    public Subject() {}

    public Subject(String name, int credit, String type) {
        this.name = name;
        this.credit = credit;
        this.type = type;
    }

    public String getName() {
        return name;
    }
    public int getCredit() {
        return credit;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return this.name + "(" + this.credit + ")";
    }
    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Subject subject) && (this.hashCode() == subject.hashCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, credit, type);
    }

    @Override
    public int compareTo(Subject o) {
        return this.name.compareTo(o.name);
    }
}