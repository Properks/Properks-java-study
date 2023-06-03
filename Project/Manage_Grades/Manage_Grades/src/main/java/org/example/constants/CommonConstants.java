package org.example.constants;

import java.util.List;
import java.util.Map;

/**
 * CommonConstants
 */
public class CommonConstants {

    private CommonConstants() {}

    public static final int YEAR = 2023;
    public static final List<String> MajorList = List.of("Animation", "Architecture", "Business", "Computer", "Game", "Law", "Sports");
    public static final Map<String, Integer> MajorStudentID = Map.of
    (MajorList.get(0), 101, MajorList.get(1), 102, MajorList.get(2), 103, MajorList.get(3), 104, MajorList.get(4), 105, MajorList.get(5), 106, MajorList.get(6), 107);
    private static final String[] EvaluationType = {"Relative", "Absolute"};
    public static String getType(int index) {
        return EvaluationType[index];
    }
}