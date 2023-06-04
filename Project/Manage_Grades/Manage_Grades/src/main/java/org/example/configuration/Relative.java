package org.example.configuration; // Folder name is all lower case

import org.example.interfaces.CalculateGrade;
/**
 * Relative
 */
public class Relative implements CalculateGrade {

    @Override
    public String setGrade(float gradeOrPercentile) {
        if (gradeOrPercentile > 0.95f) {
            return "A+";
        }
        else if (gradeOrPercentile > 0.9f) {
            return "A";
        }
        else if (gradeOrPercentile > 0.85f) {
            return "B+";
        }
        else if (gradeOrPercentile > 0.8f) {
            return "B";
        }
        else if (gradeOrPercentile > 0.75f) {
            return "C+";
        }
        else if (gradeOrPercentile > 0.7f) {
            return "C";
        }
        else if (gradeOrPercentile > 0.65f) {
            return "D+";
        }
        else if (gradeOrPercentile > 0.6f) {
            return "D";
        }
        else {
            return "F";
        }
    }
}