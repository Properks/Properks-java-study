package Chapter_05;

/**
 * Subject
 */
public class Subject {
    private String subjectName; // private variable
    double score;

    public Subject() {} // constructor
    public Subject(String name, double scoreOfSubject) {
        subjectName = name;
        score = scoreOfSubject;
    }
    public void setScore(double scoreOfSubject) {
        score = scoreOfSubject;
    }
    public String getsubjectName() {
        return subjectName;
    }
}