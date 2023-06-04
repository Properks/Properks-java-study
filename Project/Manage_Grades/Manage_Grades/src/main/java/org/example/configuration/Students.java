package org.example.configuration; // Folder name is all lower case

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.logging.Logger;

/**
 * Students
 */
public class Students extends Grade implements Comparable<Students>{

    private static final Logger logger = Logger.getLogger(Students.class.getName());
    private String name;
    private int studentID; // Variable's first letter is lower, and space is upper instead of '_'
    private String major;
    Map<Subject, Grade> subjectList = new TreeMap<>(); // Subject is mapping grade
    
    // Constructor
    public Students() {}

    public Students(String name, String major) {
        this.name = name;
        this.major = major;
    }

    // Subject and score
    public void addSubject(Subject add) { // Don't be duplicated
        Iterator<Subject> ir = subjectList.keySet().iterator();
        Subject temp;
        while (ir.hasNext()) {
            temp = ir.next();
            if (temp.equals(add)) {
                logger.warning(() -> add.getName() + " already have....");
                return;
            }
        }
        subjectList.put(add, new Grade());
    }

    public void setScoreAndGrade(Subject subject, float score) { // Set subject grade each student
        Grade temp = new Grade();
        temp.setScore(subject, score);
        subjectList.replace(subject, temp);
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return this.name;
    }

    public int getStudentID() {
        return this.studentID;
    }

    public String getMajor() {
        return this.major;
    }

    public Map<Subject, Grade> getList() { // the result of an instantiation should ideally be stored in a variable whose type is a Java Collection interface.
        return subjectList;
    }

    @Override
    public String toString() {
        return this.name + "(" + this.studentID + ")"  + " : " + this.major;
    }

    @Override
    public int compareTo(Students o) {
        if (this.major.compareTo(o.major) == 0) {
            return this.name.compareTo(o.name);
        }
        return this.major.compareTo(o.major);
    }

    @Override
    public boolean equals(Object o) { // Need it to use compareTo
        if (o == null) return false;
        return (o instanceof Students student) && (this.hashCode() == student.hashCode());
    }

    @Override
    public int hashCode() { // Need it to use equals
        return Objects.hash(name, studentID, major, subjectList);
    }
}