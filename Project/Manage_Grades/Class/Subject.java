package Project.Manage_Grades.Class;

import Project.Manage_Grades.Interface.Calculate_Grade;
/**
 * Subject
 */
public class Subject implements Calculate_Grade{

    String name; // Subject's name
    int Credit; // 1 ~ 3
    float Score; // 0.0 ~ 4.5
    String Grade; // A+ ~ F
}