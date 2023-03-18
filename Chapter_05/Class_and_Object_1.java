package Chapter_05;

/**
 * Class_and_Object_1
 */
public class Class_and_Object_1 {

    public static void main(String[] args) {
        Student stu = new Student(); // Can declare new class, if it is in same package.

        stu.inputName("John");
        stu.inputStudentID(202210981);
        stu.inputGrade(4.23);

        System.out.println("Name : " + stu.getName());
        System.out.println("ID : " + stu.getStudentID());
        System.out.println("Grade : " + stu.getGrade());
    }
}