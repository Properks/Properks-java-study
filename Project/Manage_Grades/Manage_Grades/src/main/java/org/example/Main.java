package org.example;

import org.example.Class.*;
import org.example.Data.students;
import org.example.Interface.*;
import org.example.Constants.*;

import java.lang.ClassCastException;
import java.util.Iterator;
import java.util.TreeSet;
/**
 * Manage_Grades
 */
public class Main {

    public static void main(String[] args) throws ClassCastException {
        TreeSet<Students> StudentList = new TreeSet<>();
        students.setList(StudentList);

        SetAllOfStudentID(StudentList);
        printList(StudentList);
    }

    public static void SetAllOfStudentID(TreeSet<Students> StudentList) {
        Iterator<Students> ir= StudentList.iterator();
        Students nextTemp, temp = ir.next(); // Set 2 Students to compare
        int Last = 1, ID;
        while (ir.hasNext()) {
            ID = commonconstants.Year * 100000 + commonconstants.MajorStudentID.get(temp.getMajor()) * 100 + Last;
            temp.SetStudentID(ID);

            nextTemp = ir.next(); // Increment operator
            if (nextTemp.getMajor().compareTo(temp.getMajor()) == 0) { // If major of student in temp is same as major of Next student
                Last++;
            }
            else { // Doesn't same
                Last = 1;
            }
            temp = nextTemp; // Set temp like Increment operator
        }
        ID = commonconstants.Year * 100000 + commonconstants.MajorStudentID.get(temp.getMajor()) * 100 + Last;
        temp.SetStudentID(ID);
    }

    public static void printList(TreeSet<Students> list) {
        for (Students students : list) {
            System.out.println(students);
            System.out.println("Subject : ");
            Iterator<Subject> ir = students.getList().keySet().iterator();
            Subject temp;
            while (ir.hasNext()) {
                temp = ir.next();
                System.out.println(temp + " : " + students.getList().get(temp));
            }
        }
    }
}