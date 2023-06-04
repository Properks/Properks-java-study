package org.example;

import org.example.configuration.*;
import org.example.data.*;
import org.example.constants.*;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.*;
import java.util.logging.Logger;

/**
 * Manage_Grades
 */
public class Main {

    private static SecureRandom rand; // Use SecureRandom with private static variable in class(not function)
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    static { // Because rand is static variable
        try { // try-catch NoSuchAlgorithmException
            rand = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Declare
        Set<Students> studentList = new TreeSet<>();
        StudentsList.setList(studentList);
        Set<Subject> subjectSet = Set.of(SubjectList.getList());

        //Set and print
        setAllOfStudentID(studentList);
        setSubjectEachStudent(studentList, subjectSet);
        setGradeEachSubject(studentList);
        printList(studentList);

        logger.info(() -> "The number of Students : " + studentList.size());
    }

    public static void setAllOfStudentID(Set<Students> studentList) { // Set student ID with rule + It is ideal, If
        // Param and argue is interface
        Iterator<Students> ir= studentList.iterator();
        Students nextTemp;
        Students temp = ir.next(); // Set 2 Students to compare
        int last = 1;
        int id;
        while (ir.hasNext()) {
            id = CommonConstants.YEAR * 100000 + CommonConstants.MajorStudentID.get(temp.getMajor()) * 100 + last;
            temp.setStudentID(id);

            nextTemp = ir.next(); // Increment operator
            if (nextTemp.getMajor().compareTo(temp.getMajor()) == 0) { // If major of student in temp is same as major of Next student
                last++;
            }
            else { // Doesn't same
                last = 1;
            }
            temp = nextTemp; // Set temp like Increment operator
        }
        id = CommonConstants.YEAR * 100000 + CommonConstants.MajorStudentID.get(temp.getMajor()) * 100 + last; // Last student
        temp.setStudentID(id);
    }

    public static void printList(Set<Students> list) { // Print list + It is ideal, If Param and argue is interface
        for (Students students : list) {
            logger.info(students::toString);// print student info
            logger.info("Subject : "); // Print subject
            for (Subject temp : students.getList().keySet()) { // Fix it with for loop statement
                logger.info(() -> "\t" + temp + " : " + students.getList().get(temp));
                // TODO: When do I use final and ::toString in lamda
            }
            logger.info("\n");
        }
    }

    public static void setSubjectEachStudent(Set<Students> list, Set<Subject> subjectSet) { // Set subject Randomly + It is ideal, If Param and argue is interface
        ArrayList<Students> removeList = new ArrayList<>();
        for (Students student :
                list) {
            for (Subject subject :
                    subjectSet) {
                 if (rand.nextInt(10) < 2){ // probability : 1/2^3
                     student.addSubject(subject);
                 }
            }
            if (student.getList().keySet().size() < 4) {
                removeList.add(student); // If I remove student in loop has Exception Because of index
            }
        }

        for (Students student : // Remove student that have under 4 subjects from list
                removeList) {
             list.remove(student);
        }
    }
    
    public static void setGradeEachSubject(Set<Students> list) { // Set Score randomly + It is ideal, If Param and argue is interface
        for (Students student :
                list) {
            for (Subject subject :
                    student.getList().keySet()) {
                float randScore = rand.nextFloat(2) + 2.5f; // 2.5 ~ 4.5
                student.setScoreAndGrade(subject, randScore);
            }
        }
    }
}