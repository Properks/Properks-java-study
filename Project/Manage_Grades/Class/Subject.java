package Project.Manage_Grades.Class;

/**
 * Subject
 */
public class Subject extends Absolute{

    private String name; // Subject's name
    private int Credit; // 1 ~ 3
    private float Score; // 0.0 ~ 4.5
    private String Grade; // A+ ~ F


    public Subject() {}

    public Subject(String name, int Credit) {
        this.name = name;
        this.Credit = Credit;
    }

    public void setScore(int Score) {
        this.Score = Score;
    }

    public String getName() {
        return name;
    }
    public int getCredit() {
        return Credit;
    }
    public String getGrade() {
        return Grade;
    }
    public float getScore() {
        return Score;
    }
}