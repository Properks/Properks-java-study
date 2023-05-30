package org.example;

import org.example.Class.*;
import org.example.Interface.*;
import org.example.Constants.*;

import java.util.Iterator;
import java.util.TreeSet;
/**
 * Manage_Grades
 */
public class Main {

    public static void main(String[] args) {
        TreeSet<Students> StudentList = new TreeSet<>();

        StudentList.add(new Students("Andrew", commonconstants.MajorList.get(0)));
        StudentList.add(new Students("Asher", commonconstants.MajorList.get(1)));
        StudentList.add(new Students("Benjamin", commonconstants.MajorList.get(2)));
        StudentList.add(new Students("Eric", commonconstants.MajorList.get(0)));
        StudentList.add(new Students("George", commonconstants.MajorList.get(2)));
        StudentList.add(new Students("Henry", commonconstants.MajorList.get(0)));
        StudentList.add(new Students("Harry", commonconstants.MajorList.get(1)));
        StudentList.add(new Students("James", commonconstants.MajorList.get(1)));

        SetAllOfStudentID(StudentList);
        printList(StudentList);
    }

    public static void SetAllOfStudentID(TreeSet<Students> StudentList) {
        Iterator<Students> ir= StudentList.iterator();
        Students nextTemp, temp = ir.next(); // Set 2 Students to compare
        int Lastnumber = 1, ID;
        while (ir.hasNext()) {
            ID = commonconstants.Year * 100000 + commonconstants.MajorStudentID.get(temp.getMajor()) * 100 + Lastnumber;
            temp.SetStudentID(ID);

            nextTemp = ir.next(); // Increment operator
            if (nextTemp.getMajor().compareTo(temp.getMajor()) == 0) { // If major of student in temp is same as major of Next student
                Lastnumber++;
            }
            else { // Doesn't same
                Lastnumber = 1;
            }
            temp = nextTemp; // Set temp like Increment operator
        }
        ID = commonconstants.Year * 100000 + commonconstants.MajorStudentID.get(temp.getMajor()) * 100 + Lastnumber;
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