package org.example.Constants;

import java.util.List;
import java.util.Map;

/**
 * commonconstants
 */
public class commonconstants {

    public static final int Year = 2023;
    public static final List<String> MajorList = List.of("Animation", "Architecture", "Business", "Computer", "Game", "Law", "Sports");
    public static final Map<String, Integer> MajorStudentID = Map.of
    (MajorList.get(0), 101, MajorList.get(1), 102, MajorList.get(2), 103, MajorList.get(3), 104, MajorList.get(4), 105, MajorList.get(5), 106, MajorList.get(6), 107);
    public static final String[] EvaluationType = {"Relative", "Absolute"};
}