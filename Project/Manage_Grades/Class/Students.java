package Project.Manage_Grades.Class;

import java.util.ArrayList;
/**
 * Students
 */
public class Students implements Comparable<Students>{

    private String name;
    private int StudentID;
    private String Major;
    private ArrayList<Subject> SubjectList = new ArrayList<>();

    public Students() {}
    
    public Students(String name, String Major) {
        this.name = name;
        this.Major = Major;
    }

    public String getName() {
        return this.name;
    }

    public int getStudentID() {
        return this.StudentID;
    }

    public String getMajor() {
        return this.Major;
    }

    @Override
    public String toString() {
        return this.name + "(" + this.StudentID + ")"  + " : " + this.Major;
    }

    @Override
    public int compareTo(Students o) {
        if (this.Major.compareTo(o.Major) == 0) {
            return this.StudentID - o.StudentID;
        }
        return this.Major.compareTo(o.Major);
    }
}