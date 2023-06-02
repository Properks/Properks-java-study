package org.example.Class;


import org.example.Constants.commonconstants;

import java.text.NumberFormat;

public class Grade {
    private float Score;
    private String Grade;

    public void setScore(Subject subject, float Score) {
        this.Score = Score;
        if (subject.getType().compareTo(commonconstants.EvaluationType[1]) == 0) {
            this.Grade = new Absolute().setGrade(Score);
        }
//        else if (subject.getType().compareTo(commonconstants.EvaluationType[0]) == 0) { // TODO: implement
//            this.Grade = new Relative().setGrade(Score);
//        }
        else {
            System.err.println("Invalid Evaluation type");
        }
    }

    public float getScore() {
        return Score;
    }

    public String getGrade() {
        return Grade;
    }

    public static final String getScoreFormat(float Score) {
        NumberFormat ScoreFormat = NumberFormat.getInstance();
        ScoreFormat.setMaximumFractionDigits(2);
        return ScoreFormat.format(Score);
    }

    @Override
    public String toString() {
        return this.Grade + "(" + getScoreFormat(this.Score) + ")";
    }
}
