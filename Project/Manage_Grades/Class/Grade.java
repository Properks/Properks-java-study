package Project.Manage_Grades.Class;

import Project.Manage_Grades.Constants.commonconstants;

public class Grade {
    private float Score;
    private String Grade;

    public void setScore(Subject subject, float Score) {
        this.Score = Score;
        if (subject.getType().compareTo(commonconstants.EvaluationType[1]) == 0) {
            this.Grade = new Relative().setGrade(Score);
        }
        // else if (subject.getType().compareTo(commonconstants.EvaluationType[0]) == 0) {
        //     this.Grade = new Absolute().setGrade(Score);
        // }
        else {
            System.err.println("Invalid Evaluation type");
            return;
        }
    }

    public float getScore() {
        return Score;
    }

    public String getGrade() {
        return Grade;
    }

    @Override
    public String toString() {
        return this.Grade + "(" + this.Score + ")";
    }
}
