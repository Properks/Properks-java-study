package Chapter_05;

/**
 * Student
 */
public class Student {
    String name;
    int studentID;
    double grade;

    public void inputName(String str) {
        name = str;
    }
    public void inputStudentID(int ID) {
        studentID = ID;
    }
    public void inputGrade(double score) {
        grade = score;
    }

    public String getName() {
        return name;
    }
    public int getStudentID() {
        return studentID;
    }
    public double getGrade() {
        return grade;
    }
}