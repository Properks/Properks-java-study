package Chapter_05;

/**
 * Student
 */
public class Student {
    private String name;
    private int studentID;
    private double grade;
    Subject korean; // subject class
    Subject english;

    public Student(){}
    public Student(String strname, int intID, double korScore, double engScore){
        name = strname;
        studentID = intID;
        korean = new Subject("korea", korScore); // Not Subject korean = new Subject("korea", korScore);
        english = new Subject("english", engScore);
        grade = (korScore + engScore) / 2;
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
    public void printData() {
        System.out.println("Name : " + name + "(" + studentID + ")");
        System.out.println("Grade : " + grade + " (Korea : " + korean.score + ", English : " + english.score +")");
    }
}