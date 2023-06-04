package org.example.constants; // Folder name is all lower case

import java.util.List;
import java.util.Map;

/**
 * CommonConstants
 */
public class CommonConstants { // Class name's first letter is capital

    private CommonConstants() {} // This class doesn't have public constructor. But java add an implicit public
    // constructor. So, I need to make at least one private constructor

    public static final int YEAR = 2023;
    public static final List<String> MajorList = List.of("Animation", "Architecture", "Business", "Computer", "Game", "Law", "Sports");
    public static final Map<String, Integer> MajorStudentID = Map.of
    (MajorList.get(0), 101, MajorList.get(1), 102, MajorList.get(2), 103, MajorList.get(3), 104, MajorList.get(4), 105, MajorList.get(5), 106, MajorList.get(6), 107);
    private static final String[] EvaluationType = {"Relative", "Absolute"}; // If it is declared with public, It can
    // be modified
    public static String getType(int index) { // In order to access to EvaluationType
        return EvaluationType.clone()[index];
    }
}