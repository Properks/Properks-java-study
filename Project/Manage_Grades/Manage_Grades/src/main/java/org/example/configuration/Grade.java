package org.example.configuration; // Folder name is all lower case


import org.example.constants.CommonConstants;

import java.text.NumberFormat;
import java.util.logging.Logger;

public class Grade {

    private static final Logger logger = Logger.getLogger(Grade.class.getName());
    private float score; // Variable's first letter is lower, and space is upper instead of '_'
    private String achievement; // Variable's first letter is lower, and space is upper instead of '_'

    public void setScore(Subject subject, float score) {
        this.score = score;
        if (subject.getType().compareTo(CommonConstants.getType(1)) == 0) {
            this.achievement = new Absolute().setGrade(score);
        }
        // TODO: implement Relative
        else {
            logger.warning("Invalid Evaluation type");
        }
    }

    public float getScore() {
        return score;
    }

    public String getAchievement() {
        return achievement;
    }

    public static String getScoreFormat(float score) {
        NumberFormat scoreFormat = NumberFormat.getInstance(); // Show up to 2 decimal places
        scoreFormat.setMaximumFractionDigits(2);
        return scoreFormat.format(score);
    }

    @Override
    public String toString() {
        return this.achievement + " (" + getScoreFormat(this.score) + ")";
    }
}
