package org.example.Class;

import org.example.Interface.Calculate_Grade;
/**
 * Relative
 */
public class Relative implements Calculate_Grade{

    @Override
    public String setGrade(float GradeOrPercentile) {
        if (GradeOrPercentile > 0.95f) {
            return "A+";
        }
        else if (GradeOrPercentile > 0.9f) {
            return "A";
        }
        else if (GradeOrPercentile > 0.85f) {
            return "B+";
        }
        else if (GradeOrPercentile > 0.8f) {
            return "B";
        }
        else if (GradeOrPercentile > 0.75f) {
            return "C+";
        }
        else if (GradeOrPercentile > 0.7f) {
            return "C";
        }
        else if (GradeOrPercentile > 0.65f) {
            return "D+";
        }
        else if (GradeOrPercentile > 0.6f) {
            return "D";
        }
        else {
            return "F";
        }
    }
}