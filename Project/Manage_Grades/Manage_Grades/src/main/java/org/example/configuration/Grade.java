package org.example.configuration;


import org.example.constants.CommonConstants;

import java.text.NumberFormat;
import java.util.logging.Logger;

public class Grade {
    private float score;
    private String achievement;

    public void setScore(Subject subject, float score) {
        this.score = score;
        if (subject.getType().compareTo(CommonConstants.getType(1)) == 0) {
            this.achievement = new Absolute().setGrade(score);
        }
        // TODO: implement Relative
        else {
            Logger.getLogger(this.getClass().getName()).warning("Invalid Evaluation type");
        }
    }

    public float getScore() {
        return score;
    }

    public String getAchievement() {
        return achievement;
    }

    public static String getScoreFormat(float score) {
        NumberFormat scoreFormat = NumberFormat.getInstance();
        scoreFormat.setMaximumFractionDigits(2);
        return scoreFormat.format(score);
    }

    @Override
    public String toString() {
        return this.achievement + " (" + getScoreFormat(this.score) + ")";
    }
}
