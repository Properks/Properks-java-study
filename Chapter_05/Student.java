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
    public static void main(String[] args) {
        Student firstStudent = new Student();
        firstStudent.inputName("John");
        firstStudent.inputStudentID(202210981);
        firstStudent.inputGrade(4.23);

        System.out.println("Name : " + firstStudent.getName());
        System.out.println("ID : " + firstStudent.getStudentID());
        System.out.println("Grade : " + firstStudent.getGrade());
    }
}