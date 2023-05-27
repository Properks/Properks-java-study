package Project.Manage_Grades;

import Project.Manage_Grades.Interface.*;
import Project.Manage_Grades.Class.*;
import Project.Manage_Grades.Constants.*;

import java.util.Iterator;
import java.util.TreeSet;
/**
 * Manage_Grades
 */
public class Manage_Grades {

    public static void main(String[] args) {
        TreeSet<Students> StudentList = new TreeSet<>();
        
        SetStudentID(StudentList);
        for (Students students : StudentList) {
            System.out.println(students);
        }
    }

    public static void AddInList(TreeSet<Students> List, String name, String Major) {
        List.add(new Students(name, Major));
    }

    public static void SetStudentID(TreeSet<Students> StudentList) {
        Iterator<Students> ir= StudentList.iterator();
        
    }
}