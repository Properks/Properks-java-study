package Project.Manage_Grades.Class;

import Project.Manage_Grades.Interface.Calculate_Grade;

/**
 * Absolute
 */
public class Absolute implements Calculate_Grade{

    @Override
    public String setGrade(float GradeOrPercentile) { // it is Grade in this function
        if (GradeOrPercentile > 4.275f) {
            return "A+";
        }
        else if (GradeOrPercentile > 4.05f) {
            return "A";
        }
        else if (GradeOrPercentile > 3.825f) {
            return "B+";
        }
        else if (GradeOrPercentile > 3.6f) {
            return "B";
        }
        else if (GradeOrPercentile > 3.375f) {
            return "C+";
        }
        else if (GradeOrPercentile > 3.15f) {
            return "C";
        }
        else if (GradeOrPercentile > 2.925f) {
            return "D+";
        }
        else if (GradeOrPercentile > 2.7f) {
            return "D";
        }
        else {
            return "F";
        }
    }
}