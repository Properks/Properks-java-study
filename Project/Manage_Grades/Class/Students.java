package Project.Manage_Grades.Class;

import java.util.TreeMap;
/**
 * Students
 */
public class Students extends Grade implements Comparable<Students>{

    private String name;
    private int StudentID;
    private String Major;
    TreeMap<Subject, Grade> Subjectlist = new TreeMap<>(); // Subject is mapping grade

    public Students() {}
    
    public Students(String name, String Major) {
        this.name = name;
        this.Major = Major;
    }

    public void SetStudentID(int StudentID) {
        this.StudentID = StudentID;
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
            return this.name.compareTo(o.name);
        }
        return this.Major.compareTo(o.Major);
    }
}