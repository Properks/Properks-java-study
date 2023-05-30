package Project.Manage_Grades.Class;

/**
 * Subject
 */
public class Subject { // Separate Grade from subject

    private String name; // Subject's name
    private int Credit; // 1 ~ 3
    private String type;


    public Subject() {}

    public Subject(String name, int Credit, String type) {
        this.name = name;
        this.Credit = Credit;
        this.type = type;
    }

    public String getName() {
        return name;
    }
    public int getCredit() {
        return Credit;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return this.name + "(" + this.Credit + ")";
    }
    @Override
    public boolean equals(Object obj) {
        if (this.getName().compareTo(((Subject)obj).getName()) == 0 && this.getCredit() == ((Subject)obj).getCredit()) {
            return true;
        }
        return false;
    }
}