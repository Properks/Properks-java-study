package Project.Manage_Grades.Class;

import java.util.TreeMap;
import java.util.Iterator;
/**
 * Students
 */
public class Students extends Grade implements Comparable<Students>{

    private String name;
    private int StudentID;
    private String Major;
    TreeMap<Subject, Grade> Subjectlist = new TreeMap<>(); // Subject is mapping grade
    // TODO: Implement SetSubject and SetGrade each subject
    // Constructor
    public Students() {}
    
    public Students(String name, String Major) {
        this.name = name;
        this.Major = Major;
    }

    // Subject and score
    public void addSubject(Subject add) {
        Iterator<Subject> ir = Subjectlist.keySet().iterator();
        Subject temp;
        while (ir.hasNext()) {
            temp = ir.next();
            if (temp.equals(add)) {
                System.err.println(add.getName() + " already have....");
                return;
            }
        }
        Subjectlist.put(add, new Grade());
    }

    public void setScore(Subject subject, float Score) {
        Grade temp = new Grade();
        temp.setScore(subject, Score);
        Subjectlist.replace(subject, temp);
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