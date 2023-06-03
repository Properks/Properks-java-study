package org.example.configuration;

import org.example.Interface.Calculate_Grade;

/**
 * Absolute
 */
public class Absolute implements Calculate_Grade{

    @Override
    public String setGrade(float gradeOrPercentile) { // it is Grade in this function
        if (gradeOrPercentile > 4.275f) {return "A+";}
        else if (gradeOrPercentile > 4.05f) {return "A";}
        else if (gradeOrPercentile > 3.825f) {return "B+";}
        else if (gradeOrPercentile > 3.6f) {return "B";}
        else if (gradeOrPercentile > 3.375f) {return "C+";}
        else if (gradeOrPercentile > 3.15f) {return "C";}
        else if (gradeOrPercentile > 2.925f) {return "D+";}
        else if (gradeOrPercentile > 2.7f) {return "D";}
        else {return "F";}
    }
}