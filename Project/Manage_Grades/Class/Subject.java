package Project.Manage_Grades.Class;

/**
 * Subject
 */
public class Subject { // Separate Grade from subject

    private String name; // Subject's name
    private int Credit; // 1 ~ 3


    public Subject() {}

    public Subject(String name, int Credit) {
        this.name = name;
        this.Credit = Credit;
    }

    public String getName() {
        return name;
    }
    public int getCredit() {
        return Credit;
    }
}