package org.example;

import org.example.Class.*;
import org.example.Data.*;
import org.example.Constants.*;

import java.lang.ClassCastException;
import java.util.*;

/**
 * Manage_Grades
 */
public class Main {

    public static void main(String[] args) throws ClassCastException {
        // Declare
        TreeSet<Students> StudentList = new TreeSet<>();
        students.setList(StudentList);
        Set<Subject> subjectSet = Set.of(subject.list);

        //Set and print
        SetAllOfStudentID(StudentList);
        SetSubjectEachStudent(StudentList, subjectSet);
        printList(StudentList);

        System.out.println("The number of Students : " + StudentList.size());
    }

    public static void SetAllOfStudentID(TreeSet<Students> StudentList) { // Set student ID with rule
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
        ID = commonconstants.Year * 100000 + commonconstants.MajorStudentID.get(temp.getMajor()) * 100 + Last; // Last student
        temp.SetStudentID(ID);
    }

    public static void printList(TreeSet<Students> list) { // Print list
        for (Students students : list) {
            System.out.println(students); // print student info
            System.out.println("Subject : "); // Print subject
            Iterator<Subject> ir = students.getList().keySet().iterator();
            Subject temp;
            while (ir.hasNext()) {
                temp = ir.next();
                System.out.println("\t" + temp);
//                System.out.println("\t" + temp + " : " + students.getList().get(temp));
            }
            System.out.println();
        }
    }

    public static void SetSubjectEachStudent(TreeSet<Students> list, Set<Subject> subjectSet) {
        Random randBool= new Random();
        ArrayList<Students> removeList = new ArrayList<>();
        for (Students student :
                list) {
            for (Subject subject :
                    subjectSet) {
                 if (randBool.nextBoolean() && randBool.nextBoolean() && randBool.nextBoolean()) { // probability : 1/2^3
                     student.addSubject(subject);
                 }
            }
            if (student.getList().keySet().size() < 4) {
                removeList.add(student); // If I remove student in loop has Exception Because of index
            }
        }

        for (Students student :
                removeList) {
             list.remove(student);
        }
    }
}