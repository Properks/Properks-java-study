package org.example.data; // Folder name is all lower case

import org.example.configuration.Students;
import org.example.constants.CommonConstants;

import java.util.Set;

public class StudentsList { // Class name's first letter is capital

    private StudentsList() {} // This class doesn't have public constructor. But java add an implicit public
    // constructor. So, I need to make at least one private constructor
    public static void setList(Set<Students> list) { // 31 Students + It is ideal, If Param and argue is interface
        list.add(new Students("Andrew", CommonConstants.MajorList.get(0)));
        list.add(new Students("Asher", CommonConstants.MajorList.get(1)));
        list.add(new Students("Benjamin", CommonConstants.MajorList.get(2)));
        list.add(new Students("Eric", CommonConstants.MajorList.get(0)));
        list.add(new Students("George", CommonConstants.MajorList.get(2)));
        list.add(new Students("Henry", CommonConstants.MajorList.get(0)));
        list.add(new Students("Harry", CommonConstants.MajorList.get(1)));
        list.add(new Students("James", CommonConstants.MajorList.get(1)));
        list.add(new Students("Brian", CommonConstants.MajorList.get(6)));
        list.add(new Students("Brook", CommonConstants.MajorList.get(5)));
        list.add(new Students("Cherry", CommonConstants.MajorList.get(6)));
        list.add(new Students("Emilly", CommonConstants.MajorList.get(3)));
        list.add(new Students("Auther", CommonConstants.MajorList.get(4)));
        list.add(new Students("Katie", CommonConstants.MajorList.get(3)));
        list.add(new Students("Melissa", CommonConstants.MajorList.get(4)));
        list.add(new Students("Tracy", CommonConstants.MajorList.get(4)));
        list.add(new Students("Dorothy", CommonConstants.MajorList.get(0)));
        list.add(new Students("Brian", CommonConstants.MajorList.get(5)));
        list.add(new Students("Alice", CommonConstants.MajorList.get(0)));
        list.add(new Students("Lisa", CommonConstants.MajorList.get(2)));
        list.add(new Students("Evelyn", CommonConstants.MajorList.get(5)));
        list.add(new Students("Jinny", CommonConstants.MajorList.get(0)));
        list.add(new Students("Jessica", CommonConstants.MajorList.get(0)));
        list.add(new Students("Jennifer", CommonConstants.MajorList.get(0)));
        list.add(new Students("Helen", CommonConstants.MajorList.get(5)));
        list.add(new Students("Katelyn", CommonConstants.MajorList.get(6)));
        list.add(new Students("Natalie", CommonConstants.MajorList.get(6)));
        list.add(new Students("Nicole", CommonConstants.MajorList.get(4)));
        list.add(new Students("Paula", CommonConstants.MajorList.get(3)));
        list.add(new Students("Victoria", CommonConstants.MajorList.get(2)));
        list.add(new Students("Sarah", CommonConstants.MajorList.get(4)));
    }
}
